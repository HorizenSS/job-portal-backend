package com.ines.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "jobPostings")
public class JobPosting {
  @Id
  private String id;

  private String title;
  private String description;
  private String senioritylevel;
  private String skills;
  private String jobType;
  private String location;



  @Override
  public String toString() {
    return "JobPosting{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", senioritylevel='" + senioritylevel + '\'' +
            ", skills=" + skills +
            ", jobType='" + jobType + '\'' +
            ", location='" + location + '\'' +
            '}';
  }

  public JobPosting(String title, String description, String senioritylevel, String skills, String jobType, String location) {

    this.title = title;
    this.description = description;
    this.senioritylevel = senioritylevel;
    this.skills = skills;
    this.jobType = jobType;
    this.location = location;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSenioritylevel() {
    return senioritylevel;
  }

  public void setSenioritylevel(String senioritylevel) {
    this.senioritylevel = senioritylevel;
  }

  public String getSkills() {
    return skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}




