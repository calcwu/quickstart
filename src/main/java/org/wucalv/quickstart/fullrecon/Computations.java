package org.wucalv.quickstart.fullrecon;

import org.wucalv.quickstart.fullrecon.model.Computable;

import java.util.Collection;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public final class Computations {

    private Computations() {
    }

    public static double sum(Collection<? extends Computable> data) {
        return data.stream()
                .mapToDouble(Computable::getValue)
                .sum();
    }
}
