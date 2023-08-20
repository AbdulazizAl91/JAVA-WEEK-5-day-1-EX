package com.example.week5relation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsDTO {

    private Integer customer_id;
    private String gander ;
    private Integer age;
    private String email;
}
