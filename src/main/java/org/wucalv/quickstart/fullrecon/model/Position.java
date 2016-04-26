package org.wucalv.quickstart.fullrecon.model;

import java.time.LocalDate;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class Position {

    private final LocalDate date;

    private final Entity entity;

    Position(LocalDate date, Entity entity) {
        this.date = date;
        this.entity = entity;
    }

    public LocalDate getDate() {
        return date;
    }

    public Entity getEntity() {
        return entity;
    }

    public String getID() {
        return entity.getID();
    }

    public void updateUnits(double units) {
        entity.updateUnits(units);
    }

    public void updateValue(double value) {
        entity.updateValue(value);
    }

    @Override
    public int hashCode() {
        return getID().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Position)) {
            return false;
        }
        Position p = (Position) obj;
        return getID().equals(p.getID());
    }

    @Override
    public String toString() {
        return "Position{" +
                "date=" + date +
                ", entity=" + entity.getID() +
                ", units=" + entity.getUnits() +
                ", value=" + entity.getValue() +
                '}';
    }
}
