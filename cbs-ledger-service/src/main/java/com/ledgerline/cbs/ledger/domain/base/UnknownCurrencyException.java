package com.ledgerline.cbs.ledger.domain.base;

public class UnknownCurrencyException extends RuntimeException {

    public UnknownCurrencyException (String code) {
        super("Unknown currency code: " + code);
    }
}
