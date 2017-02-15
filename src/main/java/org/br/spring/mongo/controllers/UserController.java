package org.br.spring.mongo.controllers;

import java.util.List;

import org.br.spring.mongo.model.User;
import org.br.spring.mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to user.
 * @author Bruno Mendes
 * @since 1.0
 * @version 1.0
 */
@RestController
@RequestMapping("/mongo/user")
public class UserController {
	/**
	 * service user.
	 */
	@Autowired
	private UserService service;
	/**
	 * Rest type post, responsible by create new user.
	 * @param user {@link User}
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		//sending the information to layer of service
		return service.save(user);
	}
	/**
	 * Rest type get, responsible by return all users.
	 * @return {@link List}
	 */
	@RequestMapping(value = "", 
					method = RequestMethod.GET, 
					produces = {"application/json"})
	public @ResponseBody List<User> findAll() {
		//call service for return all users
		return service.findAll();
	}
	/**
	 * Rest type get, responsible by find user by id.
	 * @param id {@link String}
	 * @return {@link User}
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") String id) {
		//call service for return user.
		return service.findById(id);
	}
	/**
	 * Rest type put, responsible by update user.
	 * @param userUpdate {@link User}
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") String id, @RequestBody User userUpdate) {
		//call service to update user
		service.update(userUpdate);
	}
	/**
	 * Rest type delete, responsible by remove user.
	 * @param id {@link String}
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable("id") String id) {
		//call service to remove user
		service.remove(id);
	}
}
