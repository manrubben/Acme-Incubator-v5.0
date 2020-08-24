
package acme.features.investor.application;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Application;
import acme.entities.ApplicationStatus;
import acme.entities.Configuration;
import acme.entities.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class InvestorApplicationCreateService implements AbstractCreateService<Investor, Application> {

	@Autowired
	InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		InvestmentRound investmentRound = this.repository.findInvestmentRoundById(request.getModel().getInteger("InvestmentRoundId"));

		Boolean finn = investmentRound.getFinalMode();
		Boolean NoApp = this.repository.exists(request.getModel().getInteger("InvestmentRoundId"), request.getPrincipal().getActiveRoleId()).isEmpty();
		return finn && NoApp && investmentRound.getFinalMode();

	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!request.isMethod(HttpMethod.GET)) {
			InvestmentRound investmentRound = entity.getInvestmentRound();
			request.getModel().setAttribute("investmentRound", investmentRound);
		}
		request.bind(entity, errors, "creation", "status", "investor");
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "statement", "money", "investmentRound");
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		Application result = new Application();
		LocalDateTime creation;
		creation = LocalDateTime.now();
		Principal principal = request.getPrincipal();
		InvestmentRound investmentRound = this.repository.findInvestmentRoundById(request.getModel().getInteger("InvestmentRoundId"));
		Investor investor = this.repository.findInvestorById(principal.getActiveRoleId());
		result.setInvestmentRound(investmentRound);
		result.setInvestor(investor);
		result.setStatus(ApplicationStatus.PENDING);
		result.setCreation(creation);

		return result;

	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("statement")) {
			boolean isSpam = config.isSpam(entity.getStatement());
			errors.state(request, !isSpam, "statement", "investor.application.error.spam");
		}

		if (!errors.hasErrors("money")) {
			Boolean isEur = entity.getMoney().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
			errors.state(request, isEur, "money", "investor.application.error.money");
		}

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}
}
