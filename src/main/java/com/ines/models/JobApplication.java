package com.ines.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "jobApplications")
public class JobApplication {
	@Id
	private String id;
	private Boolean Applied;
	private String resume;
	private JobPosting jobPosting;
	private User user;

	public JobApplication() {
	}

	@Override
	public String toString() {
		return "JobApplication{" +
				"id='" + id + '\'' +
				", Applied=" + Applied +
				", resume='" + resume + '\'' +
				", jobPosting=" + jobPosting +
				", user=" + user +
				'}';
	}

	public JobApplication(Boolean applied, String resume, JobPosting jobPosting, User user) {
		Applied = applied;
		this.resume = resume;
		this.jobPosting = jobPosting;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getApplied() {
		return Applied;
	}

	public void setApplied(Boolean applied) {
		Applied = applied;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public JobPosting getJobPosting() {
		return jobPosting;
	}

	public void setJobPosting(JobPosting jobPosting) {
		this.jobPosting = jobPosting;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
