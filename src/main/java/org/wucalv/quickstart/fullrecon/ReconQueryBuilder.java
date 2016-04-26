package org.wucalv.quickstart.fullrecon;

import org.wucalv.quickstart.fullrecon.model.TransactionType;

import java.time.LocalDate;

import static org.wucalv.quickstart.fullrecon.model.PositionBuilder.DATE_FORMATTER;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class ReconQueryBuilder {

    private final TransactionType transactionType;

    private LocalDate from;

    private LocalDate to;

    private String symbol;

    private ReconQueryBuilder(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public static ReconQueryBuilder newBuilder(TransactionType tx) {
        return new ReconQueryBuilder(tx);
    }

    public ReconQueryBuilder from(String from, String to)  {
        this.from = LocalDate.parse(from, DATE_FORMATTER);
        this.to = LocalDate.parse(to, DATE_FORMATTER);
        return this;
    }

    public ReconQueryBuilder withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public ReconQuery build() {
        return new ReconQuery() {

            @Override
            public TransactionType getTransactionType() {
                return transactionType;
            }

            @Override
            public LocalDate getFrom() {
                return from;
            }

            @Override
            public LocalDate getTo() {
                return to;
            }

            @Override
            public String getSymbol() {
                return symbol;
            }
        };
    }
}
