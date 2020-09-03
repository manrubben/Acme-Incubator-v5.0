
package acme.features.entrepreneur.investmentRounds;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Configuration;
import acme.entities.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurInvestmentRoundUpdateService implements AbstractUpdateService<Entrepreneur, InvestmentRound> {

	@Autowired
	private EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		boolean result = false;

		int investmentRoundId = request.getModel().getInteger("id");
		InvestmentRound investmentRound = this.repository.findOneById(investmentRoundId);

		result = !investmentRound.getFinalMode();

		return result;
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creation");
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "round", "title", "description", "money", "link", "finalMode", "X1");
	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("title")) {
			boolean isSpam = config.isSpam(entity.getTitle());
			errors.state(request, !isSpam, "title", "entrepreneur.investment-round.error.spam");
		}

		if (!errors.hasErrors("description")) {
			boolean isSpam = config.isSpam(entity.getDescription());
			errors.state(request, !isSpam, "description", "entrepreneur.investment-round.error.spam");
		}

		if (!errors.hasErrors("link")) {
			boolean isSpam = config.isSpam(entity.getLink());
			errors.state(request, !isSpam, "link", "entrepreneur.investment-round.error.spam");
		}

		if (!errors.hasErrors("money")) {
			Boolean isEur = entity.getMoney().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
			errors.state(request, isEur, "money", "entrepreneur.investment-round.error.money");
		}

		if (!errors.hasErrors()) {
			if (entity.getFinalMode()) {
				int investmentRoundId = entity.getId();
				Double totalBudget = this.repository.findTotalDedicationByInvestmentRoundId(investmentRoundId);

				if (totalBudget == null) {
					totalBudget = 0.0;
				}

				InvestmentRound investmentRound1 = this.repository.findOneById(investmentRoundId);

				Double dinero = investmentRound1.getMoney().getAmount();

				boolean isSpamTitle = config.isSpam(entity.getTitle());
				boolean isSpamDescription = config.isSpam(entity.getDescription());
				boolean isSpamLink = config.isSpam(entity.getLink());

				boolean sumaCorrecta = false;

				if (totalBudget.equals(dinero)) {

					sumaCorrecta = true;

				}

				boolean noHaySpam = !isSpamTitle & !isSpamDescription && !isSpamLink;

				errors.state(request, sumaCorrecta, "finalMode", "entrepreneur.investment-round.error.wrongSum");

				errors.state(request, noHaySpam, "finalMode", "entrepreneur.investment-round.error.spam");

				request.getModel().setAttribute("finalMode", sumaCorrecta);
			}
		}

	}

	@Override
	public void update(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		LocalDateTime creation;
		creation = LocalDateTime.now();
		entity.setCreation(creation);
		this.repository.save(entity);
	}

}
