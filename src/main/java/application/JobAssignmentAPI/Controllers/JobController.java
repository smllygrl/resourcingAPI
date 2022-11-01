package application.JobAssignmentAPI.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import java.lang.Boolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.JobAssignmentAPI.DTOs.JobDTO;
import application.JobAssignmentAPI.DTOs.JobReturnDTO;
import application.JobAssignmentAPI.DTOs.UpdateJobDTO;
import application.JobAssignmentAPI.Entities.Job;
import application.JobAssignmentAPI.Services.JobService;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {
	@Autowired
	private JobService jobService;
	
	// GET /jobs --- List all jobs
	@GetMapping
	public List<Job> allJobs() {
		return jobService.getAllJobs();
	}
	
	// GET /jobs/id --- Get job by id
	@GetMapping(path = "/{id}")
	public Optional<Job> getJobById(@PathVariable Integer id) {
		// TO DO
		// MANAGE CASES WHERE ID NOT FOUND
		return jobService.findJobById(id);
	}
	
	// POST /jobs --- Creates a job
	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveJob(@Valid @RequestBody JobDTO job) {
		jobService.create(job);
	}
	
	// PATCH /jobs/id --- Assigns a resource to a job
	@PatchMapping(path = "/{jobId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void assignJob(@PathVariable Integer jobId, @RequestBody UpdateJobDTO dataFromUser) {
		jobService.updateJob(jobId, dataFromUser);
	}
	
	// GET jobs?assigned={true|false} --- Returns a list of jobs which match query
	@GetMapping(path = "?assigned={booleanValue}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<JobReturnDTO>> queryAssigned(@PathVariable Boolean booleanValue) {
		List<JobReturnDTO> jobs = jobService.queryAssignedJobs(booleanValue);
		return ResponseEntity.ok(jobs);
	}
	
}
	
