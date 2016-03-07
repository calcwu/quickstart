package org.wucalv.quickstart.guice.model;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class FakeCreditCardProcessor implements CreditCardProcessor {
    @Override
    public ChargeResult charge(CreditCard creditCard, Double amount) {
        return null;
    }
}
