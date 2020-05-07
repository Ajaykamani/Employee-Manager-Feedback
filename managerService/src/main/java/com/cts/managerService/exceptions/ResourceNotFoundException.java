package com.cts.managerService.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException  implements Serializable {

	private static final long serialVersionUID = -606291156275440267L;

	public ResourceNotFoundException(String errorMessage) {
		 super(errorMessage);
    }
}
