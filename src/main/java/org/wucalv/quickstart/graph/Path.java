package org.wucalv.quickstart.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wucalv on 3/13/16.
 */
public class Path {

    private List<Vertex> paths = new ArrayList<>();

    public void addVertex(Vertex v) {
        paths.add(v);
    }

    public List<Vertex> getPaths() {
        return paths;
    }
}
