package com.example.week5relations.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsDTO {

    private Integer customer_id;
    private Integer age;
    private String email;
}
