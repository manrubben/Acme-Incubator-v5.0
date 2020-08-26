
package acme.features.entrepreneur.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Activity;
import acme.entities.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.features.entrepreneur.investmentRounds.EntrepreneurInvestmentRoundRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurActivityCreateService implements AbstractCreateService<Entrepreneur, Activity> {

	@Autowired
	EntrepreneurActivityRepository			activityRepository;

	@Autowired
	EntrepreneurInvestmentRoundRepository	investmentRoundRepository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		/*
		 * assert request != null;
		 *
		 * boolean res;
		 * Principal principal;
		 * Integer investmentRoundId;
		 * InvestmentRound currentinvestmentRound;
		 *
		 * res = false;
		 * principal = request.getPrincipal();
		 * investmentRoundId = request.getModel().getInteger("investmentRoundId");
		 *
		 * if (investmentRoundId != null) {
		 * currentinvestmentRound = this.repository.findInvestmentRoundById(investmentRoundId);
		 * res = currentinvestmentRound != null && currentinvestmentRound.getEntrepreneur().getId() == principal.getActiveRoleId() && !currentinvestmentRound.getFinalMode();
		 * }
		 */

		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end", "budget");
		model.setAttribute("id", entity.getInvestmentRound().getId());

	}

	@Override
	public Activity instantiate(final Request<Activity> request) {
		assert request != null;

		Activity result = new Activity();

		int investmentRoundId;

		investmentRoundId = request.getModel().getInteger("id");

		InvestmentRound investmentRound = this.investmentRoundRepository.findOneById(investmentRoundId);

		assert investmentRound != null;
		result.setInvestmentRound(investmentRound);

		return result;
	}

	@Override
	public void validate(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		/*
		 * Integer investmentRoundId;
		 * InvestmentRound currentinvestmentRound;
		 * Principal principal;
		 * boolean validInvestment;
		 *
		 * principal = request.getPrincipal();
		 * investmentRoundId = request.getModel().getInteger("investmentRoundId");
		 *
		 * if (!errors.hasErrors("investmentRound")) {
		 * validInvestment = investmentRoundId != null;
		 *
		 * if (validInvestment) {
		 * currentinvestmentRound = this.repository.findInvestmentRoundById(investmentRoundId);
		 * validInvestment = currentinvestmentRound != null && currentinvestmentRound.getEntrepreneur().getId() == principal.getActiveRoleId();
		 * }
		 * errors.state(request, validInvestment, "investmentRoundId", "entrepreneur.Activity.error.job-not-mine");
		 * }
		 */

	}

	@Override
	public void create(final Request<Activity> request, final Activity entity) {

		assert request != null;
		assert entity != null;

		this.activityRepository.save(entity);
	}

}
