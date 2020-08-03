
package acme.features.administrator.toolRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ToolRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorToolRecordsRepository extends AbstractRepository {

	@Query("select tr from ToolRecords tr where tr.id = ?1")
	ToolRecords findOneById(int id);

	@Query("select tr from ToolRecords tr")
	Collection<ToolRecords> findManyAll();

}
