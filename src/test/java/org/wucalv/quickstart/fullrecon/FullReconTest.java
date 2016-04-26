package org.wucalv.quickstart.fullrecon;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class FullReconTest {

    MockSolution mockSolution;

    @BeforeMethod
    public void setup() {
        mockSolution = new MockSolution();
    }

    @Test
    public void testReconciliation() {

        //check if 04/06/2016 portfolio is reconciled.
        //Hint: Apply T1 transactions to P0 and compare with P1
        assertThat("is 04/06/2016 reconciled?",
                mockSolution.isPortfolioReconciled(LocalDate.of(2016, 4, 6)), is(true));

        //check if 04/07/2016 portfolio is reconciled.
        assertThat("is 04/07/2016 reconciled?",
            mockSolution.isPortfolioReconciled(LocalDate.of(2016, 4, 7)), is(false));

        //add asserts to verify which holding is not reconciled and by how much
    }

    /**
     * Figure out the sum of all the fees charged for a date range, 2016-04-05 to 2016-04-07
     */
    @Test
    public void testGetAllTheFeesByDateRange() {

        assertThat(mockSolution.getTotalTransaction("fees",
                LocalDate.of(2016, 4, 5), LocalDate.of(2016, 4, 7)),
                is(41.5)
        );
    }

    /**
     * Figure out the sum of all dividends received from AAPL for a date range, 2016-04-05 to 2016-04-07
     */
    @Test
    public void testGetAllDividendsFromAAPLByDateRange() {

        assertThat(mockSolution.getTotalTransaction("dividend",
                LocalDate.of(2016, 4, 5), LocalDate.of(2016, 4, 7)),
                is(80.0)
        );
    }
}
