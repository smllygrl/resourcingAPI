package application.JobAssignmentAPI.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class JobEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String description;
	private String startDate;
	private String endDate;
	private Integer assignedResource;
	
	public JobEntity(String description, String startDate, String endDate, Integer assignedResource) {
		this.setDescription(description);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setAssignedResource(assignedResource);
	}
	
	public JobEntity() {}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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
