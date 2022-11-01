package application.JobAssignmentAPI.DTOs;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class JobReturnDTO {

	private Integer id;
	
	private String description;

	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String resourceName;
	
	public JobReturnDTO() {
	}
	
	public JobReturnDTO(Integer id, String description, LocalDate startDate, LocalDate endDate) {
		this.id = id;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.setResourceName(null);
	}


	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
