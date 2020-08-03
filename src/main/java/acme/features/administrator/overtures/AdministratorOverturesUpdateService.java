
package acme.features.administrator.overtures;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Overtures;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorOverturesUpdateService implements AbstractUpdateService<Administrator, Overtures> {

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

		request.unbind(entity, model, "title", "deadline", "paragraph", "RangeMoney", "email");

	}

	@Override
	public Overtures findOne(final Request<Overtures> request) {
		assert request != null;

		Overtures result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Overtures> request, final Overtures entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Overtures> request, final Overtures entity) {
		assert request != null;
		assert entity != null;

		LocalDateTime creation;

		creation = LocalDateTime.now();
		entity.setCreation(creation);
		this.repository.save(entity);

	}

}
