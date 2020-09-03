
package acme.features.entrepreneur.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Application;
import acme.entities.ApplicationStatus;
import acme.entities.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurApplicationUpdateService implements AbstractUpdateService<Entrepreneur, Application> {

	@Autowired
	EntrepreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		Principal principal = request.getPrincipal();
		Application app;
		int id = request.getModel().getInteger("id");
		app = this.repository.findOneApplicationById(id);
		InvestmentRound investmentRound = app.getInvestmentRound();
		boolean result = principal.getActiveRoleId() == investmentRound.getEntrepreneur().getId();
		return result;

	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creation");

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.transfer(request.getModel(), "pend");
		request.transfer(request.getModel(), "accept");
		request.transfer(request.getModel(), "reject");

		request.unbind(entity, model, "ticker", "creation", "status", "statement", "money", "justification", "offer", "link", "password");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;
		Application result;
		int id = request.getModel().getInteger("id");
		result = this.repository.findOneApplicationById(id);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isRejected = entity.getStatus().equals(ApplicationStatus.REJECTED);

		if (!errors.hasErrors("justification")) {
			if (isRejected) {
				boolean isEmpty = entity.getJustification().length() == 0;
				errors.state(request, !isEmpty, "justification", "entrepreneur.application.update.no-empty");
			}
		}

		if (!errors.hasErrors("money")) {
			Boolean isEur = entity.getMoney().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
			errors.state(request, isEur, "money", "investor.application.error.money");
		}
	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}
}
