
package acme.features.administrator.challenges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Challenges;
import acme.features.authenticated.challenges.AuthenticatedChallengeRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorChallengeShowService implements AbstractShowService<Administrator, Challenges> {

	@Autowired
	private AuthenticatedChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenges> request) {
		assert request != null;
		return true;
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
		result = this.repository.findOneById(id);
		return result;
	}

}
