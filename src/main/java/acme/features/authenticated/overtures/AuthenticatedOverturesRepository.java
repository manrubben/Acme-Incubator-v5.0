
package acme.features.authenticated.overtures;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Overtures;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedOverturesRepository extends AbstractRepository {

	@Query("select o from Overtures o where o.id = ?1")
	Overtures findOneById(int id);

	@Query("select o from Overtures o")
	Collection<Overtures> findManyAll();

	@Query("select o from Overtures o where (o.deadline >= CURRENT_TIMESTAMP)")
	Collection<Overtures> findManyAllActives();
}
