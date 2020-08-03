
package acme.features.authenticated.inquiries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Inquiries;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedInquiriesShowService implements AbstractShowService<Authenticated, Inquiries> {

	@Autowired
	private AuthenticatedInquiriesRepository repository;


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

		request.unbind(entity, model, "title", "creation", "deadline", "paragraph", "moneyMin","moneyMax","email");
	}

	@Override
	public Inquiries findOne(final Request<Inquiries> request) {
		assert request != null;

		Inquiries result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
