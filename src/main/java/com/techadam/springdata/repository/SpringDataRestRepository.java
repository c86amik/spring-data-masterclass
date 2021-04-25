/**
 * 
 */
package com.techadam.springdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techadam.springdata.model.UserModel;

/**
 * @author techadam
 *
 */
@Repository
public interface SpringDataRestRepository extends MongoRepository<UserModel, String>{
	
	public UserModel findByFirstName(String firstName);
	
	public UserModel findByLastName(String lastName);
	
	public UserModel findByMobileNo(String mobileNo);
	
	public UserModel findByEmail(String email);
	
	public UserModel findByPanNo(String panNo);
}
