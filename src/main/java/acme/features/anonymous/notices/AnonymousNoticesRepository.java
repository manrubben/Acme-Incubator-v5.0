
package acme.features.anonymous.notices;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Notices;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousNoticesRepository extends AbstractRepository {

	@Query("select n from Notices n where n.id = ?1")
	Notices findOneById(int id);

	@Query("select n from Notices n where (n.deadline >= current_date())")
	Collection<Notices> findManyAll();

}
