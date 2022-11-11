package com.tikifake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tikifake.model.request.creator.UserCreatorRequest;
import com.tikifake.model.request.update.UserUpdateRequest;
import com.tikifake.model.response.creator.UserCreatorResponse;
import com.tikifake.model.response.detail.IUserDetail;
import com.tikifake.model.response.list.IUserList;
import com.tikifake.model.response.update.UserUpdateResponse;
import com.tikifake.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserById(@PathVariable(value = "id") Long userId) {
		IUserDetail user = userService.getDetailById(userId);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Not Found");
		}
		return ResponseEntity.ok().body(user);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllUser() {
		List<IUserList> users = userService.getAllUser();
		return ResponseEntity.ok().body(users);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addUser(@RequestBody UserCreatorRequest userCreator) {
		UserCreatorResponse userResponse = userService.save(userCreator);
		return ResponseEntity.ok().body(userResponse);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody UserUpdateRequest userUpdate) {
		UserUpdateResponse userResponse = userService.update(userUpdate);
		return ResponseEntity.ok().body(userResponse);
	}
}
