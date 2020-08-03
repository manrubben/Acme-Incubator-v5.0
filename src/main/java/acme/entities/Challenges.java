
package acme.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenges extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	// Atributes

	@NotBlank
	@Length(max = 255)
	private String				title;

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	@NotNull
	private LocalDateTime		deadline;

	@NotBlank
	@Length(max = 255)
	private String				description;

	@NotBlank
	@Length(max = 255)
	private String				expertGoal;

	@NotBlank
	@Length(max = 255)
	private String				averageGoal;

	@NotBlank
	@Length(max = 255)
	private String				rookieGoal;

	@NotNull
	@Valid
	private Money				expertReward;

	@NotNull
	@Valid
	private Money				averageReward;

	@NotNull
	@Valid
	private Money				rookieReward;

}
