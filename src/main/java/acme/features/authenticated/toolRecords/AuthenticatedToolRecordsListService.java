
package acme.features.authenticated.toolRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolRecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedToolRecordsListService implements AbstractListService<Authenticated, ToolRecords> {

	@Autowired
	private AuthenticatedToolRecordsRepository repository;


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

		request.unbind(entity, model, "title");

	}

	@Override
	public Collection<ToolRecords> findMany(final Request<ToolRecords> request) {
		assert request != null;

		Collection<ToolRecords> result = this.repository.findManyAll();

		return result;
	}

}
