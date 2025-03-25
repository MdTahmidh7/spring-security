package com.security.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class ItemDTO {

    private Long id;

    private String name;

    private Double price;

    private LocalDateTime createdDateTime;

    private LocalDateTime endDateTime;

    private String image;

    private String description;

    private Boolean isDeleted;

}
