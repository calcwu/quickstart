package org.wucalv.quickstart.fullrecon;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wucalv.quickstart.fullrecon.model.TransactionType;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class FullReconSolutionTest {

    ReconService reconService;

    @BeforeMethod
    public void setup() {
        ReconCache reconCache = new ReconCacheFileImpl();
        reconCache.build();
        reconService = new ReconServiceImpl(reconCache);
    }

    @Test
    public void testReconciliation() {

        ReconResult result = reconService.checkReconciliation(LocalDate.of(2016, 4, 6));

        //check if 04/06/2016 portfolio is reconciled.
        //Hint: Apply T1 transactions to P0 and compare with P1
        assertThat("is 04/06/2016 reconciled?", result.isReconciled(), is(true));

        result = reconService.checkReconciliation(LocalDate.of(2016, 4, 7));
        //check if 04/07/2016 portfolio is reconciled.
        assertThat("is 04/07/2016 reconciled?", result.isReconciled(), is(false));

        //add asserts to verify which holding is not reconciled and by how much
        assertThat(result.getDiffs().keySet(), hasSize(2));
        assertThat(result.getDiffs("MSFT"), is(-50.0));
        assertThat(result.getDiffs("CASH"), is(16.0));

    }

    /**
     * Figure out the sum of all the fees charged for a date range, 2016-04-05 to 2016-04-07
     */
    @Test
    public void testGetAllTheFeesByDateRange() {

        ReconQuery reconQuery = ReconQueryBuilder
                .newBuilder(TransactionType.FEES)
                .from("04/05/2016", "04/07/2016")
                .build();

        ReconQueryResult result = reconService.query(reconQuery);
        assertThat(Computations.sum(result.getTransactions()), is(41.5));
    }

    /**
     * Figure out the sum of all dividends received from AAPL for a date range, 2016-04-05 to 2016-04-07
     */
    @Test
    public void testGetAllDividendsFromAAPLByDateRange() {

        ReconQuery reconQuery = ReconQueryBuilder
                .newBuilder(TransactionType.DVD)
                .from("04/05/2016", "04/07/2016")
                .withSymbol("AAPL")
                .build();

        ReconQueryResult result = reconService.query(reconQuery);
        assertThat(Computations.sum(result.getTransactions()), is(80.0));
    }
}
