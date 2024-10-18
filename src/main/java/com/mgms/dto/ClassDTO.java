package com.mgms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDTO {
  private Long id;

  @NotBlank(message = "Class name is required")
  private String name;

  @Positive(message = "Capacity must be a positive number")
  private Integer capacity;
}
