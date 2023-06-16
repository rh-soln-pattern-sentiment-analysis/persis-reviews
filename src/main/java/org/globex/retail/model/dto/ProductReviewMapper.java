package org.globex.retail.model.dto;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

import org.globex.retail.model.entity.ProductReviewEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;
public class ProductReviewMapper extends PanacheEntityBase {

    public static ProductReviewEntity toEntity(ProductReviewDto reviewDto) {
        if (reviewDto == null) {
            return null;
        }
        ProductReviewEntity review = new ProductReviewEntity();
        review.productId = reviewDto.getProduct().getProduct_id();
        review.userId = reviewDto.getUser().getCustomer_id();
        review.userName = reviewDto.getUser().getName();
        review.rating = reviewDto.getRating();
        review.reviewDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(reviewDto.getTimestamp()), TimeZone.getDefault().toZoneId());  
        review.reviewText = reviewDto.getReviewText();    
        return review;
    }   
}