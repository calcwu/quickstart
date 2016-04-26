package org.wucalv.quickstart.fullrecon.model;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public abstract class Security extends Entity {

    protected String symbol;

    @Override
    public String getID() {
        return getSymbol();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
