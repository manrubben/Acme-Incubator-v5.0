
package acme.features.authenticated.challenges;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Challenges;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedChallengeRepository extends AbstractRepository {

	@Query("select r from Challenges r where r.id = ?1")
	Challenges findOneById(int id);

	@Query("select c from Challenges c where (c.deadline >= current_date())")
	Collection<Challenges> findManyAll();

}
