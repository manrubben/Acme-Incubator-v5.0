
package acme.features.investor.investmentRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorInvestmentRoundShowService implements AbstractShowService<Investor, InvestmentRound> {

	@Autowired
	private InvestorInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		boolean result = false;
		int investmentRoundId;
		InvestmentRound currentInvestmentRound;
		Principal principal;

		investmentRoundId = request.getModel().getInteger("id");
		currentInvestmentRound = this.repository.findOneById(investmentRoundId);
		principal = request.getPrincipal();

		result = currentInvestmentRound.getFinalMode() == true || currentInvestmentRound.getFinalMode() == false && currentInvestmentRound.getEntrepreneur().getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Boolean isNotApped = this.repository.exists(request.getModel().getInteger("id"), request.getPrincipal().getActiveRoleId()).isEmpty();
		int InvestmentRoundId = request.getModel().getInteger("id");
		model.setAttribute("isNotApped", isNotApped);
		model.setAttribute("InvestmentRoundId", InvestmentRoundId);

		request.unbind(entity, model, "ticker", "creation", "round", "title", "description", "money", "link", "finalMode");
	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
