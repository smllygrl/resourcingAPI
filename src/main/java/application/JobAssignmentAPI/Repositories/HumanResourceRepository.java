package application.JobAssignmentAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import application.JobAssignmentAPI.Entities.HumanResource;

public interface HumanResourceRepository extends JpaRepository<HumanResource, Integer>{
	
	// GetAllAvailable
	

}
