package com.ledgerline.cbs.ledger.domain.account.persistence;

@FunctionalInterface
public interface AccountNumberSequence {

    long next ();
}
