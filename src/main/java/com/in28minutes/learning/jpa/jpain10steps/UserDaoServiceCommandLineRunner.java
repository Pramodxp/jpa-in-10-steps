package com.in28minutes.learning.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserDaoService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{
	
	public static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		// i want save the user.
		User user = new User("Jack","Admin");
		long id = userDaoService.insert(user);
		//new User is created :User [id=1, name=Jack, role=Admin]
		log.info("new User is created :"+ user);
	}

}
