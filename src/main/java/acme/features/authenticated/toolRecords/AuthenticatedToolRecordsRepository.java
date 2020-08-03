
package acme.features.authenticated.toolRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ToolRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedToolRecordsRepository extends AbstractRepository {

	@Query("select t from ToolRecords t where t.id = ?1")
	ToolRecords findOneById(int id);

	@Query("select t from ToolRecords t")
	Collection<ToolRecords> findManyAll();

}
