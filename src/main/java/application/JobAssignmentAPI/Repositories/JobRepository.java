package application.JobAssignmentAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import application.JobAssignmentAPI.Entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {

}
