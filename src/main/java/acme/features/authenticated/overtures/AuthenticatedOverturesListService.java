
package acme.features.authenticated.overtures;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Overtures;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedOverturesListService implements AbstractListService<Authenticated, Overtures> {

	@Autowired
	private AuthenticatedOverturesRepository repository;


	@Override
	public boolean authorise(final Request<Overtures> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Overtures> request, final Overtures entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title");

	}

	@Override
	public Collection<Overtures> findMany(final Request<Overtures> request) {
		assert request != null;

		Collection<Overtures> result;

		result = this.repository.findManyAllActives();

		return result;
	}
}
