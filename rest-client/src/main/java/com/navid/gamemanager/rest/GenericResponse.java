package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    public static enum Status { OK, PARTIAL_OK, ERROR }

    private final Status status;

    private final String errorCode;

    private final String errorDescription;

    public GenericResponse() {
        this.status = Status.OK;
        this.errorCode = null;
        this.errorDescription = null;
    }

    public GenericResponse(String errorCode, String errorDescription) {
        this.status = Status.ERROR;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public Status getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
