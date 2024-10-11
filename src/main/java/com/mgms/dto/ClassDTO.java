package com.mgms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class ClassDTO {
    private Long id;

    @NotBlank(message = "Class name is required")
    private String name;

    @Positive(message = "Capacity must be a positive number")
    private Integer capacity;
}
