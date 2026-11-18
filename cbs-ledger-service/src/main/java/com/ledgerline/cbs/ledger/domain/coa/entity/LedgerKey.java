package com.ledgerline.cbs.ledger.domain.coa.entity;

import com.ledgerline.cbs.ledger.domain.base.Currency;
import lombok.Value;

@Value
public class LedgerKey {

    GeneralLedgerAccountCode code;
    Currency currency;
}
