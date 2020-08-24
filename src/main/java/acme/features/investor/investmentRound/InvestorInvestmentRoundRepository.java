
package acme.features.investor.investmentRound;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Application;
import acme.entities.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select i from InvestmentRound i where i.finalMode = true")
	Collection<InvestmentRound> findManyAllPublish(Date d);

	@Query("select a from Application a where a.investmentRound.id=?1 AND a.investor.id=?2")
	Collection<Application> exists(int idInvestment, int idInvestor);

}
