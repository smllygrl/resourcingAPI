package application.JobAssignmentAPI.DTOs;

public class UpdateJobDTO {
	
	private String description;
	
	private String startDate;
	
	private String endDate;
	
	private Integer assignedResource;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getAssignedResource() {
		return assignedResource;
	}

	public void setAssignedResource(Integer assignedResource) {
		this.assignedResource = assignedResource;
	}




}
