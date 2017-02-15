package org.br.spring.mongo.services.impl;

import java.util.List;

import org.br.spring.mongo.daos.UserRepository;
import org.br.spring.mongo.model.User;
import org.br.spring.mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Implementation of interface service user.
 * @author Bruno Mendes 
 * @since 1.0
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	/**
	 * variable access layer repository
	 */
	@Autowired
	private UserRepository repository;
	
	
	@Override
	public User save(final User user) {
		// save new user in mongodb
		return repository.insert(user);
	}

	@Override
	public User findById(final String id) {
		// return user by id
		return repository.findById(id);
	}

	@Override
	public List<User> findByName(final String name) {
		// return user by name
		return repository.findByName(name);
	}

	@Override
	public User findByEmail(final String email) {
		// return user by email
		return repository.findByEmail(email);
	}
	
	@Override
	public List<User> findAll() {
		// return all users
		return repository.findAll();
	}

	@Override
	public void update(final User user) {
		// alter user in mongodb
		repository.save(user);
	}

	@Override
	public void remove(final String id) {
		//find user by id
		User user = findById(id);
		
		// remove user in mongodb
		repository.delete(user);
	}

}
