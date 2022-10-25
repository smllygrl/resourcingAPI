package application.JobAssignmentAPI.DTOs;

import javax.validation.constraints.NotNull;

public class HumanResourceReturnDTO {
	@NotNull
	private Integer id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	private List<JobReturnDTO> jobs;

}
