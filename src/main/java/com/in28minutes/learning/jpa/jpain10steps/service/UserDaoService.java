package com.in28minutes.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

//repository is an annotation which is defined in spring framework.
//it indicates it is interacting with the database.

// we want to be inside tarnsaction for performing the insert and modify operations.
@Repository
@Transactional //we can use this annotation on the class as well as methods.
public class UserDaoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * --> entityManager is a interface for persistence context.
	 * --> when i say entityManager.persist(user), what it does is persist to the datebase and 
	 *also starts tracking it in the persistence context. user is now inside the persistence context, 
	 *--> what ever changes i make to the user will be tracked by the persistence context.
	 *--> entity manager only tracks those objects which are persisted through it.
	 */
	
	//this will accept the user and save user down to the database.
	public long insert(User user) {
		//persist is a method which is uesd to make an instance managed persistent.
		//open transaction make the change, what ever changes you need to do and close the transaction 
		entityManager.persist(user);
		//close the transaction.
		return user.getId();
	}
	
	/*
	 *insted of implementing transaction management in each method what JPA provides is a simple interface to do declaritive transaction management.
	 *the way we can do it by saying transactional.
	 *@Transactional for class says each methods would be transactional.
	 */
}
