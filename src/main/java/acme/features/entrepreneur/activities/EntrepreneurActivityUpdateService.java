
package acme.features.entrepreneur.activities;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Activity;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurActivityUpdateService implements AbstractUpdateService<Entrepreneur, Activity> {

	@Autowired
	EntrepreneurActivityRepository repository;


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

		request.unbind(entity, model, "title", "start", "end", "money");

	}

	@Override
	public Activity findOne(final Request<Activity> request) {
		assert request != null;

		Activity result;
		int investmentRoundId;

		investmentRoundId = request.getModel().getInteger("id");
		result = this.repository.findOneById(investmentRoundId);

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
	public void update(final Request<Activity> request, final Activity entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
