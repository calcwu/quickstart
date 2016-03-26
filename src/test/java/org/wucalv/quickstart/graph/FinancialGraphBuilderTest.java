package org.wucalv.quickstart.graph;

import org.junit.Test;

import java.util.Collection;
import java.util.Queue;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * Created by wucalv on 3/13/16.
 */
public class FinancialGraphBuilderTest {

    @Test
    public void test() {
        FinancialGraphBuilder builder = new FinancialGraphBuilder();
        FinancialGraph graph = builder.build();
        builder.print();
        assertEquals(2, graph.getRoots().size());

        Collection<Path> data = builder.findPaths(graph.findRoot("tony"), new Predicate<Vertex>() {
            @Override
            public boolean test(Vertex v) {
                return v.getId()==null || v.getId() != 111;
            }
        });
        System.out.println("size: " + data.size());
    }
}
