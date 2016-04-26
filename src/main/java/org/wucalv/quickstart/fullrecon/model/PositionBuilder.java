package org.wucalv.quickstart.fullrecon.model;

import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class PositionBuilder {

    public static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private LocalDate date;
    private String symbol;
    private EntityType entityType;
    private CurrencyCode currencyCode;
    private double units;
    private double value;

    public static PositionBuilder newBuilder() {
        return new PositionBuilder();
    }

    public PositionBuilder withDate(String date) {
        this.date = LocalDate.parse(date, DATE_FORMATTER);
        return this;
    }

    public PositionBuilder withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public PositionBuilder withType(String type) {
        this.entityType = EntityType.eval(type);
        return this;
    }

    public PositionBuilder withCurrencyCode(String code) {
        this.currencyCode = CurrencyCode.eval(code);
        return this;
    }

    public PositionBuilder withUnits(String units) {
        this.units = NumberUtils.toDouble(units, 0);
        return this;
    }

    public PositionBuilder withValue(String value) {
        this.value = NumberUtils.toDouble(value, 0);
        return this;
    }

    public Position build() {
        Entity entity = entityType.getInstance();
        entity.setUnits(units);
        entity.setCurrencyCode(currencyCode);
        entity.setValue(value);
        if(entity instanceof Security) {
            ((Security) entity).setSymbol(symbol);
        }
        return new Position(date, entity);
    }
}
