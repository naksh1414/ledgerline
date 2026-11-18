package com.ledgerline.cbs.ledger.domain.coa.entity;

import com.ledgerline.cbs.ledger.domain.base.Currency;
import com.ledgerline.cbs.ledger.domain.transaction.entity.TransactionType;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralLedgerMapping {

    private UUID id;
    private TransactionType transactionType;
    private Currency currency;
    private CustomerSegment customerSegment;
    private UUID debitGeneralLedgerAccount;
    private UUID creditGeneralLedgerAccount;
}
