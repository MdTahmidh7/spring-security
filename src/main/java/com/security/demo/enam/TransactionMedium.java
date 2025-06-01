package com.security.demo.enam;

import lombok.Getter;

@Getter
public enum TransactionMedium {
    CASH(1),
    BKASH(2),
    BANK(3);

    private final int id;

    TransactionMedium(int id) {
        this.id = id;
    }

    public static TransactionMedium fromId(int id) {
        for (TransactionMedium tm : values()) {
            if (tm.getId() == id) return tm;
        }
        throw new IllegalArgumentException("Unknown TransactionMedium id: " + id);
    }
}
