package org.wucalv.quickstart.fullrecon.model;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public enum TransactionType {

    BUY(new TransactionEffect.BuyEffect()),
    SELL(new TransactionEffect.SellEffect()),
    DVDR("Dividend Reinvest", new TransactionEffect.DividendReinvestEffect()),
    DVD("Dividend", new TransactionEffect.StockDividendEffect()),
    TRFIN("Transfer In", new TransactionEffect.DepositEffect()),
    DEPOSIT(new TransactionEffect.DepositEffect()),
    WITHDRAW(new TransactionEffect.WithdrawEffect()),
    FEES(new TransactionEffect.WithdrawEffect()),
    TRANSACTION
    ;
    private String text;

    private TransactionEffect transactionEffect;

    TransactionType() {
    }

    TransactionType(TransactionEffect transactionEffect) {
        this.transactionEffect = transactionEffect;
    }

    TransactionType(String text, TransactionEffect transactionEffect) {
        this.text = text;
        this.transactionEffect = transactionEffect;
    }

    public String getText() {
        return text;
    }

    public TransactionEffect getTransactionEffect() {
        return transactionEffect;
    }

    public static TransactionType eval(String value) {
        for(TransactionType type : values()) {
            if(type.name().equalsIgnoreCase(value) ||
                    (type.text!=null && type.text.equalsIgnoreCase(value))) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid transaction type: " + value);
    }
}
