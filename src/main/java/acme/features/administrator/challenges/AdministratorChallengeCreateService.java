
package acme.features.administrator.challenges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Challenges;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenges> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenges> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenges> request, final Challenges entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenges> request, final Challenges entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "expertGoal", "averageGoal", "rookieGoal", "expertReward", "averageReward", "rookieReward");
	}

	@Override
	public Challenges instantiate(final Request<Challenges> request) {
		Challenges result;

		result = new Challenges();

		return result;
	}

	@Override
	public void validate(final Request<Challenges> request, final Challenges entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("expertReward") && !errors.hasErrors("averageReward") && !errors.hasErrors("rookieReward")) {

			Boolean eurZoneRookie = entity.getRookieReward().getCurrency().matches("euros|eur|Euros|EUR|EUROS|€");
			Boolean eurZoneAverage = entity.getAverageReward().getCurrency().matches("euros|eur|Euros|EUR|EUROS|€");
			Boolean eurZoneExpert = entity.getExpertReward().getCurrency().matches("euros|eur|Euros|EUR|EUROS|€");
			errors.state(request, eurZoneRookie, "rookieReward", "administrator.challenges.error.euroZone");
			errors.state(request, eurZoneAverage, "averageReward", "administrator.challenges.error.euroZone");
			errors.state(request, eurZoneExpert, "expertReward", "administrator.challenges.error.euroZone");

		}

		if (!errors.hasErrors("expertReward") && !errors.hasErrors("averageReward") && !errors.hasErrors("rookieReward")) {

			Boolean orderReward = entity.getRookieReward().getAmount().compareTo(entity.getAverageReward().getAmount()) < 0 && entity.getAverageReward().getAmount().compareTo(entity.getExpertReward().getAmount()) < 0;

			errors.state(request, orderReward, "rookieReward", "administrator.challenges.error.rookieReward");
			errors.state(request, orderReward, "averageReward", "administrator.challenges.error.averageReward");

		}

	}

	@Override
	public void create(final Request<Challenges> request, final Challenges entity) {
		this.repository.save(entity);
	}

}
