package com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Category {

    private Integer id;
    private String name;
    private CategoryReference parentCategory;
    private List<CategoryReference> subCategories;
}
