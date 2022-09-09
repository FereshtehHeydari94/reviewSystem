package com.system.reviewSystem.repository;

import com.system.reviewSystem.entity.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {


    Comment findByIsAccepted(String isAccepted);

    @Modifying
    @Query("update  Comment c set c.isAccepted ='1' WHERE c.user.username = :username and c.product.productName= :productName")
    void updateIsAccepted(@Param("username") String username, @Param("productName") String productName);

    List<Comment> findLast3ByProduct_ProductName(String username);


    @Query("SELECT c.product.productName, COUNT(c)FROM Comment AS c GROUP BY c.product.productName")
    List<String> countTotalComments();
}
