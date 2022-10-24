package application.JobAssignmentAPI.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.JobAssignmentAPI.DTOs.HumanResourceDTO;
import application.JobAssignmentAPI.Entities.HumanResourceEntity;
import application.JobAssignmentAPI.Services.HumanResourceService;

@RestController
@RequestMapping(value = "/resources")
public class HumanResourceController {
	@Autowired
	private HumanResourceService humanResourceService;
	
	// GET /resources
	// List all temps
	@GetMapping
	
	public List<HumanResourceEntity> getHumanResources() {
		return humanResourceService.allResources();
	}
	
	// GET /resources/id
	// Get temp by id
	@GetMapping(path = "/{id}")
	public Optional<HumanResourceEntity> getResourceById(@PathVariable Integer id) {
		// TO DO 
		// MANAGE CASES WHERE ID NOT FOUND
		return humanResourceService.findResourceById(id);
		
	}
	
	// POST /resources
	// Create a temp
	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveHumanResource(@Valid @RequestBody HumanResourceDTO humanResource) {
		humanResourceService.create(humanResource);
	}
	
	// @Query (value = "SELECT resource FROM resources")
	// GET /resources?jobId={jobId}
	// List all available resources for a given period of time
	// getAllAvailble
	// humanResourceService.allResources()
	// 

}
