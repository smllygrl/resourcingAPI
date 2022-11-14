# Job Assignment API

## Summary
Your task is to build a Resourcing API using the Java Spring Boot framework, that allows consumers to assign temps to jobs.

### Endpoints

## Endpoints
| Endpoint | Method | Description                   | Status Code |
| -------- | ------ | ----------------------------- | ----------- |
| /        | GET    | Health Check returns “Hello World!!” | 200 OK |
| /jobs    | GET    | Return all jobs. Returns JSON array of results. | 200 OK or 204 NO CONTENT |
| /jobs?assigned={TRUE\|FALSE} | GET | Return all jobs that have been assigned. | 200 OK or 404 NOT FOUND |
| /jobs/{job_id} | GET    | Returns job associated with job id.  | 200 OK or 404 NOT FOUND |
| /jobs    | POST   | Create job; (requires a body)        | 201 CREATED or 400 BAD REQUEST |
| /jobs/{job_id}  | PATCH | Update start date, end date or Temp assigned to job (requires a body) | 200 OK or 400 BAD REQUEST |
| /jobs/{job_id} | DELETE | Delete job by id         | 204 NO CONTENT or 404 NOT FOUND |
| /resources   | GET    | Return all temps in a JSON array. | 200 OK or 204 NO CONTENT |
| /resources?jobId={job_id} | GET    | Return all temps available based on specified job's date range. Returns JSON array of results. | 200 OK or 204 NO CONTENT or 404 NOT FOUND |
| /resources/{resource_id} | GET    | Returns temp associated with temp id. | 200 OK or 404 NOT FOUND |
| /temps  | POST    | Create temp; (requires a body) | 201 CREATED or 400 BAD REQUEST |
| /resources/{resource_id}  | DELETE    | Delete temp by id  | 204 NO CONTENT or 404 NOT FOUND |

```
{
	id: ...,
	name: ...,
	startDate: ...,
	endDate: ...,
	temp: {
		id: ...,
		firstName: ...,
		lastName: ...,
	} // temp can also be null if a temp hasn't been assigned to the job
}
```

// GET /temps/{id}

```
{
	id: ...,
	firstName: ...,
	lastName: ...,
	jobs: [{
		id: ...,
		name: ...,
		startDate: ...,
		endDate: ...,
	}, ...] // can be empty if temp hasn't been assigned to jobs
}
```

##### Assumptions

Temps can only have one job at a time (can’t be doing 2 jobs on the same date)

Temps can have many jobs, and job can have 1 temp assigned

Should be able to assign existing temps to jobs via POST /jobs & PATCH /jobs/{id}

You must use a relational database

Bonus

Temps should be able to manage other temps (will require an additional field)

When you request a temp record it should display the reports of that temp

Should be represented in the database as a nested set

GET /temps/tree - should display the whole tree of temps

