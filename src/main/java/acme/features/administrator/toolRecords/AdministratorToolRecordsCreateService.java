
package acme.features.administrator.toolRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolRecords;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorToolRecordsCreateService implements AbstractCreateService<Administrator, ToolRecords> {

	@Autowired
	private AdministratorToolRecordsRepository repository;


	@Override
	public boolean authorise(final Request<ToolRecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<ToolRecords> request, final ToolRecords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<ToolRecords> request, final ToolRecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventorsName", "description", "website", "email", "indication", "stars");

	}

	@Override
	public ToolRecords instantiate(final Request<ToolRecords> request) {
		ToolRecords result = new ToolRecords();

		return result;
	}

	@Override
	public void validate(final Request<ToolRecords> request, final ToolRecords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ToolRecords> request, final ToolRecords entity) {
		this.repository.save(entity);

	}

}
