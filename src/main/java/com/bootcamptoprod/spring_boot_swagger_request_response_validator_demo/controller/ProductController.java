package com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.controller;

import com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.model.ProductRequest;
import com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.model.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Create a new product
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        // For demo purposes, simulate product creation.
        ProductResponse response = new ProductResponse();
        response.setId(UUID.randomUUID().toString());
        response.setName(productRequest.getName());
        response.setPrice(productRequest.getPrice());
        response.setDescription(productRequest.getDescription());
        response.setCategory(productRequest.getCategory());
        response.setTags(productRequest.getTags());
        response.setAttributes(productRequest.getAttributes());
        response.setCreatedAt(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Retrieve a product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String productId) {

        // Simulate an error scenario wherein many fields are missing in api response
        ProductResponse response = new ProductResponse();
        response.setId(productId);
        response.setName("Demo Product");
        response.setDescription("This is a demo product.");
        response.setCreatedAt(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
