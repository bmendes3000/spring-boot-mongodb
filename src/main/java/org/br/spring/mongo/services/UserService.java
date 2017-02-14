package org.br.spring.mongo.services;

import java.util.List;

import org.br.spring.mongo.vos.UserVO;
/**
 * Class service to user.
 * @author Bruno Mendes
 * @since 1.0
 * @version 1.0
 */
public interface UserService {
	/**
	 * Method responsible by save new user in database
	 * @param user {@link UserVO}
	 */
	void save(final UserVO user);
	/**
	 * Method responsible by find user by id.  
	 * @param id {@link String}
	 * @return {@link UserVO}
	 */
	UserVO findById(final String id);
	/**
	 * Method responsible by find user by name
	 * @param name {@link String}
	 * @return {@link List}
	 */
	List<UserVO> findByName(final String name);
	/**
	 * Method responsible by find user by email
	 * @param email {@link String}
	 * @return {@link UserVO}
	 */
	UserVO findByEmail(final String email);
	/**
	 * Method responsible by update user
	 * @param user
	 */
	void update(final UserVO user);
	/**
	 * Method responsible by remove user in database.
	 * @param id {@link String}
	 */
	void remove(final String id);

}
