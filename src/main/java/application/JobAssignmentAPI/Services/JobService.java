package application.JobAssignmentAPI.Services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.JobAssignmentAPI.DTOs.JobDTO;
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
	
	public Optional<JobEntity> findJobById(Long id){
		return repository.findById(id);
	}
	
	public void create (JobDTO job) {
		JobEntity newJob = new JobEntity(job.getDescription(), job.getStartDate(), job.getEndDate());
		repository.save(newJob);
	}


}
