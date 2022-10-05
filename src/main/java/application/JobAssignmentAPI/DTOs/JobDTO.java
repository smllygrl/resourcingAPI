package application.JobAssignmentAPI.DTOs;

import javax.validation.constraints.NotNull;

public class JobDTO {
	private String description;
	
	@NotNull
	private String startDate;
	
	@NotNull
	private String endDate;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
