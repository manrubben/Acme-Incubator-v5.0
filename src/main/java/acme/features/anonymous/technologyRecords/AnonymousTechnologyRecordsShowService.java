
package acme.features.anonymous.technologyRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.TechnologyRecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousTechnologyRecordsShowService implements AbstractShowService<Anonymous, TechnologyRecords> {

	@Autowired
	private AnonymousTechnologyRecordsRepository repository;


	@Override
	public boolean authorise(final Request<TechnologyRecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<TechnologyRecords> request, final TechnologyRecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventorsName", "description", "website", "email", "indication", "stars");
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

}
