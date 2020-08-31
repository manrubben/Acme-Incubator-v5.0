
package acme.features.authenticated.activities;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Activity;
import acme.entities.InvestmentRound;
import acme.features.authenticated.investmentRound.AuthenticatedInvestmentRoundRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedActivityListByInvestmentRoundService implements AbstractListService<Authenticated, Activity> {

	@Autowired
	AuthenticatedActivityRepository			activityRepository;

	@Autowired
	AuthenticatedInvestmentRoundRepository	investmentRoundRepository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;
		boolean result;

		int investmentRoundId;
		InvestmentRound investmentRound;

		investmentRoundId = request.getModel().getInteger("id");
		investmentRound = this.investmentRoundRepository.findOneById(investmentRoundId);

		result = investmentRound.getFinalMode();

		return result;
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
