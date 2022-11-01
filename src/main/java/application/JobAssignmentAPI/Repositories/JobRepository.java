package application.JobAssignmentAPI.Repositories;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.JobAssignmentAPI.Entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
	// GET /jobs?assigned=false
	// Returns a list of jobs where there is no human resource assigned
	@Query(value = "SELECT * FROM resourcing.job where human_resource_id IS NULL", nativeQuery = true)
	List<Job> getAllUnassignedJobs();
	
	// GET /jobs?assigned=true
	// Returns a list of jobs where there is no human resource assigned
	@Query(value = "SELECT * FROM resourcing.job where human_resource_id IS NOT NULL", nativeQuery = true)
	List<Job> getAllAssignedJobs();
	
	@Query(value = "SELECT * FROM resourcing.job", nativeQuery = true)
	List<Job> getAllJobs();
	
	@Query(value = "SELECT * FROM resourcing.job WHERE id = :id")
	static
	Optional<Job> getJobById(@Param("id")Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
