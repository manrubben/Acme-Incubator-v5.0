
package acme.features.authenticated.notices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Notices;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedNoticesListService implements AbstractListService<Authenticated, Notices> {

	@Autowired
	private AuthenticatedNoticesRepository repository;


	@Override
	public boolean authorise(final Request<Notices> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Notices> request, final Notices entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creation");

	}

	@Override
	public Collection<Notices> findMany(final Request<Notices> request) {
		assert request != null;

		Collection<Notices> result;

		result = this.repository.findManyAll();

		return result;
	}

}
