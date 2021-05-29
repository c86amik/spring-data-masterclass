package com.springcavaj.springmongo.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcavaj.springmongo.exception.SpringDataMongoRestException;
import com.springcavaj.springmongo.model.User;
import com.springcavaj.springmongo.repository.SpringDataMongoRestRepository;

/**
 * @author springcavaj
 *
 */
@RestController
public class SpringDataMongoRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataMongoRestController.class);
	
	@Autowired
	private SpringDataMongoRestRepository springDataMongoRestRepository;
	
	@GetMapping("/allUsers")
    public List<User> getAllUserData() {
		LOGGER.info("getAllUserData -> All Data are fetched");
		return springDataMongoRestRepository.findAll();
    }
	
	@PostMapping("/saveUser")
    public User saveUserData(@RequestBody User user) {
        LOGGER.info("saveUserData -> New Record of User saved");
        return springDataMongoRestRepository.save(user);
    }
	
	@PutMapping("/updateUser/{id}")
    public User updateUserData(@PathVariable(value = "id") String userId, @RequestBody User user) {
        LOGGER.info("updateUserData -> Update the existing User Record");
        User model = springDataMongoRestRepository.findById(userId)
        		.orElseThrow(() -> new SpringDataMongoRestException("User Record not found", userId));
        if (null != model) {
        	return springDataMongoRestRepository.save(user);
		}
        return model;
    }

	@GetMapping("/getUser/{id}")
    public User getUserDataById(@PathVariable(value = "id") String userId) {
    	User user = springDataMongoRestRepository.findById(userId)
    			.orElseThrow(() -> new SpringDataMongoRestException("User Record not found", userId));
    	LOGGER.info("getUserDataById -> Fetch the User Detail by userId as : {}", userId);
        return user;
    }
	
	@GetMapping("/getUserByFirstName/{firstName}")
    public List<User> getUserDataByFirstName(@PathVariable(value = "firstName") String firstName) {
    	List<User> user = springDataMongoRestRepository.findByFirstName(firstName);
    	LOGGER.info("getUserDataByFirstName -> Fetch the User Detail by First Name as : {}", firstName);
        return user;
    }
	
	@GetMapping("/getUserByLastName/{lastName}")
    public List<User> getUserDataByLastName(@PathVariable(value = "lastName") String lastName) {
		List<User> user = springDataMongoRestRepository.findByLastName(lastName);
    	LOGGER.info("getUserDataByLastName -> Fetch the User Detail by Last Name as : {}", lastName);
        return user;
    }
	
	@GetMapping("/getUserByMobileNo/{mobileNo}")
    public User getUserDataByMobileNo(@PathVariable(value = "mobileNo") String mobileNo) {
    	User user = springDataMongoRestRepository.findByMobileNo(mobileNo);
    	LOGGER.info("getUserDataByMobileNo -> Fetch the User Detail by Mobile No as : {}", mobileNo);
        return user;
    }
	
	@GetMapping("/getUserByEmail/{email}")
    public User getUserDataByEmail(@PathVariable(value = "email") String email) {
    	User user = springDataMongoRestRepository.findByEmail(email);
    	LOGGER.info("getUserDataByEmail -> Fetch the User Detail by Email as : {}", email);
        return user;
    }
	
	@GetMapping("/getUserByPan/{panNo}")
    public User getUserDataByPan(@PathVariable(value = "panNo") String panNo) {
    	User user = springDataMongoRestRepository.findByPanNo(panNo);
    	LOGGER.info("getUserDataByPan -> Fetch the User Detail by PAN No as : {}", panNo);
        return user;
    }
	
	@DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") String userId) {
		User user = springDataMongoRestRepository.findById(userId)
				.orElseThrow(() -> new SpringDataMongoRestException("User not found", userId));
	    springDataMongoRestRepository.delete(user);
    	LOGGER.info("deleteUser -> Delete the User of userId : {}", userId);
    }
	
	@GetMapping("/getUserByName/{firstName}/{lastName}")
    public User getUserByName(@PathVariable(value = "firstName") String firstName, 
    		@PathVariable(value = "lastName") String lastName) {
    	User user = springDataMongoRestRepository.findByFirstAndLastName(firstName, lastName);
    	LOGGER.info("getUserByName -> Fetch the User Detail by FirstName and LastName as : {}, {}", firstName, lastName);
        return user;
    }
	
}
