package org.wucalv.quickstart.fullrecon;

import com.google.common.collect.Maps;
import org.wucalv.quickstart.fullrecon.model.Position;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class ReconResult {

    private Map<String, Double> diffs = Maps.newHashMap();

    private ReconResult(){}

    static ReconResult compare(Collection<Position> calculatedPositions,
                               Collection<Position> cachedPositions) {
        checkNotNull(calculatedPositions, "Positions");
        checkNotNull(cachedPositions, "Positions");

        Map<String, Position> targetMap = calculatedPositions.stream()
                .collect(Collectors.toMap(Position::getID, Function.identity()));

        ReconResult result = new ReconResult();
        cachedPositions.stream().forEach(p -> {
            Position p2 = targetMap.get(p.getID());
            double p2Units = p2==null? 0 : p2.getEntity().getUnits();
            double diff = p.getEntity().getUnits() - p2Units;
            if(diff != 0) {
                result.put(p.getID(), diff);
            }
            //remove from the map
            targetMap.remove(p2.getID());
        });
        //add the rest to the diffs
        targetMap.values().stream()
                .filter(p -> p.getEntity().getUnits()!=0.0)
                .forEach(p -> result.put(p.getID(), p.getEntity().getUnits()));

        return result;
    }

    private void put(String id, double diff) {
        diffs.put(id, diff);
    }

    public Map<String, Double> getDiffs() {
        return diffs;
    }

    public double getDiffs(String symbol) {
        return diffs.get(symbol);
    }

    public boolean isReconciled() {
        return diffs.isEmpty();
    }
}
