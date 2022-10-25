package application.JobAssignmentAPI.DTOs;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class JobReturnDTO {
	@NotBlank
	private String description;
	
	@NotNull
	private LocalDate startDate;
	
	@NotNull
	private LocalDate endDate;
	
	private HumanResourceReturnDTO assignedResource;

}
