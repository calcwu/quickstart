package org.wucalv.quickstart.fullrecon;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import org.wucalv.quickstart.fullrecon.model.TransactionType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class TransactionTypeTest {

    @Test
    public void test() {
        String[] values = {
                "BUY", "SELL", "dividend reinvest", "transfer in",
                "withdraw", "deposit", "feeS"

        };
        Lists.newArrayList(values)
                .stream()
                .forEach( v -> assertThat(TransactionType.eval(v), is(notNullValue())));
    }
}
