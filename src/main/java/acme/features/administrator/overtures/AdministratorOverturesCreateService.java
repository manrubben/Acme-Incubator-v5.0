
package acme.features.administrator.overtures;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Overtures;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorOverturesCreateService implements AbstractCreateService<Administrator, Overtures> {

	@Autowired
	private AdministratorOverturesRepository repository;


	@Override
	public boolean authorise(final Request<Overtures> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Overtures> request, final Overtures entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creation");

	}

	@Override
	public void unbind(final Request<Overtures> request, final Overtures entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "paragraph", "rangeMoney", "email");

	}

	@Override
	public Overtures instantiate(final Request<Overtures> request) {
		Overtures result;

		result = new Overtures();
		LocalDateTime creation;

		creation = LocalDateTime.now();
		result.setCreation(creation);

		return result;
	}

	@Override
	public void validate(final Request<Overtures> request, final Overtures entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("rangeMoney")) {
			Boolean isEur = entity.getRangeMoney().getCurrency().matches("EUR|€|EUROS|Euros|euros|eur");
			errors.state(request, isEur, "rangeMoney", "administrator.overtures.error.must-be-eur");
		}

	}

	@Override
	public void create(final Request<Overtures> request, final Overtures entity) {
		LocalDateTime creation;

		creation = LocalDateTime.now();
		entity.setCreation(creation);
		this.repository.save(entity);

	}

}
