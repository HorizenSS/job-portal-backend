package com.ines.repository;


import com.ines.models.FileDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends MongoRepository<FileDB, String> {

}
