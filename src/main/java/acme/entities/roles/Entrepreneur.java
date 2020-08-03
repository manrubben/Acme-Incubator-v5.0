
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Entrepreneur extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotNull
	private Integer				qualification;

	@NotNull
	private String				skills;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
