package com.tcs.iou;

import com.tcs.iou.entities.login.Role;
import com.tcs.iou.entities.login.User;
import com.tcs.iou.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SpringBootApplication
public class TcsGeoRevenueDashboardApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TcsGeoRevenueDashboardApplication.class, args);
	}

	@Autowired private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		try{
			if(!userRepository.findByUsername("user").getUsername().equalsIgnoreCase("user")) {
				User user = new User();
				user.setUsername("user");
				user.setPassword("$2a$10$GpJr4srZtR.WIoataje.K.96FqpH9UJSa0mAnubgzlCPICVjcyMOu");

				Role role = new Role();
				role.setRole("ADMIN");

				Role role2 = new Role();
				role2.setRole("USER");

				Set<Role> roles = new HashSet<>();
				roles.add(role);
				roles.add(role2);
				user.setRoles(roles);
				userRepository.save(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
