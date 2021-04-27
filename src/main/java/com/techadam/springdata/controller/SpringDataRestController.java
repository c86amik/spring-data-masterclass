package com.techadam.springdata.controller;
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

import com.techadam.springdata.exception.SpringDataRestException;
import com.techadam.springdata.model.User;
import com.techadam.springdata.repository.SpringDataRestRepository;

/**
 * @author techadam
 *
 */
@RestController
public class SpringDataRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataRestController.class);
	
	@Autowired
	private SpringDataRestRepository springDataRestRepository;
	
	@GetMapping("/allUsers")
    public List<User> getAllUserData() {
		LOGGER.info("getAllUserData -> All Data are fetched");
		return springDataRestRepository.findAll();
    }
	
	@PostMapping("/saveUser")
    public User saveUserData(@RequestBody User user) {
        LOGGER.info("saveUserData -> New Record of User saved");
        return springDataRestRepository.save(user);
    }
	
	@PutMapping("/updateUser/{id}")
    public User updateUserData(@PathVariable(value = "id") String userId, @RequestBody User user) {
        LOGGER.info("updateUserData -> Update the existing User Record");
        User model = springDataRestRepository.findById(userId)
        		.orElseThrow(() -> new SpringDataRestException("User Record not found", userId));
        if (null != model) {
        	return springDataRestRepository.save(user);
		}
        return model;
    }

	@GetMapping("/getUser/{id}")
    public User getUserDataById(@PathVariable(value = "id") String userId) {
    	User user = springDataRestRepository.findById(userId)
    			.orElseThrow(() -> new SpringDataRestException("User Record not found", userId));
    	LOGGER.info("getUserDataById -> Fetch the User Detail by userId as : {}", userId);
        return user;
    }
	
	@GetMapping("/getUserByFirstName/{firstName}")
    public List<User> getUserDataByFirstName(@PathVariable(value = "firstName") String firstName) {
    	List<User> user = springDataRestRepository.findByFirstName(firstName);
    	LOGGER.info("getUserDataByFirstName -> Fetch the User Detail by First Name as : {}", firstName);
        return user;
    }
	
	@GetMapping("/getUserByLastName/{lastName}")
    public List<User> getUserDataByLastName(@PathVariable(value = "lastName") String lastName) {
		List<User> user = springDataRestRepository.findByLastName(lastName);
    	LOGGER.info("getUserDataByLastName -> Fetch the User Detail by Last Name as : {}", lastName);
        return user;
    }
	
	@GetMapping("/getUserByMobileNo/{mobileNo}")
    public User getUserDataByMobileNo(@PathVariable(value = "mobileNo") String mobileNo) {
    	User user = springDataRestRepository.findByMobileNo(mobileNo);
    	LOGGER.info("getUserDataByMobileNo -> Fetch the User Detail by Mobile No as : {}", mobileNo);
        return user;
    }
	
	@GetMapping("/getUserByEmail/{email}")
    public User getUserDataByEmail(@PathVariable(value = "email") String email) {
    	User user = springDataRestRepository.findByEmail(email);
    	LOGGER.info("getUserDataByEmail -> Fetch the User Detail by Email as : {}", email);
        return user;
    }
	
	@GetMapping("/getUserByPan/{panNo}")
    public User getUserDataByPan(@PathVariable(value = "panNo") String panNo) {
    	User user = springDataRestRepository.findByPanNo(panNo);
    	LOGGER.info("getUserDataByPan -> Fetch the User Detail by PAN No as : {}", panNo);
        return user;
    }
	
	@DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") String userId) {
		User user = springDataRestRepository.findById(userId)
				.orElseThrow(() -> new SpringDataRestException("User not found", userId));
	    springDataRestRepository.delete(user);
    	LOGGER.info("deleteUser -> Delete the User of userId : {}", userId);
    }
	
	@GetMapping("/getUserByName/{firstName}/{lastName}")
    public User getUserByName(@PathVariable(value = "firstName") String firstName, 
    		@PathVariable(value = "lastName") String lastName) {
    	User user = springDataRestRepository.findByFirstAndLastName(firstName, lastName);
    	LOGGER.info("getUserByName -> Fetch the User Detail by FirstName and LastName as : {}, {}", firstName, lastName);
        return user;
    }
	
}
