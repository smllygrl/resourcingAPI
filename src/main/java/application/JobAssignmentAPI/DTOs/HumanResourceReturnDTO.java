package application.JobAssignmentAPI.DTOs;

public class HumanResourceReturnDTO {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
//	private List<JobReturnDTO> jobs;
	
	public HumanResourceReturnDTO() {};
	
	public HumanResourceReturnDTO(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public List<JobReturnDTO> getJobs() {
//		return jobs;
//	}
//
//	public void setJobs(List<JobReturnDTO> jobs) {
//		this.jobs = jobs;
//	}

}
