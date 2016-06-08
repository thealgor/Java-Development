package com.search.externalcalls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.searchMart.entities.ProductRecommendations;

public class ProductRecommendationAPI {
	
	private String productId;	
	
	public ProductRecommendationAPI(String queryId){
		productId = queryId;
	}
	
	/**
	 * Makes the API call and stores result in POJO
	 * It should also gracefully handle any errors
	 * @return
	 */
	public List<ProductRecommendations> recommendationAPICall(){
		if(productId==null||productId.isEmpty() || productId.trim().isEmpty()){
			throw new NullPointerException("Query string cannot be empty");
		}
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductRecommendations>> responseEntity  = restTemplate.exchange(WalmartAPIDetails.recommendationUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductRecommendations>>() {
        },WalmartAPIDetails.APIKey,productId);
		List<ProductRecommendations> products = responseEntity.getBody();
		return products;
	}
}