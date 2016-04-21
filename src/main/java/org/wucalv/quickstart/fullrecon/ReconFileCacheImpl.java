package org.wucalv.quickstart.fullrecon;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class ReconFileCacheImpl implements ReconCache {

    private final Map<LocalDate, Portfolio> portfolioCache = Maps.newHashMap();
    private final Map<LocalDate, Set<Transaction>> transactionCache = Maps.newHashMap();

    private List<EntryConverter> parsers = ImmutableList.of(
        new TransactionTextConverter()
    );

    @Override
    public void add(Entry entry) {

        List data = parsers.stream()
                .filter(p -> p.isValid(entry))
                .map(p -> p.convert(entry))
                .collect(Collectors.toList());

        if(data.isEmpty()) {
            return;
        }
        Object output = data.get(0);
    }
}
