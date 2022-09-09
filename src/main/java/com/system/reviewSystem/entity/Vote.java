package com.system.reviewSystem.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_VOTE")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VOTE_ID")
    private long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "USER_ID")
    private User user;
    private Date votedDate;
    private String isAccepted;
    private float vote;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getVotedDate() {
        return votedDate;
    }

    public void setVotedDate(Date votedDate) {
        this.votedDate = votedDate;
    }

    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }
}
