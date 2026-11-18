package com.ledgerline.cbs.core.domain.util;

@FunctionalInterface
public interface DomainId<T> {

    T getValue ();
}
