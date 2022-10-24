package application.JobAssignmentAPI.Services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.JobAssignmentAPI.DTOs.JobDTO;
import application.JobAssignmentAPI.DTOs.UpdateJobDTO;
import application.JobAssignmentAPI.Entities.JobEntity;
import application.JobAssignmentAPI.Repositories.JobRepository;

@Service
@Transactional
public class JobService {
	
	@Autowired
	private JobRepository repository;
	
	public java.util.List<JobEntity> getAllJobs(){
		return this.repository.findAll();
	}
	
	public Optional<JobEntity> findJobById(Integer id){
		return repository.findById(id);
	}
	
	public void create (JobDTO job) {
		JobEntity newJob = new JobEntity(job.getDescription(), job.getStartDate(), job.getEndDate(), job.getAssignedResource());
		repository.save(newJob);
	}
	
	// The path variable is the jobId
	// We take the path variable, find the associated job, and set
	// isAssigned to the id of the humanResource
	public void updateJob (Integer jobId, UpdateJobDTO dataFromUser) {
		// Processes an AssignJobDTO
		JobEntity toBeAssigned;
		// Gets an already created job from the DB if it exists
		Optional<JobEntity> fetchedJob = findJobById(jobId);
		if (fetchedJob.isPresent()) {
			toBeAssigned = fetchedJob.get();
			// Assigns an ID value to isAssigned
			toBeAssigned.setAssignedResource(dataFromUser.getAssignedResource());
			// Returns the data to the DB
			repository.save(toBeAssigned); 
			// if the id remains the same, it'll just update the original entry
		} else {
			System.out.println("There is no job associated with that id");
		}
		


		
		}
		



}
