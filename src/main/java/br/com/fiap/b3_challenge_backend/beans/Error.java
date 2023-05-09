package br.com.fiap.b3_challenge_backend.beans;

public class Error {
    private String error;
    private Integer code;
    private String message;

    /**
     * Cria um objeto de erro.
     *
     * @param errorCode código do erro.
     * @param message   mensagem do erro.
     */
    public Error(ErrorCode errorCode, String message) {
        this.error = errorCode.toString();
        this.code = errorCode.getCode();
        this.message = message;
    }

    /**
     * Retorna o código do erro.
     *
     * @return o erro.
     */
    public String getError() {
        return error;
    }

    /**
     * Define o código do erro.
     *
     * @param error código do erro.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Retorna o código do erro.
     *
     * @return código do erro.
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Define o código do erro.
     *
     * @param code código do erro.
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Retorna a mensagem do erro.
     *
     * @return mensagem do erro.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define a mensagem do erro.
     *
     * @param message mensagem do erro.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
