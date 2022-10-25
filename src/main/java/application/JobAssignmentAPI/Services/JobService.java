package application.JobAssignmentAPI.Services;

import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.JobAssignmentAPI.DTOs.JobDTO;
import application.JobAssignmentAPI.DTOs.UpdateJobDTO;
import application.JobAssignmentAPI.Entities.HumanResourceEntity;
import application.JobAssignmentAPI.Entities.JobEntity;
import application.JobAssignmentAPI.Repositories.HumanResourceRepository;
import application.JobAssignmentAPI.Repositories.JobRepository;

@Service
@Transactional
public class JobService {
	
	@Autowired
	JobRepository repository;
	
	@Autowired
	HumanResourceRepository resourcesRepository;
	
	public List<JobEntity> getAllJobs(){
		// NOT FOUND EXCEPTION?
		return this.repository.findAll();
	}
	
	public Optional<JobEntity> findJobById(Integer id){
		// NOT FOUND EXCEPTION?
		// job entity return dto
		// shape to display back to client
		return repository.findById(id);
	}
	
	// JobDTO comes from user (eg. JSON in Postman)
	public void create (JobDTO job) {
		// Data is de-structured from user entry to create a new JobEntity
		JobEntity newJob = new JobEntity(job.getDescription(), job.getStartDate(), job.getEndDate(), job.getAssignedResource());
		repository.save(newJob);
	}
	
	public void updateJob (Integer jobId, UpdateJobDTO dataFromUser) {
		Optional<JobEntity> fetchedJob = findJobById(jobId);
	
		if (fetchedJob.isPresent()) {
			// Gets an already created job from the DB 
			JobEntity job = fetchedJob.get();
			// Get id of resource to be assigned
			Integer idOfResource = dataFromUser.getResourceId();
			// Assigns an HumanEntity value to assignedResource
			Optional<HumanResourceEntity> fetchedResource = resourcesRepository.findById(idOfResource);
			if(fetchedResource.isPresent()) {
				HumanResourceEntity resource = fetchedResource.get();
				job.setHumanResource(resource);
				// Returns the data to the DB
				repository.save(job); 
			}
			// Thanks to persistence, if the ID doesn't change, the original entry is simply updated
		} else {
			// NOT FOUND EXCEPTION
			System.out.println("There is no job associated with that id");
		}
	}
	
	// The params here represent the query, whether they are looking for assigned (true) or unassigned (false) jobs
	@SuppressWarnings("null")
	public List<JobEntity> queryAssignedJobs (Boolean queryValue) {
		// Create an empty list
		List<JobEntity> allJobs = getAllJobs();
		List<JobEntity> returnList = null;
		JobEntity jobToCheck;
		Boolean isAssigned;
		
		for (int i = 0; i < allJobs.size(); i++) {
			
			jobToCheck = allJobs.get(i);
			
			if (jobToCheck.getHumanResource() != null) {
				isAssigned = true;
			} else {
				isAssigned = false;
			}
			
			if (isAssigned == queryValue) {
				returnList.add(jobToCheck);
			}
	
		}
		
		return returnList;
		
	}
		



}
