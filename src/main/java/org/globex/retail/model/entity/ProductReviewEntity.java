package org.globex.retail.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ProductReview")
@Table(name = "product_reviews")
@Cacheable

@SequenceGenerator(name="ReviewIdSeq", sequenceName="product_reviews_id_seq", allocationSize = 1)
public class ProductReviewEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="ReviewIdSeq")
    @Column(name = "review_id")
    public long reviewId;

    @Column(name = "product_id")
    public String productId;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "rating")
    public Integer rating;

    @Column(name = "review_date")
    public LocalDateTime reviewDate;

    @Column(name = "review_text")
    public String reviewText;

    
}