package org.sid.jee_exam_backend.exceptions;

public class RemboursementNotFoundException extends RuntimeException {
    public RemboursementNotFoundException(String message) {
        super(message);
    }
}
