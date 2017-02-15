package org.br.spring.mongo.rest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.br.spring.mongo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserRestTests {
	/**
	 * logger of the class test
	 */
    private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TestRestTemplate restTemplate;
	 
	@Before
	public void setUpBaseClass() {
	}
	/**
	 * Test rest create new user.
	 */
	
	public void create() {
		//prepared user
		User user = new User();
		user.setEmail("user1@test.com");
		user.setName("user1");
		user.setPassword("xxx");
		user.setPhone("+55 11 99999-9999");
		
		User response = restTemplate.postForObject("/mongo/user", user, User.class);
		
		log.info("Response rest create user: [" + response.getId() + "]");
	}
	/**
	 * Test rest update user
	 */
	@Test
	public void update() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "58a4906c4de5a338dbff134b");

		User user = new User();
		user.setId("58a4906c4de5a338dbff134b");
		user.setName("John");
		user.setEmail("john@test.com");
		user.setPhone("+55 11 99999-9999");
		
		restTemplate.put("/mongo/user/{id}", user, map);
	}
	/**
	 * Test rest find all users
	 */
	@Test
	public void findAll() {
		ResponseEntity<List<User>> response = restTemplate.exchange("/mongo/user",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
		List<User> users = response.getBody();
		
		users.forEach(user -> {
			log.info("User Name: " + user.getName());
			log.info("User Email: " + user.getEmail());
			log.info("User Phone: " + user.getPhone());
		});
		
	}

	/**
	 * Test rest remove user
	 */
	@Test
	public void remove() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "58a4906c4de5a338dbff134b");
		
		restTemplate.delete("/mongo/user/{id}", map);
	}

}
