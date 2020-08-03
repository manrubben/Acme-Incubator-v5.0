
package acme.features.authenticated.technologyRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.TechnologyRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTechnologyRecordsRepository extends AbstractRepository {

	@Query("select tr from TechnologyRecords tr where tr.id = ?1")
	TechnologyRecords findOneById(int id);

	@Query("select tr from TechnologyRecords tr")
	Collection<TechnologyRecords> findManyAll();

}
