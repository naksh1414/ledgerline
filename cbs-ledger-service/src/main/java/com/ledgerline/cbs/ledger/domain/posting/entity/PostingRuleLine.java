package com.ledgerline.cbs.ledger.domain.posting.entity;

import com.ledgerline.cbs.ledger.domain.base.EntryDirection;
import com.ledgerline.cbs.ledger.domain.mapping.entity.AccountingPurpose;
import lombok.Data;

import java.util.UUID;

@Data
public class PostingRuleLine {

    private final UUID id;
    private final AccountingPurpose accountingPurpose;
    private final EntryDirection direction;
    private final AmountComponent amountComponent;
}
