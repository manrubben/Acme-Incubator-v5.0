
package acme.features.entrepreneur.investmentRounds;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		int investRoundId = request.getModel().getInteger("id");
		InvestmentRound investRound = this.repository.findOneById(investRoundId);

		result = !investRound.getFinalMode();

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

		request.unbind(entity, model, "ticker", "round", "title", "description", "money", "link", "finalMode");
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

		if (!errors.hasErrors("round")) {
			Boolean formatRound = entity.getRound().matches("SEED|ANGEL|SERIES-A|SERIES-B|SERIES-C|BRIDGE");
			errors.state(request, formatRound, "round", "entrepreneur.investment-round.error.round");
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

				boolean sumaCorrecta = totalBudget == dinero;
				errors.state(request, sumaCorrecta, "finalMode", "The money does not match the budget");

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
