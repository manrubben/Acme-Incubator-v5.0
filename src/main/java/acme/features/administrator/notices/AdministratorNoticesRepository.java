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

package acme.features.administrator.notices;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Notices;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorNoticesRepository extends AbstractRepository {

	@Query("select n from Notices n where n.id = ?1")
	Notices findOneById(int id);

	@Query("select n from Notices n")
	Collection<Notices> findManyAll();

}
