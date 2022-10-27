package application.JobAssignmentAPI.Services;

import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.JobAssignmentAPI.DTOs.HumanResourceReturnDTO;
import application.JobAssignmentAPI.DTOs.JobDTO;
import application.JobAssignmentAPI.DTOs.JobReturnDTO;
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
		// Why does this work without a repository method?
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
	public List<JobReturnDTO> queryAssignedJobs (Boolean queryValue) {
		// Get a list of assigned or unassigned jobs
		// !! Below is recursive as it return the temps and their jobs and then the jobs and their temps
		List<JobEntity> jobs = queryValue ? repository.getAllAssignedJobs() : repository.getAllUnassignedJobs();
		// Instantiate a List of return DTOs
		List<JobReturnDTO> returnList = null;
		// If there are jobs that match the assigned/ unassigned query
		if (jobs != null) {
			// Instantiate a JobEntity for destructuring
			JobEntity beingProcessed;
			for(int i = 0; i < jobs.size(); i++) {
				// Grab a job from the list the initial query returned
				beingProcessed = jobs.get(i);
				// Destructure to create return DTO
				JobReturnDTO jobForReturn = new JobReturnDTO(beingProcessed.getId(), beingProcessed.getDescription(), beingProcessed.getStartDate(), beingProcessed.getEndDate());
				// If the job has a human assigned to it
				if (beingProcessed.getHumanResource() != null) {
					HumanResourceEntity resourceBeingProcessed = beingProcessed.getHumanResource();
					HumanResourceReturnDTO resourceForReturn = new HumanResourceReturnDTO(resourceBeingProcessed.getId(),resourceBeingProcessed.getFirstName(), resourceBeingProcessed.getLastName() );
					jobForReturn.setAssignedResource(resourceForReturn);
				}
				returnList.add(jobForReturn);
			}
		}
		
		return returnList;
	}
		



}
