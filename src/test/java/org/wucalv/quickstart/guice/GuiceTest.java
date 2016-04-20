package org.wucalv.quickstart.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.testng.annotations.Test;
import org.wucalv.quickstart.guice.model.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by calvin.wu on 3/1/16.
 */
public class GuiceTest {

    @Test
    public void test() {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(CreditCardProcessor.class)
                    .annotatedWith(Names.named("fake"))
                    .to(FakeCreditCardProcessor.class);

                bind(BillService.class).to(FakeBillingService.class);
            }
        });
        BillService service = injector.getInstance(BillService.class);
        assertEquals(service.getClass(), FakeBillingService.class);
        assertEquals(((FakeBillingService) service).processor.getClass(), FakeCreditCardProcessor.class);
    }

    static class FakeBillingService implements BillService {

        final CreditCardProcessor processor;

        @Inject
        public FakeBillingService(@Named("fake") CreditCardProcessor processor) {
            this.processor = processor;
        }

        @Override
        public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
            return null;
        }
    }
}
