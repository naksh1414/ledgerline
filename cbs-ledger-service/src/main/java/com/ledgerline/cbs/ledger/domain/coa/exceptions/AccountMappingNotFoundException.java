package com.ledgerline.cbs.ledger.domain.coa.exceptions;

import com.ledgerline.cbs.ledger.domain.coa.entity.AccountingContext;

public class AccountMappingNotFoundException extends RuntimeException {

    public AccountMappingNotFoundException (AccountingContext context) {
        super("General ledger mapping not found for: %s".formatted(context));
    }
}
