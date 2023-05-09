package br.com.fiap.b3_challenge_backend.beans;

import java.util.Objects;

public enum ErrorCode {
    UNKNOWN_ERROR_DATABASE(-2),
    UNKNOWN_ERROR(-1),
    NO_ERROR(0),
    INVALID_VALUE(1),
    NOT_FOUND(2);

    private final Integer code;

    /**
     * Cria um código de erro.
     *
     * @param code código do erro.
     */
    ErrorCode(Integer code) {
        this.code = code;
    }

    /**
     * Retorna o código do erro.
     *
     * @return código do erro.
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * Retorna o código do erro.
     *
     * @param code código do erro.
     * @return código do erro.
     */
    public static ErrorCode fromInteger(Integer code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (Objects.equals(errorCode.getCode(), code)) {
                return errorCode;
            }
        }

        return UNKNOWN_ERROR;
    }
}
