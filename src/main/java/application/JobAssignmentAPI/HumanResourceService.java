package application.JobAssignmentAPI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HumanResourceService {
	
	@Autowired
	private HumanResourceRepository repository;
	
	public List<HumanResource> all() { 
		return repository.findAll();
	}
	
	public void create(HumanResourceDTO humanResource) {
		HumanResource human = new HumanResource(humanResource.getFirstName(), humanResource.getLastName());
		repository.save(human);
	}

}