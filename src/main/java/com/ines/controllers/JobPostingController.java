package com.ines.controllers;


import com.ines.models.JobPosting;
import com.ines.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class JobPostingController {

  @Autowired
  JobPostingRepository JobPostingRepository;

  @GetMapping("/jobPostings")
  public ResponseEntity<List<JobPosting>> getAllJobPostings(@RequestParam(required = false) String title) {
    try {
      List<JobPosting> JobPostings = new ArrayList<JobPosting>();

      if (title == null)
        JobPostingRepository.findAll().forEach(JobPostings::add);
      else
        JobPostingRepository.findByTitleContaining(title).forEach(JobPostings::add);

      if (JobPostings.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(JobPostings, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/jobPostings/{id}")
  public ResponseEntity<JobPosting> getJobPostingById(@PathVariable("id") String id) {
    Optional<JobPosting> JobPostingData = JobPostingRepository.findById(id);

    if (JobPostingData.isPresent()) {
      return new ResponseEntity<>(JobPostingData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/jobPostings")
  public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting JobPosting) {
    try {
      JobPosting _JobPosting = JobPostingRepository.save(new JobPosting(JobPosting.getTitle(),JobPosting.getJobType(),JobPosting.getSenioritylevel(),JobPosting.getSkills(),JobPosting.getDescription(),JobPosting.getLocation()));
      return new ResponseEntity<>(_JobPosting, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/jobPostings/{id}")
  public ResponseEntity<JobPosting> updateJobPosting(@PathVariable("id") String id, @RequestBody JobPosting JobPosting) {
    Optional<JobPosting> JobPostingData = JobPostingRepository.findById(id);

    if (JobPostingData.isPresent()) {
      JobPosting _JobPosting = JobPostingData.get();
      _JobPosting.setTitle(JobPosting.getTitle());
      _JobPosting.setDescription(JobPosting.getDescription());
      _JobPosting.setJobType(JobPosting.getJobType());
      _JobPosting.setSenioritylevel(JobPosting.getSenioritylevel());
      _JobPosting.setSkills(JobPosting.getSkills());
      _JobPosting.setLocation(JobPosting.getLocation());
      return new ResponseEntity<>(JobPostingRepository.save(_JobPosting), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/jobPostings/{id}")
  public ResponseEntity<HttpStatus> deleteJobPosting(@PathVariable("id") String id) {
    try {
      JobPostingRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/jobPostings")
  public ResponseEntity<HttpStatus> deleteAllJobPostings() {
    try {
      JobPostingRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }



}
