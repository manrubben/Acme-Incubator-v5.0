
package acme.entities;

import javax.persistence.Entity;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dashboard extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	private Float				investmentRoundRatio;

	private Float				applicationRatio;

	private Float				application2Ratio;

}
