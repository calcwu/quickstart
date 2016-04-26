package org.wucalv.quickstart.fullrecon.model;

import com.google.common.base.Throwables;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public enum EntityType {

    STOCK (Stock.class),
    MUTUAL_FUND (MutualFund.class, "Mutual Fund"),
    CASH (Cash.class)
    ;
    private Class<? extends Entity> clazz;
    private String text;

    EntityType(Class<? extends Entity> clazz) {
        this.clazz = clazz;
    }

    EntityType(Class<? extends Entity> clazz, String text) {
        this.clazz = clazz;
        this.text = text;
    }

    public Entity getInstance() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException|IllegalAccessException e) {
            throw Throwables.propagate(e);
        }
    }

    public static EntityType eval(String type) {
        for(EntityType et : values()) {
            if(et.name().equalsIgnoreCase(type) ||
                (et.text !=null && et.text.equalsIgnoreCase(type))) {
                return et;
            }
        }
        throw new IllegalArgumentException("Invalid type: ");
    }
}
