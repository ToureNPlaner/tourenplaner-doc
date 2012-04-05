package de.tourenplaner.algorithms;

import de.tourenplaner.graphrep.GraphRep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleAlgorithmFactory extends GraphAlgorithmFactory {
    private ArrayList<Map<String, Object>> constraints;
    private ArrayList<Map<String, Object>> pointConstraints;
    private HashMap<String, Object>        details;

    public ExampleAlgorithmFactory(GraphRep graph) {
        super(graph);
        // We might as well just return null instead of empty lists for constraints and pointconstraints
        constraints = new ArrayList<Map<String, Object>>(0);
        pointConstraints = new ArrayList<Map<String, Object>>(0);
        details = new HashMap<String, Object>(3);
        details.put("hidden", this.isHidden());
        details.put("minpoints", 2);
        details.put("sourceistarget", false);
    }

    @Override
    public List<Map<String, Object>> getPointConstraints() {
        return this.pointConstraints;
    }

    @Override
    public List<Map<String, Object>> getConstraints() {
        return this.constraints;
    }

    @Override
    public Map<String, Object> getDetails() {
        return details;
    }

    @Override
    public Algorithm createAlgorithm() {
        return new ExampleAlgorithm(graph);
    }

    @Override
    public String getURLSuffix() {
        return "example";
    }

    @Override
    public String getAlgName() {
        return "An example Algorithm";
    }

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public boolean isHidden() {
        return false;
    }
}
