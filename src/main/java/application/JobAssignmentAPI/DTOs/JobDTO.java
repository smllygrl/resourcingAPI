package application.JobAssignmentAPI.DTOs;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import application.JobAssignmentAPI.Entities.HumanResource;

public class JobDTO {
	@NotBlank
	private String description;
	
	@NotNull
	private LocalDate startDate;
	
	@NotNull
	private LocalDate endDate;
	
	private HumanResource humanResource;
	
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

	public HumanResource getHumanResource() {
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource) {
		this.humanResource = humanResource;
	}

}
