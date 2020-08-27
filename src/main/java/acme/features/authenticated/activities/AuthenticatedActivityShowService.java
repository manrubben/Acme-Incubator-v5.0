
package acme.features.authenticated.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Activity;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedActivityShowService implements AbstractShowService<Authenticated, Activity> {

	@Autowired
	private AuthenticatedActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		boolean result = false;
		int activityId;
		Activity currentActivity;
		Principal principal;

		activityId = request.getModel().getInteger("id");
		currentActivity = this.repository.findOneById(activityId);
		principal = request.getPrincipal();

		result = currentActivity.getInvestmentRound().getFinalMode() == true;

		return result;
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end", "budget");
	}

	@Override
	public Activity findOne(final Request<Activity> request) {
		assert request != null;

		Activity result;
		int idInvestmentRound;

		idInvestmentRound = request.getModel().getInteger("id");
		result = this.repository.findOneById(idInvestmentRound);

		return result;
	}

}
