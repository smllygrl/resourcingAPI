package application.JobAssignmentAPI.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.JobAssignmentAPI.DTOs.HumanResourceDTO;
import application.JobAssignmentAPI.Entities.HumanResourceEntity;
import application.JobAssignmentAPI.Entities.JobEntity;
import application.JobAssignmentAPI.Repositories.HumanResourceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HumanResourceService {
	
	@Autowired
	private HumanResourceRepository repository;
	
	public List<HumanResourceEntity> allResources() { 
		return repository.findAll();
	}
	
	public Optional<HumanResourceEntity> findResourceById(Long id) {
		// TO DO
		// Remove optional once cases where ID not found are handled
		return repository.findById(id);
	}
	
	public void create(HumanResourceDTO humanResource) {
		HumanResourceEntity human = new HumanResourceEntity(humanResource.getFirstName(), humanResource.getLastName());
		repository.save(human);
	}
	
//	public boolean isAvailable(JobEntity newJob, HumanResource human) {
// 		if human.jobs = null YES
//		Else
//		find total number of assignedJobs	
//  	get dateRange of assignedJobs
//  	get dateRange of newJob 
// 			
	
	// public ArrayList<HumanResourceEntity> allAvailable (JobEntity job) {
	// allResource = List
	// availableResources = List
	// loop through resources and see if available
	// if yes, push to available resources
	// return availableResources;
	

}
