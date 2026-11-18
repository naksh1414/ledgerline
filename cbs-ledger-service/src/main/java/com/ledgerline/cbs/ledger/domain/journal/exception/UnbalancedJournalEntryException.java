package com.ledgerline.cbs.ledger.domain.journal.exception;

public class UnbalancedJournalEntryException extends RuntimeException {

    public UnbalancedJournalEntryException (String message) {
        super(message);
    }
}
