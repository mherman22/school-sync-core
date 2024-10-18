/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
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
