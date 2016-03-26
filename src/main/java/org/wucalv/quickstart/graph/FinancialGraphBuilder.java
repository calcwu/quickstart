package org.wucalv.quickstart.graph;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by wucalv on 3/13/16.
 */
public class FinancialGraphBuilder {

    private FinancialGraph financialGraph;

    public FinancialGraphBuilder() {
    }

    public FinancialGraph build() {
        if(financialGraph != null) {
            return financialGraph;
        }
        financialGraph = new FinancialGraph();
        Individual tony = new Individual("Tony Stark");
        Account fidelity = new Account("Fidelity", "33550099");
        Company starkInternational = new Company(111, "Stark International");
        Individual pepper = new Individual("Pepper Potts");
        Account citi = new Account("Citi", "99001111");


        financialGraph.addEdge(tony, fidelity);
        financialGraph.addEdge(tony, starkInternational);
        financialGraph.addEdge(fidelity, new Stock("yhoo", 10000.0, 100.0));
        financialGraph.addEdge(fidelity, new Stock("goog", 10000.0, 700.0));
        financialGraph.addEdge(fidelity, new Cash("USD", 5000000.0));

        financialGraph.addEdge(pepper, citi);
        financialGraph.addEdge(pepper, starkInternational);
        financialGraph.addEdge(citi, new Cash("USD", 1000000.0));
        return financialGraph;
    }


    public Collection<Path> findPaths(Vertex root, Predicate<Vertex> predicate) {

        Queue<Vertex> data = new LinkedList<Vertex>();
        ArrayListMultimap<Integer, Vertex> multimap = ArrayListMultimap.create();
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()) {
            Vertex v = queue.remove();
            data.add(v);
            multimap.put(count, v);
            Set<Vertex> vertices = financialGraph.getNeighbors(v);
            if(vertices != null) {
                for(Vertex child : vertices) {
                    if(predicate.test(child)) {
                        queue.add(child);
                    }
                }
                count++;
            }
        }

        return convert(multimap);
    }

    private Collection<Path> convert(ArrayListMultimap<Integer, Vertex> map) {
        List<Path> paths = new ArrayList<Path>();
        Map<Integer, Path> data = new HashMap<Integer, Path>();
        for(Integer key : map.keys()) {
            List<Vertex> list = map.get(key);
            int count = 0;
            for(Vertex v : map.get(key)) {
                Path p = data.get(count);
                if(p == null) {
                    p = new Path();
                    data.put(count, p);
                }
                p.addVertex(v);
                count++;
            }
         }
        return data.values();
    }

    public void print() {

        StringBuilder sb = new StringBuilder("Graph:\n");
        for(Vertex v : financialGraph.getVertices()) {
            sb.append(v).append("\n");
            for(Vertex w : financialGraph.getNeighbors(v)) {
                sb.append("\t").append(w).append("\n");
            }
        }
        System.out.println(sb);
    }
}
