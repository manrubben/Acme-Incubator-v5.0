
package acme.features.authenticated.overtures;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Overtures;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedOverturesShowService implements AbstractShowService<Authenticated, Overtures> {

	@Autowired
	private AuthenticatedOverturesRepository repository;


	@Override
	public boolean authorise(final Request<Overtures> request) {
		assert request != null;

		boolean result = false;
		int overtureId;
		Overtures currentOverture;

		overtureId = request.getModel().getInteger("id");
		currentOverture = this.repository.findOneById(overtureId);

		result = currentOverture.getDeadline().isAfter(LocalDateTime.now());

		return result;
	}

	@Override
	public void unbind(final Request<Overtures> request, final Overtures entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creation", "deadline", "paragraph", "moneyMin", "moneyMax", "email");
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
}
