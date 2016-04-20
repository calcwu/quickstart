package org.wucalv.quickstart.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wucalv.quickstart.guice.model.BillService;
import org.wucalv.quickstart.guice.model.MySqlDatabaseTransactionLog;
import org.wucalv.quickstart.guice.model.TransactionLog;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class BillingServiceTest {

    Injector injector;

    @BeforeMethod
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
