
package acme.features.authenticated.inquiries;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Inquiries;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInquiriesRepository extends AbstractRepository {

	@Query("select n from Inquiries n where n.id = ?1")
	Inquiries findOneById(int id);

	@Query("select n from Inquiries n")
	Collection<Inquiries> findManyAll();

}
