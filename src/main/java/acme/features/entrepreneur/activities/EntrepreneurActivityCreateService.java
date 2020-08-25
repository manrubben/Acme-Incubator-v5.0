
package acme.features.entrepreneur.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Activity;
import acme.entities.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurActivityCreateService implements AbstractCreateService<Entrepreneur, Activity> {

	@Autowired
	EntrepreneurActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		boolean res;
		Principal principal;
		Integer investmentRoundId;
		InvestmentRound currentinvestmentRound;

		res = false;
		principal = request.getPrincipal();
		investmentRoundId = request.getModel().getInteger("investmentRoundId");

		if (investmentRoundId != null) {
			currentinvestmentRound = this.repository.findInvestmentRoundById(investmentRoundId);
			res = currentinvestmentRound != null && currentinvestmentRound.getEntrepreneur().getId() == principal.getActiveRoleId() && !currentinvestmentRound.getFinalMode();
		}

		return res;
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

		int investmentRoundId;

		request.unbind(entity, model, "title", "start", "end", "budget");

		if (request.getMethod() == HttpMethod.GET) {

			investmentRoundId = request.getModel().getInteger("investmentRoundId");
			model.setAttribute("investmentRoundId", investmentRoundId);
			request.transfer(model, "investmentRoundId");
		}

	}

	@Override
	public Activity instantiate(final Request<Activity> request) {
		Activity result;
		result = new Activity();

		return result;
	}

	@Override
	public void validate(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Integer investmentRoundId;
		InvestmentRound currentinvestmentRound;
		Principal principal;
		boolean validInvestment;

		principal = request.getPrincipal();
		investmentRoundId = request.getModel().getInteger("investmentRoundId");

		if (!errors.hasErrors("investmentRound")) {
			validInvestment = investmentRoundId != null;

			if (validInvestment) {
				currentinvestmentRound = this.repository.findInvestmentRoundById(investmentRoundId);
				validInvestment = currentinvestmentRound != null && currentinvestmentRound.getEntrepreneur().getId() == principal.getActiveRoleId();
			}
			errors.state(request, validInvestment, "investmentRoundId", "entrepreneur.Activity.error.job-not-mine");
		}

	}

	@Override
	public void create(final Request<Activity> request, final Activity entity) {

		int investmentRoundId;
		InvestmentRound currentinvestmentRound;

		investmentRoundId = request.getModel().getInteger("investmentRoundId");
		currentinvestmentRound = this.repository.findInvestmentRoundById(investmentRoundId);
		entity.setInvestmentRound(currentinvestmentRound);

		this.repository.save(entity);
	}

}
