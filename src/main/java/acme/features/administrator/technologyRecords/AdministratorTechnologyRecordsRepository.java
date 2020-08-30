
package acme.features.administrator.technologyRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Configuration;
import acme.entities.TechnologyRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTechnologyRecordsRepository extends AbstractRepository {

	@Query("select t from TechnologyRecords t where t.id = ?1")
	TechnologyRecords findOneById(int id);

	@Query("select t from TechnologyRecords t")
	Collection<TechnologyRecords> findManyAll();

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

}
