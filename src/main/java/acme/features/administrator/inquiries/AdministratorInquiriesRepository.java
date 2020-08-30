
package acme.features.administrator.inquiries;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Configuration;
import acme.entities.Inquiries;
import acme.entities.Overtures;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInquiriesRepository extends AbstractRepository {

	@Query("select n from Inquiries n where n.id = ?1")
	Inquiries findOneById(int id);

	@Query("select n from Inquiries n")
	Collection<Inquiries> findManyAll();

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();
	
	@Query("select i from Inquiries i where (i.deadline >= CURRENT_TIMESTAMP)")
	Collection<Inquiries> findManyAllActives();

}
