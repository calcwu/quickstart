package org.wucalv.quickstart.graph;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 *
 */
public class GraphSearcher {

    private Graph graph;

    private Set<Path> paths = Sets.newHashSet();

    public GraphSearcher(Graph graph) {
        this.graph = graph;
    }

//    public Set<Path> findPaths(Vertex root, Predicate<Vertex> predicate) {
//        Queue<Vertex> queue = new LinkedList<Vertex>();
//        queue.add(root);
//        Path path = new Path();
//        while(!queue.isEmpty()) {
//            Vertex v = queue.remove();
//            path.addVertex(v);
//            Set<Vertex> vertices = graph.getNeighbors(v);
//            if(vertices != null) {
//                for(Vertex child : vertices) {
//                    if(predicate.test(child) && ) {
//                        queue.add(child);
//                    }
//                }
//            } else {
//                paths.add(path);
//                path = new Path(visited);
//            }
//        }
//        return paths;
//    }

    public Set<Path> findPaths(Vertex source, Vertex destination) {
        doFindPaths(source, destination, new Path());
        return paths;
    }

    private void doFindPaths(Vertex current, Vertex destination, Path path) {
        path.addVertex(current);

        if(current.equals(destination)) {
            paths.add(new Path(path.getVertices()));
            path.remove(current);
            return;
        }

        Set<Vertex> vertices = graph.getNeighbors(current);
        for(Vertex v : vertices) {
            if(!path.contains(v)) {
                doFindPaths(v, destination, path);
            }
        }
        path.remove(current);
    }
}


