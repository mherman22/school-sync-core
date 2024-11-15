/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.exception;

@SuppressWarnings("unused")
public class ResourceActionNotYetImplemented extends RuntimeException {

  public ResourceActionNotYetImplemented() {
    super("This resource action is not yet implemented.");
  }

  public ResourceActionNotYetImplemented(String message) {
    super(message);
  }

  public ResourceActionNotYetImplemented(String message, Throwable cause) {
    super(message, cause);
  }

  public ResourceActionNotYetImplemented(Throwable cause) {
    super(cause);
  }
}
