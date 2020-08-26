
package acme.features.entrepreneur.activities;

import java.time.LocalDateTime;

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

		if (!errors.hasErrors("start")) {
			Boolean isBefore = entity.getStart().isBefore(entity.getEnd());
			errors.state(request, isBefore, "start", "entrepreneur.activity.error.start");
		}

		if (!errors.hasErrors("start")) {
			Boolean isAfterThanToday = entity.getStart().isAfter(LocalDateTime.now());
			errors.state(request, isAfterThanToday, "start", "entrepreneur.activity.error.isAfterThanToday");
		}

		if (!errors.hasErrors("budget")) {
			Boolean isEur = entity.getBudget().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
			errors.state(request, isEur, "budget", "entrepreneur.activity.error.budget");
		}

	}

	@Override
	public void create(final Request<Activity> request, final Activity entity) {

		assert request != null;
		assert entity != null;

		this.activityRepository.save(entity);
	}

}
