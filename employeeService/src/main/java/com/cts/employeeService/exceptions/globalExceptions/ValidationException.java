package com.cts.employeeService.exceptions.globalExceptions;

import java.io.Serializable;

public class ValidationException extends Exception implements Serializable {

    private static final long serialVersionUID = -7688565341573511726L;

    public ValidationException(String errorMessage){
        super(errorMessage);
    }
}
