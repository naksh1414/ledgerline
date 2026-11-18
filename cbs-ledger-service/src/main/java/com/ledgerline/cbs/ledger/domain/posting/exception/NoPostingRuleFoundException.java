package com.ledgerline.cbs.ledger.domain.posting.exception;

import com.ledgerline.cbs.ledger.domain.coa.entity.AccountingContext;

public class NoPostingRuleFoundException extends RuntimeException {

    public NoPostingRuleFoundException (AccountingContext context) {
        super("No posting rule found for %s".formatted(context));
    }
}
