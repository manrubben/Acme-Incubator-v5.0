
package acme.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Notices extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				headerPicture;

	@NotBlank
	@Length(max = 255)
	private String				title;

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	@Past
	@NotNull
	private LocalDateTime		creation;

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	@NotNull
	private LocalDateTime		deadline;

	@NotBlank
	private String				body;

	private String				links;

}
