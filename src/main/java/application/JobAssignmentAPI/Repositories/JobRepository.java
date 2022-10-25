package application.JobAssignmentAPI.Repositories;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import application.JobAssignmentAPI.Entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {
	
	// GET /jobs?assigned=false
	@Query(value = "SELECT job_entity FROM resourcing WHERE is_assigned IS NULL", nativeQuery = true)
	List<JobEntity> getAllUnassignedJobs();
	
	
	// GET /jobs?assigned=true
	@Query(value = "SELECT job_entity FROM reosourcing WHERE is_assigned IS NOT NULL", nativeQuery = true)
	List<JobEntity> getAllAssignedJobs();

}
