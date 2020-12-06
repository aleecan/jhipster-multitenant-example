package com.mikado.multitenant.service.base;


public class ServiceResult<T> extends ServiceResultBase{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ServiceResult() {
    }

    public ServiceResult(T data) {
        this.data = data;
    }
}
