  
package com.example.mysqldemo.Controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysqldemo.entity.User;
import com.example.mysqldemo.service.IUserService;




@RestController
public class UserController {
	@Autowired
	private IUserService userService;
	@PostMapping("/user")
	int createUser(@RequestBody User user){
		return userService.save(user);
	}
	@GetMapping("/user")
	List<User> getUsers() {
		return userService.getUsers();
	}
	@GetMapping("/user/{id}")
	Optional<User> getUser(@PathVariable("id")Integer userId) {
		return userService.getUser(userId);
	}
	@PutMapping("/user/{id}")
		void updateUser(@RequestBody User user,@PathVariable("id")Integer userId)
		{
		
		user.setId(userId);
		userService.updateUser(user);
		}
	
	@DeleteMapping("/user/{id}")
	void deleteOrder(@PathVariable("id") Integer userId) {
		System.out.println(userId);
		userService.deleteOrder(userId);
	}
		
		
	}
	
