
package acme.features.anonymous.toolRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolRecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousToolRecordsShowService implements AbstractShowService<Anonymous, ToolRecords> {

	@Autowired
	private AnonymousToolRecordsRepository repository;


	@Override
	public boolean authorise(final Request<ToolRecords> request) {
		assert request != null;

		return true;
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

}
