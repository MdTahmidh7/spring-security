package com.security.demo.enam;

public enum TransactionType {
    DEPOSIT(1),
    WITHDRAW(2);

    private final int id;

    TransactionType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TransactionType fromId(int id) {
        for (TransactionType tt : values()) {
            if (tt.getId() == id) return tt;
        }
        throw new IllegalArgumentException("Unknown TransactionType id: " + id);
    }
}
