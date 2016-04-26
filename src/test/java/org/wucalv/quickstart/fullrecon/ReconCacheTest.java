package org.wucalv.quickstart.fullrecon;

import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class ReconCacheTest {

    @Test
    public void test() throws IOException {

        ReconCache reconCache = new ReconCacheFileImpl();
        reconCache.build();

        assertThat(reconCache, is(notNullValue()));
        //check position cache
        assertThat(reconCache.getPositions(LocalDate.of(2016, 4, 5)), hasSize(5));
        assertThat(reconCache.getPositions(LocalDate.of(2016, 4, 6)), hasSize(5));
        assertThat(reconCache.getPositions(LocalDate.of(2016, 4, 7)), hasSize(4));

        //check transaction cache
        assertThat(reconCache.getTransactions(LocalDate.of(2016, 4, 6)), hasSize(6));
        assertThat(reconCache.getTransactions(LocalDate.of(2016, 4, 7)), hasSize(5));

    }

    @Test
    public void linePatternTest() throws ParseException {

        ReconCacheFileImpl reconCache = new ReconCacheFileImpl();
        String[] invalidLines = {"Security,test,", "Type,,", "P0,,", "T0,,,,", ",,,,"};
        Arrays.asList(invalidLines).stream()
            .forEach(l -> assertThat(l, reconCache.isValid(l), is(false))
            );

        String[] validLines = {"01/02/2011,,", "dvdr,,", "buy,,", "blah,,,,"};
        Arrays.asList(validLines).stream()
                .forEach(l -> assertThat(l, reconCache.isValid(l), is(true))
                );
    }


}
