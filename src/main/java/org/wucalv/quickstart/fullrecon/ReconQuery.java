package org.wucalv.quickstart.fullrecon;

import org.wucalv.quickstart.fullrecon.model.TransactionType;

import java.time.LocalDate;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public interface ReconQuery {

    TransactionType getTransactionType();

    LocalDate getFrom();

    LocalDate getTo();

    String getSymbol();
}
