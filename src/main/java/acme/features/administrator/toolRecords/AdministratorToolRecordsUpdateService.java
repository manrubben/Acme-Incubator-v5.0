
package acme.features.administrator.toolRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Configuration;
import acme.entities.ToolRecords;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorToolRecordsUpdateService implements AbstractUpdateService<Administrator, ToolRecords> {

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
	public ToolRecords findOne(final Request<ToolRecords> request) {
		assert request != null;

		ToolRecords result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<ToolRecords> request, final ToolRecords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("title")) {
			boolean isSpam = config.isSpam(entity.getTitle());
			errors.state(request, !isSpam, "title", "administrator.tool-records.error.spam");
		}

		if (!errors.hasErrors("inventorsName")) {
			boolean isSpam = config.isSpam(entity.getInventorsName());
			errors.state(request, !isSpam, "inventorsName", "administrator.tool-records.error.spam");
		}

		if (!errors.hasErrors("description")) {
			boolean isSpam = config.isSpam(entity.getDescription());
			errors.state(request, !isSpam, "description", "administrator.tool-records.error.spam");
		}

		if (!errors.hasErrors("website")) {
			boolean isSpam = config.isSpam(entity.getWebsite());
			errors.state(request, !isSpam, "website", "administrator.tool-records.error.spam");
		}

		if (!errors.hasErrors("email")) {
			boolean isSpam = config.isSpam(entity.getEmail());
			errors.state(request, !isSpam, "email", "administrator.tool-records.error.spam");
		}

		if (!errors.hasErrors("indication")) {
			boolean isSpam = config.isSpam(entity.getIndication().toString());
			errors.state(request, !isSpam, "indication", "administrator.tool-records.error.spam");
		}

	}

	@Override
	public void update(final Request<ToolRecords> request, final ToolRecords entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
