package application.JobAssignmentAPI.DTOs;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import application.JobAssignmentAPI.Entities.HumanResourceEntity;

public class JobDTO {
	@NotBlank
	private String description;
	
	@NotNull
	private LocalDate startDate;
	
	@NotNull
	private LocalDate endDate;
	
	private HumanResourceEntity assignedResource;
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public LocalDate setStartDate(LocalDate startDate) {
		return this.startDate = startDate;
	}
	
	public LocalDate setEndDate(LocalDate endDate) {
		return this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public HumanResourceEntity getAssignedResource() {
		return assignedResource;
	}

	public void setAssignedResource(HumanResourceEntity assignedResource) {
		this.assignedResource = assignedResource;
	}

}
