package com.ines;

import com.ines.models.ERole;
import com.ines.models.Role;
import com.ines.models.User;
import com.ines.repository.RoleRepository;
import com.ines.repository.UserRepository;
import com.ines.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityJwtMongodbApplication {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtMongodbApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterTheStart() {
		System.out.println("the application started...");
		/*Role role1=new Role(ERole.ROLE_SEEKER);
		Role role2=new Role(ERole.ROLE_ADMIN);
		Role role3=new Role(ERole.ROLE_RECRUITER);
		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);
		User user=userRepository.findByUsername("recruiter").get();
		Set<Role> roleSet= new HashSet<>();
		Role newRole=roleRepository.findByName(ERole.ROLE_RECRUITER).get();
		roleSet.add(newRole);
		user.setRoles(roleSet);
		System.out.println(user);
		userRepository.save(user);*/
	}
}
