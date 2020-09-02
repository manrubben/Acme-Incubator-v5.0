
package acme.features.administrator.challenges;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Challenges;
import acme.entities.Configuration;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenges> {

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
	public Challenges findOne(final Request<Challenges> request) {
		assert request != null;

		Challenges result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneChallengeById(id);

		return result;
	}

	@Override
	public void validate(final Request<Challenges> request, final Challenges entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("title")) {
			boolean isSpam = config.isSpam(entity.getTitle());
			errors.state(request, !isSpam, "title", "administrator.challenges.error.spam");
		}

		if (!errors.hasErrors("description")) {
			boolean isSpam = config.isSpam(entity.getDescription());
			errors.state(request, !isSpam, "description", "administrator.challenges.error.spam");
		}

		if (!errors.hasErrors("expertGoal")) {
			boolean isSpam = config.isSpam(entity.getExpertGoal());
			errors.state(request, !isSpam, "expertGoal", "administrator.challenges.error.spam");
		}

		if (!errors.hasErrors("averageGoal")) {
			boolean isSpam = config.isSpam(entity.getAverageGoal());
			errors.state(request, !isSpam, "averageGoal", "administrator.challenges.error.spam");
		}

		if (!errors.hasErrors("rookieGoal")) {
			boolean isSpam = config.isSpam(entity.getRookieGoal());
			errors.state(request, !isSpam, "rookieGoal", "administrator.challenges.error.spam");
		}

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

		if (!errors.hasErrors("deadline")) {
			boolean isAfter = entity.getDeadline().isAfter(LocalDateTime.now());
			boolean isAfter30Days = entity.getDeadline().isAfter(LocalDateTime.now().plusMonths(1));
			errors.state(request, isAfter, "deadline", "administrator.challenges.error.deadlineIsAfter");
			errors.state(request, isAfter30Days, "deadline", "administrator.challenges.error.deadlineAfter30Days");

		}

	}

	@Override
	public void update(final Request<Challenges> request, final Challenges entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
