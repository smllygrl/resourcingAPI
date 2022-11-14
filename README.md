# Job Assignment API

## Summary
Your task is to build a Resourcing API using the Java Spring Boot framework, that allows consumers to assign temps to jobs.

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

##### Assumptions

Temps can only have one job at a time (can’t be doing 2 jobs on the same date)

Temps can have many jobs, and job can have 1 temp assigned

Should be able to assign existing temps to jobs via POST /jobs & PATCH /jobs/{id}
