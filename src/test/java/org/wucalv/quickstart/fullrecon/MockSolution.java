package org.wucalv.quickstart.fullrecon;

import java.time.LocalDate;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class MockSolution {

    public boolean isPortfolioReconciled(LocalDate date) {
        if(date.equals(LocalDate.of(2016, 4, 6))) {
            return true;
        }
        if (date.equals(LocalDate.of(2016, 4, 7))) {
            return false;
        }
        throw new IllegalArgumentException(date + " is not supported");
    }

    public double getTotalTransaction(String transactionType,
                                      LocalDate postedDate1, LocalDate postedDate2) {
        switch(transactionType) {
            case "fees":
                return 41.5;
            case "dividend":
                return 80;
            default:
                throw new IllegalArgumentException(transactionType + " is not supported");
        }
    }
}
