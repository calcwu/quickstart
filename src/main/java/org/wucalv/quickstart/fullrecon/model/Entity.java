package org.wucalv.quickstart.fullrecon.model;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public abstract class Entity {

    protected CurrencyCode currencyCode;
    protected double units;
    protected double value;

    public abstract String getID();

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public void updateUnits(double units) {
        this.units += units;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void updateValue(double value) {
        this.value += value;
    }
}
