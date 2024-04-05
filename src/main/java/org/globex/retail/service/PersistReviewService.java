package org.globex.retail.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.globex.retail.model.dto.ProductReviewDto;
import org.globex.retail.model.dto.ProductReviewMapper;
import org.jboss.logging.Logger;

import io.smallrye.common.annotation.Blocking;

@ApplicationScoped
public class PersistReviewService {
    
    private static final Logger LOGGER = Logger.getLogger(PersistReviewService.class);
    
    @Transactional
    @Blocking
    public void persisReview(ProductReviewDto productReviewDto) {
        //System.out.println("persisReview called with >>" + productReviewEntity.reviewText + "<<");
        if(productReviewDto.getScore() <0) {
            ProductReviewMapper.toEntity(productReviewDto).persist();
        } else {
            LOGGER.info("User '" + productReviewDto.getUser().getName() + "' submitted an abusive review which will not be persisted. The review text is '" 
                            + productReviewDto.getReviewText() + "'");   
            productReviewDto.setReviewText("We're sorry but your review did not conform to our content policies and has been removed. Please contact support team for any queries. ~ Team Globex");
            ProductReviewMapper.toEntity(productReviewDto).persist();           
            
        }

    }

}
