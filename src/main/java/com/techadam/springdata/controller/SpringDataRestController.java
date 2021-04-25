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
import com.techadam.springdata.model.UserModel;
import com.techadam.springdata.repository.SpringDataRestRepository;

/**
 * 
 */

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
    public List<UserModel> getAllUserData() {
		LOGGER.info("getAllUserData -> All Data are fetched");
		return springDataRestRepository.findAll();
    }
	
	@PostMapping("/saveUser")
    public UserModel saveUserData(@RequestBody UserModel userModel) {
        LOGGER.info("saveUserData -> New Record of User saved");
        return springDataRestRepository.save(userModel);
    }
	
	@PutMapping("/updateUser/{id}")
    public UserModel updateUserData(@PathVariable(value = "id") String userId, @RequestBody UserModel userModel) {
        LOGGER.info("updateUserData -> Update the existing User Record");
        UserModel model = springDataRestRepository.findById(userId)
        		.orElseThrow(() -> new SpringDataRestException("User Record not found", userId));
        if (null != model) {
        	return springDataRestRepository.save(userModel);
		}
        return model;
    }

	@GetMapping("/getUser/{id}")
    public UserModel getUserDataById(@PathVariable(value = "id") String userId) {
    	UserModel userModel = springDataRestRepository.findById(userId)
    			.orElseThrow(() -> new SpringDataRestException("User Record not found", userId));
    	LOGGER.info("getUserDataById -> Fetch the User Detail by userId as : {}", userId);
        return userModel;
    }
	
	@GetMapping("/getUserByFirstName/{firstName}")
    public UserModel getUserDataByFirstName(@PathVariable(value = "firstName") String firstName) {
    	UserModel userModel = springDataRestRepository.findByFirstName(firstName);
    	LOGGER.info("getUserDataByFirstName -> Fetch the User Detail by First Name as : {}", firstName);
        return userModel;
    }
	
	@GetMapping("/getUserByLastName/{lastName}")
    public UserModel getUserDataByLastName(@PathVariable(value = "lastName") String lastName) {
    	UserModel userModel = springDataRestRepository.findByLastName(lastName);
    	LOGGER.info("getUserDataByLastName -> Fetch the User Detail by Last Name as : {}", lastName);
        return userModel;
    }
	
	@GetMapping("/getUserByMobileNo/{mobileNo}")
    public UserModel getUserDataByMobileNo(@PathVariable(value = "mobileNo") String mobileNo) {
    	UserModel userModel = springDataRestRepository.findByMobileNo(mobileNo);
    	LOGGER.info("getUserDataByMobileNo -> Fetch the User Detail by Mobile No as : {}", mobileNo);
        return userModel;
    }
	
	@GetMapping("/getUserByEmail/{email}")
    public UserModel getUserDataByEmail(@PathVariable(value = "email") String email) {
    	UserModel userModel = springDataRestRepository.findByEmail(email);
    	LOGGER.info("getUserDataByEmail -> Fetch the User Detail by Email as : {}", email);
        return userModel;
    }
	
	@GetMapping("/getUserByPan/{panNo}")
    public UserModel getUserDataByPan(@PathVariable(value = "panNo") String panNo) {
    	UserModel userModel = springDataRestRepository.findByPanNo(panNo);
    	LOGGER.info("getUserDataByPan -> Fetch the User Detail by PAN No as : {}", panNo);
        return userModel;
    }
	
	@DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") String userId) {
		UserModel userModel = springDataRestRepository.findById(userId)
				.orElseThrow(() -> new SpringDataRestException("User not found", userId));
	    springDataRestRepository.delete(userModel);
    	LOGGER.info("deleteUser -> Delete the User of userId : {}", userId);
    }
	
}
