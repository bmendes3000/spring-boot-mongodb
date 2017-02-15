package org.br.spring.mongo.daos;

import java.util.List;

import org.br.spring.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, String> {
	/**
	 * Query responsible by return user by field id
	 * @param id {@link String}
	 * @return {@link User}
	 */
	@Query("{ id: ?0 }")
	User findById(final String id);
	
	/**
	 * Query responsible by return users by field name 
	 * @param userName {@link String}
	 * @return {@link User}
	 */
	@Query("{ name: { $text: { $search: ?0 } } }")
	List<User> findByName(final String name);
	/**
	 * Query responsible by return user by field email
	 * @param email {@link String}
	 * @return {@link User}
	 */
	@Query("{ email: ?0 }")
	User findByEmail(final String email);
	
	
}
