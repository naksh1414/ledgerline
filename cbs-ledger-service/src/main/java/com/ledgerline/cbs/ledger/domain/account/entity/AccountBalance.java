package com.ledgerline.cbs.ledger.domain.account.entity;

import com.ledgerline.cbs.ledger.domain.base.Currency;
import com.ledgerline.cbs.ledger.domain.base.Money;
import lombok.Data;

import java.util.UUID;

@Data
public final class AccountBalance {

    private final UUID id;
    private final UUID accountId;
    private final Currency currency;
    private Money ledgerBalance;
    private Money heldAmount;
    private Money overdraftLimit;
}
