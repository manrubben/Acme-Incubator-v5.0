
package acme.features.entrepreneur.activities;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Activity;
import acme.entities.Configuration;
import acme.entities.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurActivityRepository extends AbstractRepository {

	@Query("select a from Activity a where a.investmentRound.id = ?1")
	Collection<Activity> findManyByInvestmentRound(int id);

	@Query("select a from Activity a where a.id = ?1")
	Activity findOneById(int id);

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findInvestmentRoundById(int investmentRoundId);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

}
