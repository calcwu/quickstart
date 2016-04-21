package org.wucalv.quickstart.fullrecon;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class FullReconTest {

    @Test
    public void test() throws IOException {

        ReconCacheBuilder reconCacheBuilder = ReconCacheBuilder.fileBase();
        InputStream in = ClassLoader.getSystemResourceAsStream("fullrecon.in");
        reconCacheBuilder.parse(in);
    }
}
