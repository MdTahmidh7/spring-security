package com.security.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ItemDTO {

    private String name;

    private Double price;

    private LocalDate createdDate;

    private String image;
}
