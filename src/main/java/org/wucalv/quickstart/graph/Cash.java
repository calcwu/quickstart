package org.wucalv.quickstart.graph;

/**
 * Created by calvin.wu on 2/29/16.
 */
public class Cash extends Security {

    private String currency;
    private Double value;

    public Cash(String currency, Double value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
