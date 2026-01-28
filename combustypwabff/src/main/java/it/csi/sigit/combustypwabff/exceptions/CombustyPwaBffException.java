package it.csi.sigit.combustypwabff.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CombustyPwaBffException extends Exception {

    private Integer status;

    public CombustyPwaBffException() {

    }

    public CombustyPwaBffException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public CombustyPwaBffException(Integer status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public CombustyPwaBffException(Throwable cause) {
        super(cause);
    }

    public CombustyPwaBffException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
