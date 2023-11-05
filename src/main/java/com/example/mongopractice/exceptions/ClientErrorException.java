package com.example.mongopractice.exceptions;

import java.time.Instant;

public abstract class ClientErrorException extends RuntimeException {
        protected Instant date = Instant.now();
        protected String error;
        public ClientErrorException withDate(Instant date) {
        this.date = date;
        return this;
    }
        public ClientErrorException withError(String error) {
        this.error = error;
        return this;
    }
        public Instant getDate() {
        return date;
    }
        public String getError() {
        return error;
    }
    protected ClientErrorException(Throwable cause) {
        super(cause);
    }
    protected ClientErrorException(String message,
                                   Object...args) {
        super(String.format(message, args));
    }
    protected ClientErrorException(Throwable cause, String
            message, Object...args) {
        super(String.format(message, args), cause);
    }

    public static class BadRequestException extends
            ClientErrorException {
        public BadRequestException(String message,
                                   Object...args) { super(message, args); }
        public BadRequestException(Throwable cause, String
                message, Object...args) { super(cause, message, args); }
    }
    public static class NotFoundException extends
            ClientErrorException {
        public NotFoundException(String message, Object...args)
        { super(message, args); }
        public NotFoundException(Throwable cause, String
                message, Object...args) { super(cause, message, args); }
    }
    public static class InvalidInputException extends
            ClientErrorException {
        public InvalidInputException(String message,
                                     Object...args) { super(message, args); }
        public InvalidInputException(Throwable cause, String
                message, Object...args) { super(cause, message, args); }
    }
    public static class NotAuthorizedException extends
            ClientErrorException {
        public NotAuthorizedException(String message,
                                      Object...args) { super(message, args); }
        public NotAuthorizedException(Throwable cause, String
                message, Object...args) { super(cause, message, args); }
    }
}

