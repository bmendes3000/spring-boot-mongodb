package org.br.spring.mongo.services.impl;

import java.util.List;

import org.br.spring.mongo.daos.UserRepository;
import org.br.spring.mongo.services.UserService;
import org.br.spring.mongo.vos.UserVO;
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
	public void save(final UserVO user) {
		// save new user in mongodb
		repository.insert(user);
	}

	@Override
	public UserVO findById(final String id) {
		// return user by id
		return repository.findById(id);
	}

	@Override
	public List<UserVO> findByName(final String name) {
		// return user by name
		return repository.findByName(name);
	}

	@Override
	public UserVO findByEmail(final String email) {
		// return user by email
		return repository.findByEmail(email);
	}

	@Override
	public void update(final UserVO user) {
		// alter user in mongodb
		repository.save(user);
	}

	@Override
	public void remove(final String id) {
		//find user by id
		UserVO user = findById(id);
		
		// remove user in mongodb
		repository.delete(user);
	}

}
