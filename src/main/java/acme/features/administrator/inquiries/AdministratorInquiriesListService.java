
package acme.features.administrator.inquiries;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Inquiries;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorInquiriesListService implements AbstractListService<Administrator, Inquiries> {

	@Autowired
	private AdministratorInquiriesRepository repository;


	@Override
	public boolean authorise(final Request<Inquiries> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Inquiries> request, final Inquiries entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title");

	}

	@Override
	public Collection<Inquiries> findMany(final Request<Inquiries> request) {
		assert request != null;

		Collection<Inquiries> result;

		result = this.repository.findManyAllActives();

		return result;
	}

}
