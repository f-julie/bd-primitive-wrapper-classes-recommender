package com.amazon.ata.debugging.subscribeandsave.service;

/**
 * Thrown if an unrecognized ASIN is provided.
 */
public class UnrecognizedAsinException extends IllegalArgumentException {
    /**
     * Constructs exception with provided error message.
     * @param message error message
     */
    public UnrecognizedAsinException(String message) {
        super(message);
    }

    /**
     * Constructs exception with provided error message, cause.
     * @param message error message
     * @param cause original exception
     */
    public UnrecognizedAsinException(String message, Throwable cause) {
        super(message, cause);
    }
}
