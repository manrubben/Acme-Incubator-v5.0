/*
 * AuthenticatedentrepreneurCreateService.java
 *
 * Chus (2019).
 */

package acme.features.authenticated.entrepreneur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Configuration;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedEntrepreneurCreateService implements AbstractCreateService<Authenticated, Entrepreneur> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedEntrepreneurRepository repository;


	// AbstractCreateService<Authenticated, Entrepreneur> interface ---------------

	@Override
	public boolean authorise(final Request<Entrepreneur> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Entrepreneur> request, final Entrepreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Entrepreneur> request, final Entrepreneur entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "qualification", "skills");
	}

	@Override
	public Entrepreneur instantiate(final Request<Entrepreneur> request) {
		assert request != null;

		Entrepreneur result;
		Principal principal;
		int userAccountId;
		UserAccount userAccount;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		userAccount = this.repository.findOneUserAccountById(userAccountId);

		result = new Entrepreneur();
		result.setUserAccount(userAccount);

		return result;
	}

	@Override
	public void validate(final Request<Entrepreneur> request, final Entrepreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Configuration config;
		config = this.repository.findManyConfiguration().stream().findFirst().get();

		if (!errors.hasErrors("name")) {
			boolean isSpam = config.isSpam(entity.getName());
			errors.state(request, !isSpam, "name", "authenticated.entrepreneur.error.spam");
		}

		if (!errors.hasErrors("sector")) {
			boolean isSpam = config.isSpam(entity.getSector());
			errors.state(request, !isSpam, "sector", "authenticated.entrepreneur.error.spam");
		}

		if (!errors.hasErrors("qualification")) {
			boolean isSpam = config.isSpam(entity.getQualification());
			errors.state(request, !isSpam, "qualification", "authenticated.entrepreneur.error.spam");
		}

		if (!errors.hasErrors("skills")) {
			boolean isSpam = config.isSpam(entity.getSkills());
			errors.state(request, !isSpam, "skills", "authenticated.entrepreneur.error.spam");
		}
	}

	@Override
	public void create(final Request<Entrepreneur> request, final Entrepreneur entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<Entrepreneur> request, final Response<Entrepreneur> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
