
package acme.features.administrator.challenges;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Challenges;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorChallengeListService implements AbstractListService<Administrator, Challenges> {

	@Autowired
	AdministratorChallengeRepository repository;


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

		request.unbind(entity, model, "title", "deadline", "description");
	}

	@Override
	public Collection<Challenges> findMany(final Request<Challenges> request) {
		assert request != null;
		Collection<Challenges> result;

		result = this.repository.findManyChallenges();

		return result;
	}
}
