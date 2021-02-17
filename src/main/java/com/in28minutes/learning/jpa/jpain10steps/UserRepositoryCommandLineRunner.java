package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

/**
 * @author Pramod Kumar
 *
 */
@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	public static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("JILL", "Admin");
		userRepository.save(user);
		Optional<User> userWithId = userRepository.findById(1l);
//		//new User is created :User [id=1, name=JILL, role=Admin]
		log.info("new User is created :" + user);
		
		//to query all users
		List<User> users = userRepository.findAll();
		log.info("All users : "+users);

	}
}
