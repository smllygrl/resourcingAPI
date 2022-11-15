# Job Assignment API

## Summary
This is a Resourcing API using the Java Spring Boot framework. It allows users to create jobs, human resources, and assign said resources to jobs.

## Endpoints
| Endpoint | Method | Description                   | Status Code | Complete |
| -------- | ------ | ----------------------------- | ----------- | -------- |
| /        | GET    | Health Check returns “Hello World!!” | 200 OK | Y |
| /jobs    | GET    | Return all jobs. Returns JSON array of results. | 200 OK or 204 NO CONTENT | Y |
| /jobs?assigned={TRUE\|FALSE} | GET | Return all jobs that have been assigned. | 200 OK or 404 NOT FOUND | N |
| /jobs/{job_id} | GET    | Returns job associated with job id.  | 200 OK or 404 NOT FOUND | Y |
| /jobs    | POST   | Create job; (requires a body)        | 201 CREATED or 400 BAD REQUEST | Y |
| /jobs/{job_id}  | PATCH | Update start date, end date or resource assigned to job (requires a body) | 200 OK or 400 BAD REQUEST | Y |
| /jobs/{job_id} | DELETE | Delete job by id         | 204 NO CONTENT or 404 NOT FOUND | N |
| /resources   | GET    | Return all resources in a JSON array. | 200 OK or 204 NO CONTENT | Y |
| /resources?jobId={job_id} | GET    | Return all resources available based on specified job's date range. Returns JSON array of results. | 200 OK or 204 NO CONTENT or 404 NOT FOUND | N |
| /resources/{resource_id} | GET    | Returns resources associated with temp id. | 200 OK or 404 NOT FOUND | Y |
| /temps  | POST    | Create temp; (requires a body) | 201 CREATED or 400 BAD REQUEST | Y |
| /resources/{resource_id}  | DELETE    | Delete temp by id  | 204 NO CONTENT or 404 NOT FOUND | Y |

## Assumptions and Actions

| Assumption | Action | Complete |
| ---------- | ------ | -------- |
| Resources can only have one job at a time (can’t be doing 2 jobs on the same date) | - Ensure logic is present to check if resource is availble within the time frame of a proposed job <br> - Ensure the type associated with start date and end date of a job is compatible with these time based checks <br> - Unit tests to confirm functionality of logic when assigning a job | N |
| Resources can have many jobs, and job can have 1 resource assigned | - Ensure entity of resource can hold many jobs eg. List<Jobs> <br> - Ensure entity of job can hold only 1 resource (id? name?) | N |
| Should be able to assign existing resources to jobs via POST /jobs & PATCH /jobs/{id} | - Ensure DTO for POST /jobs has space & functionality for resource <br> - Ensure DTO for PATCH /jobs/{id} updates only the resource | Y |

## Challenges and Solutions

##### CHALLENGE: Entity Relationship Rescursive Serialisation Errors
During the development of the endpoint /jobs?assigned={TRUE\|FALSE}, I experienced consistent infinte loops/ stack overflows. This is because the list of jobs that was returned also returned the resource assigned to the job, and then the jobs assigned to that resources, and then the resource assigned to the job etc.

One way I tried to remediate this was through using a DTO which did not return the resource of the job on return in my service layer. However, due to the return type in my controller, this was not successful.

##### SOLUTION: FasterXML Annotation
```
@JsonBackReference
private List<Job> jobs;
```
This annotation is used to display objects with a parent child relationship.

@JsonBackReference = refers to a child object (omitted from serialisation)

@JsonManagedReference = refers to a parent object (serialised normally)


