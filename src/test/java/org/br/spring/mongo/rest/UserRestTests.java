package org.br.spring.mongo.rest;


import java.util.HashMap;
import java.util.Map;

import org.br.spring.mongo.vos.UserVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
		//TODO - Clear all user
	}
	/**
	 * Test rest create new user.
	 */
	@Test
	public void create() {
		//prepared user
		UserVO user = new UserVO();
		user.setId("1");
		user.setEmail("user1@test.com");
		user.setName("user1");
		user.setPassword("xxx");
		user.setPhone("+55 11 99999-9999");
		
		String response = restTemplate.postForObject("/mongo/user", user, String.class);
		
		log.info("Response rest create user: [" + response + "]");
	}
	/**
	 * Test rest find by id user
	 */
	@Test
	public void findById() {
		//find user by id
		Map<String, String> path = new HashMap<String, String>();
		path.put("id", "1");
		
		UserVO user = restTemplate.getForObject("/mongo/user", UserVO.class, path);
		
		
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
