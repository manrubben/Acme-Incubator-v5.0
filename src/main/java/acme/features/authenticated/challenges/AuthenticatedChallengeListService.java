
package acme.features.authenticated.challenges;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Challenges;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedChallengeListService implements AbstractListService<Authenticated, Challenges> {

	@Autowired
	AuthenticatedChallengeRepository repository;


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

		result = this.repository.findManyAll();

		return result;
	}

}
