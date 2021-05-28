package com.ines;

import com.ines.models.ERole;
import com.ines.models.Role;
import com.ines.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBootSecurityJwtMongodbApplication {
	@Autowired
	RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtMongodbApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterTheStart() {
		System.out.println("the application started...");

		/*Role role1=new Role(ERole.ROLE_USER);
		Role role2=new Role(ERole.ROLE_ADMIN);
		Role role3=new Role(ERole.ROLE_MODERATOR);
		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);*/
	}
}
