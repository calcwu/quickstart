package org.wucalv.quickstart.fullrecon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class ReconCacheBuilder {

    private final ReconCache reconCache;

    private ReconCacheBuilder(ReconCache dataCache) {
        this.reconCache = dataCache;
    }

    public void parse(InputStream is) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            reader.lines()
                .map(line -> line.trim())
                .filter(line -> !line.isEmpty())
                .forEach(line -> reconCache.add(new Entry.TextEntry(line)));
        }
    }

    public ReconCache getReconCache() {
        return reconCache;
    }

    public static ReconCacheBuilder fileBase() {
        return new ReconCacheBuilder(new ReconFileCacheImpl());
    }
}