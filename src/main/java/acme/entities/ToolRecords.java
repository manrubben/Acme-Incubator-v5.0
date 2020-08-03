
package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToolRecords extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Length(max = 255)
	private String				title;

	@NotBlank
	@Length(max = 255)
	private String				activitySector;

	@NotBlank
	@Length(max = 255)
	private String				inventorsName;

	@NotBlank
	@Length(max = 255)
	private String				description;

	@NotBlank
	@Length(max = 255)
	private String				website;

	@Email
	@NotBlank
	@Length(max = 255)
	private String				email;

	@NotBlank
	@Length(max = 255)
	private String				indication;

	@Min(value = -5)
	@Max(value = 5)
	private Integer				stars;

}
