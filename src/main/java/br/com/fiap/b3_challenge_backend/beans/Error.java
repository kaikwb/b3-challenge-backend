package br.com.fiap.b3_challenge_backend.beans;

public class Error {
    private String error;
    private Integer code;
    private String message;

    public Error(ErrorCode errorCode, String message) {
        this.error = errorCode.toString();
        this.code = errorCode.getCode();
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
