package com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {

    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private Category category;
    private List<String> tags;
    private Map<String, String> attributes;
    private LocalDateTime createdAt;
}
