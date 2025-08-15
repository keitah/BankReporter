package me.keita.reporter.model;

import java.math.BigDecimal;

public class Transaction {
    private String account;
    private String description;
    private BigDecimal amount;

    public Transaction() { }

    public Transaction(String account, String description, BigDecimal amount) {
        this.account = account;
        this.description = description;
        this.amount = amount;
    }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "Transaction{" +
                "account='" + account + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}