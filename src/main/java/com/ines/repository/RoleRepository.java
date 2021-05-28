package com.ines.repository;

import java.util.Optional;

import com.ines.models.ERole;
import com.ines.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);

}
