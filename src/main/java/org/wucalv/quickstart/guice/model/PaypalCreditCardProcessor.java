package org.wucalv.quickstart.guice.model;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor {
    @Override
    public ChargeResult charge(CreditCard creditCard, Double amount) {
        System.out.println(this.getClass().getName() + " : " + creditCard + " : " + amount);
        return new ChargeResult() {
            @Override
            public String getDeclineMessage() {
                return null;
            }

            @Override
            public boolean wasSuccessful() {
                return true;
            }
        };
    }
}
