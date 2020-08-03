package acme.features.administrator.technologyRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.TechnologyRecords;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorTechnologyRecordsUpdateService
		implements AbstractUpdateService<Administrator, TechnologyRecords> {

	@Autowired
	private AdministratorTechnologyRecordsRepository repository;

	@Override
	public boolean authorise(final Request<TechnologyRecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<TechnologyRecords> request, final TechnologyRecords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<TechnologyRecords> request, final TechnologyRecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventorsName", "description", "website", "email",
				"indication", "stars");

	}

	@Override
	public TechnologyRecords findOne(final Request<TechnologyRecords> request) {
		assert request != null;

		TechnologyRecords result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<TechnologyRecords> request, final TechnologyRecords entity,
			final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<TechnologyRecords> request, final TechnologyRecords entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}