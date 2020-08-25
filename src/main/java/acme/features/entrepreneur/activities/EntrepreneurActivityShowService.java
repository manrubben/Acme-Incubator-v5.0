
package acme.features.entrepreneur.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Activity;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurActivityShowService implements AbstractShowService<Entrepreneur, Activity> {

	@Autowired
	private EntrepreneurActivityRepository activityRepository;


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

		model.setAttribute("investmentRoundFinal", entity.getInvestmentRound().getFinalMode());

		//request.unbind(entity, model, "title", "start", "end", "budget", "investmentRound.finalMode", "investmentRound.tittle");
		request.unbind(entity, model, "title", "start", "end", "budget");
	}

	@Override
	public Activity findOne(final Request<Activity> request) {
		assert request != null;

		Activity result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.activityRepository.findOneById(id);

		return result;
	}

}
