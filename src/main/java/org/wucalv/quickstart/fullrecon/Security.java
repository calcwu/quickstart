package org.wucalv.quickstart.fullrecon;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public abstract class Security {

    private Currency currency;
    private Double units;
    private Double value;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
