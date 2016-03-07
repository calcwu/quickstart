package org.wucalv.quickstart.guice;

import com.google.inject.AbstractModule;
import org.wucalv.quickstart.guice.model.*;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillService.class).to(RealBillingService.class);

        //update db log binding
        bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);
    }
}
