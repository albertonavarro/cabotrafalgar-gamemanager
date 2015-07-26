package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    public static enum Status { OK, PARTIAL_OK, ERROR }

    private Status status;

    private String errorCode;

    private String errorDescription;

    public GenericResponse() {
        this.status = Status.OK;
        this.errorCode = null;
        this.errorDescription = null;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public static GenericResponse fromError(String errorCode, String errorDescription) {
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setErrorCode(errorCode);
        genericResponse.setErrorDescription(errorDescription);
        genericResponse.setStatus(Status.ERROR);
        return genericResponse;
    }
}
