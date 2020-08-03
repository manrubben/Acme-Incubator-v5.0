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

package acme.features.anonymous.technologyRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.TechnologyRecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousTechnologyRecordsListService implements AbstractListService<Anonymous, TechnologyRecords> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousTechnologyRecordsRepository repository;


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

		request.unbind(entity, model, "title", "activitySector", "inventorsName", "description", "website", "email", "indication", "stars");
	}

	@Override
	public Collection<TechnologyRecords> findMany(final Request<TechnologyRecords> request) {
		assert request != null;

		Collection<TechnologyRecords> result;

		result = this.repository.findManyAll();

		return result;
	}
}
