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
	// Returns a list of jobs where there is no human resource assigned
	@Query(value = "SELECT * FROM resourcing.job_entity where human_resource_id IS NULL", nativeQuery = true)
	List<JobEntity> getAllUnassignedJobs();
	
	
	// GET /jobs?assigned=true
	// Returns a list of jobs where there is no human resource assigned
	@Query(value = "SELECT * FROM resourcing.job_entity where human_resource_id IS NOT NULL", nativeQuery = true)
	List<JobEntity> getAllAssignedJobs();

}
