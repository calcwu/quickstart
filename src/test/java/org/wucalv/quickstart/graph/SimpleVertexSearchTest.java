package org.wucalv.quickstart.graph;


import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class SimpleVertexSearchTest {

    @Test
    public void testGraph() {

        Graph graph = build();
        assertThat(graph.getNeighbors(newV("A")), hasSize(2));

        GraphSearcher searcher = new GraphSearcher(graph);
        Set<Path> paths = searcher.findPaths(newV("A"), newV("D"));
        paths.stream().forEach(p -> System.out.println(p));
    }

    Graph build() {
        Graph graph = new Graph();
        graph.addEdge(newV("A"), newV("B"));
        graph.addEdge(newV("A"), newV("C"));
        graph.addEdge(newV("B"), newV("C"));
        graph.addEdge(newV("B"), newV("D"));
        graph.addEdge(newV("C"), newV("B"));
        graph.addEdge(newV("C"), newV("D"));
        return graph;
    }

    static SimpleVertex newV(String value) {
        return new SimpleVertex(value);
    }
}
