package org.br.spring.mongo.rest;

import org.br.spring.mongo.controllers.UserController;
import org.br.spring.mongo.vos.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserRestTests {
	/**
	 * variable mock mvc
	 */
	 @Autowired
	 private MockMvc mvc;
	
	/**
	 * Test rest create new user.
	 */
	@Test
	public void create() {
		UserVO user = new UserVO();
		user.setEmail("user1@test.com");
		user.setName("user1");
		user.setPassword("xxx");
		user.setPhone("+55 11 99999-9999");
		
		
	}
	/**
	 * Test rest find by id user
	 */
	@Test
	public void findById() {
	}
	/**
	 * Test rest update user
	 */
	@Test
	public void update() {
	}
	/**
	 * Test rest remove user
	 */
	@Test
	public void remove() {
	}

}
