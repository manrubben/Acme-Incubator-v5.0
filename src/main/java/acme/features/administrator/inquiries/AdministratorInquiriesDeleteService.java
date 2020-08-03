
package acme.features.administrator.inquiries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Inquiries;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorInquiriesDeleteService implements AbstractDeleteService<Administrator, Inquiries> {

	@Autowired
	private AdministratorInquiriesRepository repository;


	@Override
	public boolean authorise(final Request<Inquiries> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Inquiries> request, final Inquiries entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creation");

	}

	@Override
	public void unbind(final Request<Inquiries> request, final Inquiries entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "paragraph", "moneyMin", "moneyMax", "email");

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

	@Override
	public void validate(final Request<Inquiries> request, final Inquiries entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Inquiries> request, final Inquiries entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
