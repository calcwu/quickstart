package org.wucalv.quickstart.fullrecon.model;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public enum CurrencyCode {

    USD
    ;
    public static CurrencyCode eval(String code) {
        for(CurrencyCode c : values()) {
            if(c.name().equalsIgnoreCase(code)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid currencyCode code: " + code);
    }

}
