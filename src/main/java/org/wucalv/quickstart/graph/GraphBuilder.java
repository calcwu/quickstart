package org.wucalv.quickstart.graph;

/**
 * Created by wucalv on 3/13/16.
 */
public class GraphBuilder {

    private Graph financialGraph;

    public GraphBuilder() {
    }

    public Graph build() {
        if(financialGraph != null) {
            return financialGraph;
        }
        financialGraph = new Graph();
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
}
