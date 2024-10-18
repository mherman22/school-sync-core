/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private Long id;
  private String username;
  private String password;
  private String email;
  private String role;
}
