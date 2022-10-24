package application.JobAssignmentAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import application.JobAssignmentAPI.Entities.HumanResourceEntity;

public interface HumanResourceRepository extends JpaRepository<HumanResourceEntity, Integer>{

}
