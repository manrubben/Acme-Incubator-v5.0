/*
 * AnonymousUserAccountCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.notices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Notices;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorNoticesListService implements AbstractListService<Administrator, Notices> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorNoticesRepository repository;


	@Override
	public boolean authorise(final Request<Notices> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Notices> request, final Notices entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "headerPicture", "title", "creation", "deadline", "body", "links");
	}

	@Override
	public Collection<Notices> findMany(final Request<Notices> request) {
		assert request != null;

		Collection<Notices> result;

		result = this.repository.findManyAll();

		return result;
	}
}
