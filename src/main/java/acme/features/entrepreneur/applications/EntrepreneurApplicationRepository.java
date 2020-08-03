
package acme.features.entrepreneur.applications;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.investmentRound.id = ?1")
	Collection<Application> findManyByInvestmentRoundId(int id);

	@Query("select a from Application a where a.id=?1")
	Application findOneApplicationById(int id);

}
