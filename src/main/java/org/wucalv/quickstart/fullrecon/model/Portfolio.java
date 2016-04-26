package org.wucalv.quickstart.fullrecon.model;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class Portfolio {

    private final Map<String, Position> positionMap;

    public Portfolio (Collection<Position> positions) {
        this.positionMap = positions.stream()
                .collect(Collectors.toMap(Position::getID, Function.identity()));
    }

    public void apply(Collection<Transaction> transactions) {
        if(transactions == null || transactions.isEmpty()) {
            return;
        }
        Position cashPosition = positionMap.get(EntityType.CASH.name());

        //convert transaction into multimap
        Multimap<String, Transaction> transactionMultimap = HashMultimap.create();
        transactions.stream().forEach(t -> transactionMultimap.put(t.getSymbol(), t));

        //apply transactions to each position
        for(String key : positionMap.keySet()) {
            Position p = positionMap.get(key);
            Collection<Transaction> posTrans = transactionMultimap.get(key);
            posTrans.stream().forEach(te -> {
                p.updateUnits(te.getTransactionEffect().affectsUnits(te));
                double value = te.getTransactionEffect().affectsCapital(te);
                if(!p.equals(cashPosition) && value != 0.0) {
                    cashPosition.updateUnits(value);
                    cashPosition.updateValue(value);
                } else {
                    p.updateValue(value);
                }
            });
        }
    }

    public Collection<Position> getPositions() {
        return positionMap.values();
    }

    public int size() {
        return positionMap.size();
    }
}
