package org.wucalv.quickstart.graph;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by wucalv on 3/13/16.
 */
public class GraphSearcherTest {

    @Test
    public void test() {
        GraphBuilder builder = new GraphBuilder();
        Graph graph = builder.build();
        assertEquals(2, graph.getRoots().size());

        GraphSearcher graphSearcher = new GraphSearcher(graph);
    }
}
