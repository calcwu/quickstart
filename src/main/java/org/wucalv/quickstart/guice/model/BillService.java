package org.wucalv.quickstart.guice.model;

/**
 * Created by calvin.wu on 3/1/16.
 */
public interface BillService {

    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
