package com.system.reviewSystem.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private long id;
    private String productName;
    private String activeRating;
    private String activeComment;
    private String provider;
    private String visible;
    private String isPublic;
    @OneToMany
    private List<Comment> comments;


    @OneToMany
    private List<Vote> votes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getActiveRating() {
        return activeRating;
    }

    public void setActiveRating(String activeRating) {
        this.activeRating = activeRating;
    }

    public String getActiveComment() {
        return activeComment;
    }

    public void setActiveComment(String activeComment) {
        this.activeComment = activeComment;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
