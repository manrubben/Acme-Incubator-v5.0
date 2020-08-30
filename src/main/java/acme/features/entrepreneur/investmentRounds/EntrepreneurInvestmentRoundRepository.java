
package acme.features.entrepreneur.investmentRounds;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Activity;
import acme.entities.Configuration;
import acme.entities.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select e from Entrepreneur e where e.id = ?1")
	Entrepreneur findEntrepreneurById(int entrepreneurId);

	@Query("select i from InvestmentRound i where i.entrepreneur.id =?1")
	Collection<InvestmentRound> findManyByEntrepreneurId(int entrepreneurId);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyConfiguration();

	@Query("select count(a) from Application a where a.investmentRound.id = ?1")
	Integer findCountOfApplicationByInvestmentRoundId(int InvestmentRoundId);

	@Query("select sum(d.budget.amount) from Activity d where d.investmentRound.id = ?1")
	Double findTotalDedicationByInvestmentRoundId(int investmentRoundId);

	@Query("select a from Activity a where a.investmentRound.id = ?1")
	Collection<Activity> findManyActivitiesByInvestmentRoundId(int investmentRoundId);

}
