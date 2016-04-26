package org.wucalv.quickstart.fullrecon;

import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class ReconServiceTest {

    @Test
    public void testRecon() {

        ReconCache reconCache = new ReconCacheFileImpl();
        reconCache.build();

        ReconService reconService = new ReconServiceImpl(reconCache);
        ReconResult result = reconService.checkReconciliation(LocalDate.of(2016, 4, 6));
        assertThat("isReconciled?", result.isReconciled(), is(true));

        result = reconService.checkReconciliation(LocalDate.of(2016, 4, 7));
        assertThat("isReconciled?", result.isReconciled(), is(false));

        assertThat(result.getDiffs().keySet(), hasSize(2));
        assertThat(result.getDiffs("MSFT"), is(-50.0));
        assertThat(result.getDiffs("CASH"), is(16.0));
    }
}
