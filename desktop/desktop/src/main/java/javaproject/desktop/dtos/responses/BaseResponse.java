package javaproject.desktop.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseResponse<T> {
    private  Integer status;
    private  String message;
    private  Integer returnCode;
    private  Integer count; // consist of null value
    private  T data;

    public BaseResponse(Integer status, String message, Integer returnCode, Integer count, T data) {
        this.status = status;
        this.message = message;
        this.returnCode = returnCode;
        this.count = count;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public Integer getCount() {
        return count;
    }

    public T getData() {
        return data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setData(T data) {
        this.data = data;
    }
}