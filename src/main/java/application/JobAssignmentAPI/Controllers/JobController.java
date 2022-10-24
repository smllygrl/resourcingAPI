package application.JobAssignmentAPI.Controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.JobAssignmentAPI.DTOs.JobDTO;
import application.JobAssignmentAPI.DTOs.UpdateJobDTO;
import application.JobAssignmentAPI.Entities.JobEntity;
import application.JobAssignmentAPI.Services.JobService;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {
	@Autowired
	private JobService jobService;
	
	// GET /jobs
	// List all jobs
	@GetMapping
	public java.util.List<JobEntity> allJobs() {
		return jobService.getAllJobs();
	}
	
	// GET /jobs/id
	// Get job by id
	@GetMapping(path = "/{id}")
	public Optional<JobEntity> getJobById(@PathVariable Integer id) {
		// TO DO
		// MANAGE CASES WHERE ID NOT FOUND
		return jobService.findJobById(id);
	}
	
	// POST /jobs
	// Creates a job
	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveJob(@Valid @RequestBody JobDTO job) {
		jobService.create(job);
	}
	
	@PatchMapping(path = "/{jobId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void assignJob(@PathVariable Integer jobId, @RequestBody UpdateJobDTO dataFromUser) {
		jobService.updateJob(jobId, dataFromUser);
		
	}
	
	}
	
	
