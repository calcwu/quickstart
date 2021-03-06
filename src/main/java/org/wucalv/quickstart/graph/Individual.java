package org.wucalv.quickstart.graph;

/**
 * Created by calvin.wu on 2/29/16.
 */
public class Individual extends Vertex {

    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "name='" + name + '\'' +
                '}';
    }
}
