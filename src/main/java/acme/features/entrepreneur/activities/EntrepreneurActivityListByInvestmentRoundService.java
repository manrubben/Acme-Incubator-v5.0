
package acme.features.entrepreneur.activities;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Activity;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EntrepreneurActivityListByInvestmentRoundService implements AbstractListService<Entrepreneur, Activity> {

	@Autowired
	EntrepreneurActivityRepository activityRepository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "budget");
	}

	@Override
	public Collection<Activity> findMany(final Request<Activity> request) {
		assert request != null;

		Collection<Activity> result;
		int id;

		id = request.getModel().getInteger("id");

		result = this.activityRepository.findManyByInvestmentRound(id);
		result.size();

		return result;
	}

}
