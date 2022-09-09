package com.system.reviewSystem.controller;

import com.system.reviewSystem.entity.Comment;
import com.system.reviewSystem.entity.Product;
import com.system.reviewSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value ="/updateIsVisibleProduct/{productName}/{isvisible}",method = RequestMethod.PUT)
    public void updateIsVisibleProduct(@PathVariable String productName,@RequestParam String isvisible) {
        adminService.updateIsVisibleProduct(isvisible,productName);
    }

    @RequestMapping(value ="/updateIsVisibleComment/{productName}/{isvisible}",method = RequestMethod.PUT)
    public void updateIsVisibleComment(@PathVariable String productName,@RequestParam String isvisible) {
        adminService.updateIsVisibleComment(isvisible,productName);
    }

    @RequestMapping(value ="/updateIsVisibleRating/{productName}/{isvisible}",method = RequestMethod.PUT)
    public void updateIsVisibleRating(@PathVariable String productName,@RequestParam String isvisible) {
        adminService.updateIsVisibleRating(isvisible,productName);
    }

    @RequestMapping(value ="/updateIsPublicComments/{productName}/{isvisible}",method = RequestMethod.PUT)
    public void updateIsPublicComments(@PathVariable String productName,@RequestParam String isvisible) {
        adminService.updateIsPublicComments(isvisible,productName);
    }


    @RequestMapping(value = "/showAllProducts", method = RequestMethod.GET)
    public Iterable<Product> showAllProducts() {
        return adminService.findAllProducts();
    }


    @RequestMapping(value ="/updateIsAccepted/{productName}/{isvisible}",method = RequestMethod.PUT)
    public void updateIsAccepted(@PathVariable String productName,@RequestParam String isvisible) {
        adminService.updateIsAccepted(isvisible,productName);
    }


    @RequestMapping(value = "/show3LastComments/{productName}", method = RequestMethod.GET)
    public List<Comment> show3LastComments(@PathVariable String productName) {
        return adminService.find3LastComments(productName);
    }

    @RequestMapping(value = "/getCountComments", method = RequestMethod.GET)
    public Iterable<String> getCountComments() {
        return adminService.getCountComments();
    }

    @RequestMapping(value = "/getAvarageVotes", method = RequestMethod.GET)
    public float getAvarageVotes() {
        return adminService.getAvarageVotes();
    }


    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public Product createProducts(@RequestBody Product product) {
        return adminService.createProducts(product);
    }

    @RequestMapping(value = "/findNotAcceptedComments", method = RequestMethod.GET)
    public List<Comment> findNotAcceptedComments() {
        return adminService.findNotAcceptedComments();
    }


}
