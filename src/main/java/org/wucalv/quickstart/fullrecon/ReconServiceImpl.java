package org.wucalv.quickstart.fullrecon;

import com.google.common.collect.Lists;
import org.wucalv.quickstart.fullrecon.model.Portfolio;
import org.wucalv.quickstart.fullrecon.model.Position;
import org.wucalv.quickstart.fullrecon.model.Transaction;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class ReconServiceImpl implements ReconService {

    private final ReconCache reconCache;

    public ReconServiceImpl(ReconCache reconCache) {
        this.reconCache = reconCache;
    }

    @Override
    public ReconResult checkReconciliation(LocalDate date) {
        checkNotNull(date, "Date");
        Portfolio calculatedPortfolio = getCalculatedPortfolio(date);
        Collection<Position> cachedPositions = getPositions(date);
        return ReconResult.compare(calculatedPortfolio.getPositions(), cachedPositions);
    }

    @Override
    public Portfolio getCalculatedPortfolio(LocalDate date) {
        checkNotNull(date);
        //get last portfolio
        Collection<Position> lastPositions = getPositions(date.minusDays(1));
        Portfolio portfolio = new Portfolio(lastPositions);

        //get transactions
        Collection<Transaction> transactions = getTransactions(date);
        portfolio.apply(transactions);
        return portfolio;
    }

    @Override
    public ReconQueryResult query(ReconQuery query) {
        checkNotNull(query, ReconQuery.class.getSimpleName());

        List<Transaction> transactionList = Lists.newArrayList();
        LocalDate date = query.getFrom();
        while(!date.isAfter(query.getTo())) {
            transactionList.addAll(
                reconCache.getTransactions(date).stream()
                    .filter(t -> t.getTransactionType() == query.getTransactionType())
                    .filter(t -> query.getSymbol()!=null?
                        t.getSymbol().equals(query.getSymbol()) : t.getSymbol()!=null
                    )
                    .collect(Collectors.toList())
            );
            date = date.plusDays(1);
        }
        return () -> transactionList ;
    }

    private Collection<Position> getPositions(LocalDate date) {
        Collection<Position> positions = reconCache.getPositions(date);
        if(positions == null) {
            throw new IllegalArgumentException("Cannot find position history for " + date);
        }
        return positions;
    }

    private Collection<Transaction> getTransactions(LocalDate postedDate) {
        Collection<Transaction> transactions = reconCache.getTransactions(postedDate);
        if(transactions == null) {
            throw new IllegalArgumentException("Cannot find transaction history for " + postedDate);
        }
        return transactions;
    }
}
