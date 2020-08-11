
package acme.features.entrepreneur.investmentRounds;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

}
