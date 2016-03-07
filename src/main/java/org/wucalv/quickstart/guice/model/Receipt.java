package org.wucalv.quickstart.guice.model;

/**
 * Created by calvin.wu on 3/1/16.
 */
public interface Receipt {

    static Receipt forSuccessfulCharge(Double amount) {
        return new Receipt() {
        };
    }

    static Receipt forDeclinedCharge(String message) {
        return new Receipt() {
        };
    }
}
