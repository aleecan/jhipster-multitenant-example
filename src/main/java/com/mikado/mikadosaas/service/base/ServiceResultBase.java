package com.mikado.mikadosaas.service.base;


public class ServiceResultBase {
    private Boolean success;
    private String message;

    public ServiceResultBase() {
        this.setSuccess(true);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
