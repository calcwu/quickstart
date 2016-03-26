package org.wucalv.quickstart.graph;

/**
 * Created by calvin.wu on 2/29/16.
 */
public class Stock extends Security {

    private String cusip;
    private Double shares;
    private Double purchasedPrice;

    public Stock(String cusip, Double shares, Double purchasedPrice) {
        this.cusip = cusip;
        this.shares = shares;
        this.purchasedPrice = purchasedPrice;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public Double getShares() {
        return shares;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }

    public Double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(Double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "cusip='" + cusip + '\'' +
                ", shares=" + shares +
                ", purchasedPrice=" + purchasedPrice +
                '}';
    }
}
