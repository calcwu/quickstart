package org.wucalv.quickstart.fullrecon;

import org.wucalv.quickstart.fullrecon.model.Transaction;

import java.util.Collection;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public interface ReconQueryResult {

    Collection<Transaction> getTransactions();
}
