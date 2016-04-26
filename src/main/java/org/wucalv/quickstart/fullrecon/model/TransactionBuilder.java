package org.wucalv.quickstart.fullrecon.model;

import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;

import static org.wucalv.quickstart.fullrecon.model.PositionBuilder.DATE_FORMATTER;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class TransactionBuilder {

    private Transaction transaction;

    private TransactionBuilder() {
        this.transaction = new Transaction();
    }

    public static TransactionBuilder newBuilder() {
        return new TransactionBuilder();
    }

    public TransactionBuilder withSymbol(String symbol) {
        transaction.setSymbol(symbol);
        return this;
    }

    public TransactionBuilder withTransactionType(String type) {
        transaction.setTransactionType(TransactionType.eval(type));
        return this;
    }

    public TransactionBuilder withCurrencyCode(String code) {
        transaction.setCurrencyCode(CurrencyCode.USD);
        return this;
    }

    public TransactionBuilder withUnits(String units) {
        transaction.setUnits(NumberUtils.toDouble(units, 0));
        return this;
    }

    public TransactionBuilder withTradeDate(String date) {
        transaction.setTradeDate(LocalDate.parse(date, DATE_FORMATTER));
        return this;
    }

    public TransactionBuilder withPostedDate(String date) {
        transaction.setPostedDate(LocalDate.parse(date, DATE_FORMATTER));
        return this;
    }

    public TransactionBuilder withAmount(String value) {
        transaction.setAmount(NumberUtils.toDouble(value));
        return this;
    }

    public Transaction build() {
        return transaction;
    }
}
