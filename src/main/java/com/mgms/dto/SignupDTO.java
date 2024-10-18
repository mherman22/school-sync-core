/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDTO {
  @NotBlank(message = "Username is required")
  private String username;

  @NotBlank(message = "Password is required")
  private String password;

  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  private String email;

  @NotBlank(message = "Role is required")
  private String role;
}
