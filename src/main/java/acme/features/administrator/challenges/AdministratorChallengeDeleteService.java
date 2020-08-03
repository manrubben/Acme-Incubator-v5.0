
package acme.features.administrator.challenges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Challenges;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorChallengeDeleteService implements AbstractDeleteService<Administrator, Challenges> {

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

	}

	@Override
	public void delete(final Request<Challenges> request, final Challenges entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
