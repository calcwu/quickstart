package org.wucalv.quickstart.fullrecon;

import org.wucalv.quickstart.fullrecon.model.Position;
import org.wucalv.quickstart.fullrecon.model.Transaction;

import java.time.LocalDate;
import java.util.Collection;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public interface ReconCache {

    void build();

    Collection<Position> getPositions(LocalDate date);

    Collection<Transaction> getTransactions(LocalDate postedDate);
}
