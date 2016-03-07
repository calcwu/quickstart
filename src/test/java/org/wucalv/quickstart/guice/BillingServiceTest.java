package org.wucalv.quickstart.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.wucalv.quickstart.guice.model.BillService;
import org.wucalv.quickstart.guice.model.MySqlDatabaseTransactionLog;
import org.wucalv.quickstart.guice.model.TransactionLog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class BillingServiceTest {

    Injector injector;

    @Before
    public void setup() {
        injector = Guice.createInjector(new BillingModule());
    }
    @Test
    public void test() {
        BillService service = injector.getInstance(BillService.class);
        assertTrue(service != null);
    }

    @Test
    public void testDatabaseLog() {
        TransactionLog log = injector.getInstance(TransactionLog.class);
        assertEquals(log.getClass(), MySqlDatabaseTransactionLog.class);
    }
}
