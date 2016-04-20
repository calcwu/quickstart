package org.wucalv.quickstart.fullrecon;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class DataParserTest {

    @Test
    public void test() throws IOException {

        DataParser dataParser = new DataParser();
        InputStream in = ClassLoader.getSystemResourceAsStream("fullrecon.in");
        dataParser.parse(in);
    }
}
