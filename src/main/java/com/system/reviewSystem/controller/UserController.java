package com.system.reviewSystem.controller;

import com.system.reviewSystem.entity.Comment;
import com.system.reviewSystem.entity.User;
import com.system.reviewSystem.entity.Vote;
import com.system.reviewSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }


    @RequestMapping(value = "/insertComment", method = RequestMethod.POST)
        public Comment insertComment(@RequestBody Comment comment) {
        return userService.insertComment(comment);
    }

    @RequestMapping(value = "/voting", method = RequestMethod.POST)
    public Vote voting(@RequestBody Vote vote) {
        return userService.voting(vote);
    }


}
