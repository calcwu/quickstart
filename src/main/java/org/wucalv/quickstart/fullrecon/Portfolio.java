package org.wucalv.quickstart.fullrecon;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class Portfolio {

    private LocalDate date;

    private Set<Position> positions;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
