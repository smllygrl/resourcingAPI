package application.JobAssignmentAPI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JobService {
	
	@Autowired
	private JobRepository repository;
	
	public java.util.List<JobEntity> all(){
		return this.repository.findAll();
	}
	public void create (JobDTO job) {
		JobEntity newJob = new JobEntity(job.getDescription(), job.getStartDate(), job.getEndDate());
		repository.save(newJob);
	}


}
