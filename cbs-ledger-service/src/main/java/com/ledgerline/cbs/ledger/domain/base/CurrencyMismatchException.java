package com.ledgerline.cbs.ledger.domain.base;

public class CurrencyMismatchException extends RuntimeException {

    public CurrencyMismatchException (String message) {
        super(message);
    }
}
