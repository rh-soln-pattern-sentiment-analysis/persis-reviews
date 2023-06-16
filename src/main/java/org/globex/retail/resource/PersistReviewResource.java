package org.globex.retail.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.globex.retail.model.dto.ProductReviewDto;
import org.globex.retail.model.entity.ProductReviewEntity;
import org.globex.retail.service.PersistReviewService;
import org.jboss.logging.Logger;

import javax.inject.Inject;


@Path("/review")
public class PersistReviewResource {

    @Inject
    PersistReviewService productReviewService;
    
    private static final Logger LOGGER = Logger.getLogger(PersistReviewResource.class);
    
    @POST
    @Path("/submit")
    @Consumes(MediaType.APPLICATION_JSON)    
    public void  persistReview(ProductReviewDto  productReview) { 
        
        LOGGER.debug("productReview.reviewText" + productReview.getReviewText());
        productReviewService.persisReview(productReview);
        
    }

    /* public CompletionStage<Void>  consume(Message<ProductReviewDto> productReview) throws JsonMappingException, JsonProcessingException { 
        
        IncomingCloudEventMetadata<Integer> cloudEventMetadata = productReview.getMetadata(IncomingKafkaCloudEventMetadata.class)
    .orElseThrow(() -> new IllegalArgumentException("Expected a Cloud Event"));

    LOGGER.info("Received Cloud Events  of type: " + cloudEventMetadata.getType());    

    System.out.println(productReview.getPayload().getReviewText());
    //ProductReviewDto review = 
    
    return productReview.ack();

    } */
}
    
    
   