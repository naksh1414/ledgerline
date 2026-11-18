package com.ledgerline.cbs.ledger.domain.journal.persistence;

import com.ledgerline.cbs.ledger.domain.journal.entity.JournalEntryLine;

import java.util.List;
import java.util.UUID;

public interface JournalEntryLineStorage {

    List<JournalEntryLine> findByJournalEntryId (UUID journalEntryId);

    void saveAll (List<JournalEntryLine> lines);
}
