package org.wucalv.quickstart.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by calvin.wu on 2/29/16.
 */
public class FinancialGraph {

    private Map<Vertex, Set<Vertex>> verticesMap = new HashMap<>();

    private Set<Vertex> roots = new HashSet<>();

    int edges;

    public int countVertices() {
        return verticesMap.size();
    }

    public int countEdges() {
        return edges;
    }

    public boolean hasVertex(Vertex v) {
        return verticesMap.containsKey(v);
    }

    void addVertex(Vertex v) {
        if(!hasVertex(v)) {
            verticesMap.put(v, new HashSet<>());
            if(v instanceof Individual) {
                roots.add(v);
            }
        }
    }

    public Set<Vertex> getVertices() {
        return verticesMap.keySet();
    }

    public Set<Vertex> getNeighbors(Vertex v) {
//        validateVertex(v);
        return verticesMap.get(v);
    }

    public Set<Vertex> getRoots() {
        return roots;
    }

    public Vertex findRoot(String name) {
        return getRoots()
                .stream()
                .filter(p ->
                    ((Individual) p).getName().toLowerCase().contains(name.toLowerCase())
                )
                .collect(Collectors.toList())
                .get(0);
    }
    private void validateVertex(Vertex v) {
        if(!hasVertex(v)) {
            throw new IllegalArgumentException(v + " is not a vertex.");
        }
    }

    void addEdge(Vertex v1, Vertex v2) {
        addVertex(v1);
//        addVertex(v2);
        if(!hasEdge(v1, v2)){
            edges++;
        }
        verticesMap.get(v1).add(v2);
//        verticesMap.get(v2).add(v1);
    }

    public boolean hasEdge(Vertex v1, Vertex v2) {
//        validateVertex(v1);
//        validateVertex(v2);
        return verticesMap.get(v1).contains(v2);
    }
}
