package org.wucalv.quickstart.guice.model;

import com.google.common.base.Throwables;
import com.google.inject.Inject;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class RealBillingService implements BillService {

    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public RealBillingService(CreditCardProcessor processor,
                              TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.wasSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(result.getDeclineMessage());
        } catch (Exception e) {
            transactionLog.logException(e);
            throw Throwables.propagate(e);
        }
    }

    public CreditCardProcessor getProcessor() {
        return processor;
    }

    public TransactionLog getTransactionLog() {
        return transactionLog;
    }
}
