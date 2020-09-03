
package acme.features.administrator.dashboard;

import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	//	@Query("select 1.0 * count(a)/(select count(b) from Job b) from Wotemi a ")
	//	Float findInvestmentRoundByProblem();
	//
	//	@Query("select 1.0 * count(a)/(select count(b) from Application b) from Application a where a.ticket != '' ")
	//	Float findApplicationsByAnswer();
	//
	//	@Query("select 1.0 * count(a)/(select count(b) from Application b) from Application a where a.password != ''")
	//	Float findApplicationsByPassword();

}
