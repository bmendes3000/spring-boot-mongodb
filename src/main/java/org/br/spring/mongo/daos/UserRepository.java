package org.br.spring.mongo.daos;

import java.util.List;

import org.br.spring.mongo.vos.UserVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<UserVO, String> {
	/**
	 * Query responsible by return user by field id
	 * @param id {@link String}
	 * @return {@link UserVO}
	 */
	@Query("{ id: ?0 }")
	UserVO findById(final String id);
	
	/**
	 * Query responsible by return users by field name 
	 * @param userName {@link String}
	 * @return {@link UserVO}
	 */
	@Query("{ name: { $text: { $search: ?0 } } }")
	List<UserVO> findByName(final String name);
	/**
	 * Query responsible by return user by field email
	 * @param email {@link String}
	 * @return {@link UserVO}
	 */
	@Query("{ email: ?0 }")
	UserVO findByEmail(final String email);
	
	
}
