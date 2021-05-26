package com.travelagency.tirana.controller;


import com.travelagency.tirana.model.User;
import com.travelagency.tirana.service.Impl.UserImpl.SaveUserRequest;
import com.travelagency.tirana.service.Impl.UserImpl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/login")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public long save(@RequestBody SaveUserRequest request) {
        return userService.save(request);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@RequestBody User user) {
        var result =  userService.getById(user.getId());
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }
}
