package com.system.reviewSystem.service;

import com.system.reviewSystem.entity.Comment;
import com.system.reviewSystem.entity.Product;
import com.system.reviewSystem.repository.CommentRepository;
import com.system.reviewSystem.repository.ProductRepository;
import com.system.reviewSystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private VoteRepository voteRepository;


    //update visible product
    public void updateIsVisibleProduct(String isVisible, String productName) {
        productRepository.updateProductVisibility(isVisible, productName);
    }

    //update visible comment
    public void updateIsVisibleComment(String isVisible, String productName) {
        productRepository.updateCommentVisibility(isVisible, productName);
    }

    //update visible  rating
    public void updateIsVisibleRating(String isVisible, String productName) {
        productRepository.updateRatingVisibility(isVisible, productName);
    }

    //update visible comment and rating for product  public or not
    public void updateIsPublicComments(String isVisible, String productName) {
        productRepository.updateIspublic(isVisible, productName);
    }

    // return details for each product
    public List<Product> findAllProducts() {
        return (List<Product>) productRepository.findAll();
    }


    //see comments  and voting that not accept and update them
    public List<Comment> findNotAcceptedComments() {
        return (List<Comment>) commentRepository.findByIsAccepted("0");
    }


    //update comments and votes that are not accept
    public void updateIsAccepted(String isVisible, String productName) {
        commentRepository.updateIsAccepted(isVisible, productName);
    }

    public List<Comment> find3LastComments(String productName) {

        return (List<Comment>) commentRepository.findLast3ByProduct_ProductName(productName);

    }

    public List<String> getCountComments() {
        //count of accepted comments
        return commentRepository.countTotalComments();

    }

    public float getAvarageVotes() {

       if(!(voteRepository.countTotalIsAccepted() ==0)) {
           return voteRepository.averageOfVotes();
       }else
           return 0;
    }


    public Product createProducts(Product Product) {
        return productRepository.save(Product);
    }
}
