package org.wucalv.quickstart.fullrecon;

import org.wucalv.quickstart.fullrecon.model.Portfolio;

import java.time.LocalDate;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public interface ReconService {

    ReconResult checkReconciliation(LocalDate date);

    Portfolio getCalculatedPortfolio(LocalDate date);

    ReconQueryResult query(ReconQuery query);
}
