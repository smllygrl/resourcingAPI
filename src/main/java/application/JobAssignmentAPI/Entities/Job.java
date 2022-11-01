package application.JobAssignmentAPI.Entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table
@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	
	// One job can have one resource
	@ManyToOne
//	@JsonBackReference
	@JoinColumn(name = "human_resource_id")
	private HumanResource humanResource;
	
	public Job(String description, LocalDate startDate, LocalDate endDate, HumanResource humanResource) {
		this.setDescription(description);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setHumanResource(humanResource);
	}
	
	public Job() {}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public HumanResource getHumanResource() {
		return humanResource;
	}

	public void setHumanResource(HumanResource humanResource) {
		this.humanResource = humanResource;
	}

	
}
