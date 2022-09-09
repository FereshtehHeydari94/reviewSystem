package com.system.reviewSystem.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_COMMENTS")
public class Comment {
    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;

    private Date createDate;
    private String isAccepted;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "USER_ID")
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted;
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
}
