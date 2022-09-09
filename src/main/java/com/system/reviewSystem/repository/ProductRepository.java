package com.system.reviewSystem.repository;

import com.system.reviewSystem.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Modifying
    @Query("update Product p set p.visible = :isvisible WHERE p.productName = :productName")
    void updateProductVisibility(@Param("isvisible") String isvisible, @Param("productName") String productName);

    @Modifying
    @Query("update Product p set p.activeComment = :isvisible WHERE p.productName = :productName")
    void updateCommentVisibility(@Param("isvisible") String isvisible, @Param("productName") String productName);

    @Modifying
    @Query("update Product p set p.activeRating = :isvisible WHERE p.productName = :productName")
    void updateRatingVisibility(@Param("isvisible") String isvisible, @Param("productName") String productName);

    @Modifying
    @Query("update Product p set p.isPublic = :isvisible WHERE p.productName = :productName")
    void updateIspublic(@Param("isvisible") String isvisible, @Param("productName") String productName);


}
