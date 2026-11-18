package com.ledgerline.cbs.ledger.domain.posting.exception;

import com.ledgerline.cbs.ledger.domain.posting.entity.AmountComponent;

public class MissingAmountComponentException extends RuntimeException {

    public MissingAmountComponentException (AmountComponent component) {
        super("Missing amount component for: %s".formatted(component));
    }
}
