/*
 * AnonymousUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.toolRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ToolRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousToolRecordsRepository extends AbstractRepository {

	@Query("select tr from ToolRecords tr where tr.id = ?1")
	ToolRecords findOneById(int id);

	@Query("select tr from ToolRecords tr")
	Collection<ToolRecords> findManyAll();

}
