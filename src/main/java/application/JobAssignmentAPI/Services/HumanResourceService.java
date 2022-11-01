package application.JobAssignmentAPI.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.JobAssignmentAPI.DTOs.HumanResourceDTO;
import application.JobAssignmentAPI.Entities.HumanResource;
import application.JobAssignmentAPI.Entities.Job;
import application.JobAssignmentAPI.Repositories.HumanResourceRepository;
import application.JobAssignmentAPI.Repositories.JobRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HumanResourceService {
	
	@Autowired
	HumanResourceRepository resourcesRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	public List<HumanResource> allResources() { 
		return resourcesRepository.findAll();
	}
	
	public Optional<HumanResource> findResourceById(Integer id) {
		// TO DO
		// Remove optional once cases where ID not found are handled
		return resourcesRepository.findById(id);
	}
	
	public void create(HumanResourceDTO humanResource) {
		HumanResource human = new HumanResource(humanResource.getFirstName(), humanResource.getLastName());
		resourcesRepository.save(human);
	}
	
	// LocalDate format yyyy-mm-dd
	public Boolean isAvailable(Optional<Job> optionalJob, HumanResource humanResource) {
		Job newJob = null;
		if(optionalJob.isPresent()) {
			newJob = optionalJob.get();
		}
		LocalDate newStartDate = newJob.getStartDate();
		LocalDate newEndDate = newJob.getEndDate();
		Boolean available = false;
		if (humanResource.getJobs() != null) {
			List<Job> jobs = humanResource.getJobs();
			for(int i = 0; i < jobs.size(); i++) {
				LocalDate assignedJobStart = jobs.get(i).getStartDate();
				LocalDate assignedJobEnd = jobs.get(i).getEndDate();
				if(!newStartDate.isAfter(assignedJobStart) && !newEndDate.isBefore(assignedJobEnd)) {
					available = true;
					break;
				} 
			}
		} 
		return available;
	}
	
	public List<HumanResource> allAvailable (Integer jobId) {
		Optional<Job> newJob = java.util.Optional.empty();
		try {
			newJob = JobRepository.getJobById(jobId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<HumanResource> availableResources = null;
		List<HumanResource> allResources = allResources();
		for(int i = 0; i < allResources.size(); i++) {
			HumanResource currentHuman = allResources.get(i);
			if (isAvailable(newJob, currentHuman)) {
				availableResources.add(currentHuman);
			}
		}
		return availableResources;
	}
}
