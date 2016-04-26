package org.wucalv.quickstart.fullrecon.model;

import java.time.LocalDate;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class Transaction implements Computable {

    private TransactionType transactionType;
    private String symbol;
    private CurrencyCode currencyCode;
    private double units;
    private LocalDate tradeDate;
    private LocalDate postedDate;
    private double amount;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getSymbol() {
        return symbol;
    }

    void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public TransactionEffect getTransactionEffect() {
        return transactionType.getTransactionEffect();
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType=" + transactionType +
                ", symbol='" + symbol + '\'' +
                ", units=" + units +
                ", amount=" + amount +
                '}';
    }

    @Override
    public double getValue() {
        return getAmount();
    }
}
