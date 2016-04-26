package org.wucalv.quickstart.fullrecon;

import com.google.common.base.Throwables;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.wucalv.quickstart.fullrecon.model.EntityType;
import org.wucalv.quickstart.fullrecon.model.Position;
import org.wucalv.quickstart.fullrecon.model.PositionBuilder;
import org.wucalv.quickstart.fullrecon.model.Transaction;
import org.wucalv.quickstart.fullrecon.model.TransactionBuilder;
import org.wucalv.quickstart.fullrecon.model.TransactionType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Collection;
import java.util.regex.Pattern;

import static org.wucalv.quickstart.fullrecon.ReconCacheFileImpl.Column.getData;
import static org.wucalv.quickstart.fullrecon.ReconDataType.POSITION;
import static org.wucalv.quickstart.fullrecon.ReconDataType.TRANSACTION;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
class ReconCacheFileImpl implements ReconCache {

    private static final Pattern BOGUS_LINE_PATTERN =
            Pattern.compile("^(Security|Type|,|(P|T)[0-9]).*$");

    private final Multimap<LocalDate, Position> positionCache = HashMultimap.create();

    private final Multimap<LocalDate, Transaction> transactionCache = HashMultimap.create();

    @Override
    public void build() {
        InputStream is = ClassLoader.getSystemResourceAsStream("FullReconData.csv");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            reader.lines()
                    .map(String::trim)
                    .filter(this::isValid)
                    .forEach(this::parse);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    private void parse(String line) {
        String[] tokens = line.split(",");
        ReconDataType type = evalReconDataType(tokens);
        switch(type) {
            case POSITION: //portfolio position
                Position position = PositionBuilder.newBuilder()
                        .withDate(getData(tokens, PositionColumn.DATE))
                        .withSymbol(getData(tokens, PositionColumn.SECURITY))
                        .withType(getData(tokens, PositionColumn.SECURITY_TYPE))
                        .withCurrencyCode(getData(tokens, PositionColumn.CURRENCY_CODE))
                        .withUnits(getData(tokens, PositionColumn.UNITS))
                        .withValue(getData(tokens, PositionColumn.VALUE))
                        .build();
                positionCache.put(position.getDate(), position);
                break;
            case TRANSACTION: //transaction
                Transaction transaction = TransactionBuilder.newBuilder()
                        .withTransactionType(getData(tokens, TransactionColumn.TRANSACTION_TYPE))
                        .withSymbol(getData(tokens, TransactionColumn.SECURITY))
                        .withCurrencyCode(getData(tokens, TransactionColumn.CURRENCY_CODE))
                        .withUnits(getData(tokens, TransactionColumn.UNITS))
                        .withTradeDate(getData(tokens, TransactionColumn.TRADE_DATE))
                        .withPostedDate(getData(tokens, TransactionColumn.POSTED_DATE))
                        .withAmount(getData(tokens, TransactionColumn.AMOUNT))
                        .build();
                transactionCache.put(transaction.getPostedDate(), transaction);
        }
    }

    @Override
    public Collection<Position> getPositions(LocalDate date) {
        return positionCache.get(date);
    }

    @Override
    public Collection<Transaction> getTransactions(LocalDate postedDate) {
        return transactionCache.get(postedDate);
    }

    boolean isValid(String line) {
        return !BOGUS_LINE_PATTERN.matcher(line).matches();
    }

    private static ReconDataType evalReconDataType(String[] tokens) {
        try {
            TransactionType.eval(getData(tokens, TransactionColumn.TRANSACTION_TYPE));
            return TRANSACTION;
        } catch (IllegalArgumentException e) {
            EntityType.eval(getData(tokens, PositionColumn.SECURITY_TYPE));
            return POSITION;
        }
    }

    enum PositionColumn implements Column {
        SECURITY(0),
        SECURITY_TYPE(1),
        CURRENCY_CODE(2),
        UNITS(3),
        DATE(4),
        VALUE(5)
        ;
        private int index;
        PositionColumn(int idx) {
            this.index = idx;
        }

        @Override
        public int getIndex() {
            return index;
        }
    }
    enum TransactionColumn implements Column {
        TRANSACTION_TYPE(0),
        SECURITY(1),
        CURRENCY_CODE(2),
        UNITS(3),
        TRADE_DATE(4),
        POSTED_DATE(5),
        AMOUNT(6)
        ;
        private int index;
        TransactionColumn(int idx) {
            this.index = idx;
        }
        @Override
        public int getIndex() {
            return index;
        }
    }

    interface Column {

        int getIndex();

        static String getData(String[] tokens, Column column) {
            return tokens[column.getIndex()];
        }
    }
}
