package com.system.reviewSystem.service;

import com.system.reviewSystem.entity.Comment;
import com.system.reviewSystem.entity.User;
import com.system.reviewSystem.entity.Vote;
import com.system.reviewSystem.repository.CommentRepository;
import com.system.reviewSystem.repository.UserRepository;
import com.system.reviewSystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private VoteRepository voteRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Comment insertComment(Comment coment) {
        return commentRepository.save(coment);
    }

    public Vote voting(Vote vote) {
        return  voteRepository.save(vote);
    }

}
