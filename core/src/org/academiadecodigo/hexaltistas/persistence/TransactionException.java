package org.academiadecodigo.hexaltistas.persistence;

public class TransactionException extends RuntimeException {

    /**
     * @see RuntimeException#RuntimeException(Throwable)
     */
    public TransactionException(Throwable cause) {
        super(cause);
    }
}