package com.ledgerline.cbs.ledger.domain.coa.entity;

import com.ledgerline.cbs.ledger.domain.base.Currency;
import com.ledgerline.cbs.ledger.domain.transaction.entity.TransactionType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountingContext {

    TransactionType transactionType;
    Currency currency;
    CustomerSegment customerSegment;
    Channel channel;
}
