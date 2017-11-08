package Utils;

class SetUpException extends RuntimeException {
    SetUpException(String message, Throwable cause) {
        super(message, cause);
    }

    SetUpException(String message) {
        super(message);
    }
}
