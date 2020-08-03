
package acme.features.administrator.technologyRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.TechnologyRecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorTechnologyRecordsListService
		implements AbstractListService<Administrator, TechnologyRecords> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorTechnologyRecordsRepository repository;

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

		request.unbind(entity, model, "title", "activitySector", "inventorsName", "description");
	}

	@Override
	public Collection<TechnologyRecords> findMany(final Request<TechnologyRecords> request) {
		assert request != null;

		Collection<TechnologyRecords> result;

		result = this.repository.findManyAll();

		return result;
	}
}
