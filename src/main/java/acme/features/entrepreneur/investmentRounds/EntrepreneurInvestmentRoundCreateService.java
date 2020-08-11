
package acme.features.entrepreneur.investmentRounds;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurInvestmentRoundCreateService implements AbstractCreateService<Entrepreneur, InvestmentRound> {

	@Autowired
	private EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		return true;
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
	public InvestmentRound instantiate(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int entrepreneurId;
		Entrepreneur currentEntrepreneur;
		LocalDateTime creation;

		entrepreneurId = request.getPrincipal().getActiveRoleId();
		currentEntrepreneur = this.repository.findEntrepreneurById(entrepreneurId);
		creation = LocalDateTime.now();

		result = new InvestmentRound();

		result.setEntrepreneur(currentEntrepreneur);
		result.setCreation(creation);
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

	}

	@Override
	public void create(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
