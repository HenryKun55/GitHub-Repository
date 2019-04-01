package com.greytoolco.githubrepos.model.response;

public class ApiResponse {

    private String success;
    private String failure;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }
}
