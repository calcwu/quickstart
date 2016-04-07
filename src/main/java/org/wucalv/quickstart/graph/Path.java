package org.wucalv.quickstart.graph;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wucalv on 3/13/16.
 */
public class Path {

    private final List<Vertex> vertices;

    public Path() {
        vertices = new ArrayList<>();
    }

    public Path(Vertex... vertices) {
        this.vertices = Lists.newArrayList(vertices);
    }

    public Path(List<Vertex> vertices) {
        this.vertices = Lists.newArrayList(vertices);
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public boolean contains(Vertex vertex) {
        return vertices.contains(vertex);
    }

    public boolean remove(Vertex vertex) {
        return vertices.remove(vertex);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        vertices.stream()
                .forEach(v -> sb.append(v).append("\n"));
        return sb.toString();
    }
}
