package com.ines.repository;


import com.ines.models.JobPosting;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobPostingRepository extends MongoRepository<JobPosting, String> {
  List<JobPosting> findByTitleContaining(String title);
}
