package org.wucalv.quickstart.graph;

/**
 * Created by wucalv on 3/13/16.
 */
public class Company extends Vertex {

    private String name;

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
