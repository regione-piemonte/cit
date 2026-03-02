package it.csi.sigit.citpdnd.exception;

public class CitpdndException extends Exception {

    private String code;

    public CitpdndException() {
    }

    public CitpdndException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CitpdndException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CitpdndException(Throwable cause) {
        super(cause);
    }

    public CitpdndException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
