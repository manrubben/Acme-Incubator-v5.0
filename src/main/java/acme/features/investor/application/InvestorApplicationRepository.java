
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Application;
import acme.entities.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	@Query("select a from Application a")
	Collection<Application> findManyAll();

	@Query("select a from Application a where a.investor.id = ?1")
	Collection<Application> findManyByInvestorId(int id);

	@Query("select i from InvestmentRound i where i.id=?1")
	InvestmentRound findInvestmentRoundById(int id);

	@Query("select a from Application a where a.investmentRound.id=?1 AND a.investor.id=?2")
	Collection<Application> exists(int idInvestment, int idInvestor);

	@Query("select i from Investor i where i.id=?1")
	Investor findInvestorById(int id);

}
