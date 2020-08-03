
package acme.features.administrator.inquiries;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Inquiries;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInquiriesCreateService implements AbstractCreateService<Administrator, Inquiries> {

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
	public Inquiries instantiate(final Request<Inquiries> request) {
		Inquiries result;

		result = new Inquiries();
		LocalDateTime creation;

		creation = LocalDateTime.now();
		result.setCreation(creation);

		return result;
	}

	@Override
	public void validate(final Request<Inquiries> request, final Inquiries entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("moneyMin")) {
			Boolean isEur = entity.getMoneyMin().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
			errors.state(request, isEur, "moneyMin", "administrator.inquiries.error.must-be-eur");
		}

		if (!errors.hasErrors("moneyMax")) {
			Boolean isEur = entity.getMoneyMax().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
			errors.state(request, isEur, "moneyMin", "administrator.inquiries.error.must-be-eur");
		}

	}

	@Override
	public void create(final Request<Inquiries> request, final Inquiries entity) {
		LocalDateTime creation;

		creation = LocalDateTime.now();
		entity.setCreation(creation);
		this.repository.save(entity);

	}

}
