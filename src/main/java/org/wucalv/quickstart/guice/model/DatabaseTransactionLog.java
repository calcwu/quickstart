package org.wucalv.quickstart.guice.model;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class DatabaseTransactionLog implements TransactionLog {
    @Override
    public void logChargeResult(ChargeResult result) {
        log(result);
    }

    @Override
    public void logException(Exception e) {
        log(e);
    }

    protected void log(Object o) {
        System.out.println(this.getClass().getSimpleName() + " : " + o);
    }
}
