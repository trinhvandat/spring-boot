package org.aibles.spring.criteriaquery.dto;

public class GenericResponse {
    private int status;
    private String result;
    private Object data;

    public GenericResponse() {
    }

    public GenericResponse(int status, String result, Object data) {
        this.status = status;
        this.result = result;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
