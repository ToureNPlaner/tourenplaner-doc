package de.tourenplaner.algorithms;

import de.tourenplaner.computecore.ComputeRequest;
import de.tourenplaner.computecore.RequestPoints;
import de.tourenplaner.computecore.Way;
import de.tourenplaner.graphrep.GraphRep;

import java.util.HashMap;
import java.util.Map;

public class ExampleAlgorithm extends GraphAlgorithm {
    public ExampleAlgorithm(GraphRep graph) {
        // the abstract class stores the graph representaion for us
        super(graph);
    }

    // the compute method is called for each request for this algorithm. Make sure not to rely on fields defined outside this method to be empty
    @Override
    public void compute(ComputeRequest req) throws ComputeException {
        // that should never happen but better be safe than sorry
        assert req != null : "We ended up without a request object in run";

        // this is the array with points that the client sent us
        RequestPoints points = req.getPoints();

        // these are the constraints the client sent us
        Map<String, Object> constraints = req.getConstraints();

        if (points.size() < 2) {
            // a ComputeException will cause an error message to be sent to the client
            throw new ComputeException("Not enough points, need at least 2");
        }

        Way resultway = new Way();

        // For this example we just reverse the order of the points the client sent us
        for (int i = points.size() - 1; i >= 0;  i--) {
            resultway.addPoint(points.getPointLat(i), points.getPointLon(i));
        }

        // We add our "result" to the (empty) list of ways that will be sent to the client
        req.getResultWays().add(resultway);

        // We write some information in misc. In a real algorithm we would use the graph representation for more :)
        HashMap<String, Object> misc = new HashMap<String, Object>();
        misc.put("Reversed Points", points.size());
        misc.put("Nodes in graph", graph.getNodeCount());
        misc.put("Edges in graph", graph.getEdgeCount());
        req.setMisc(misc);
    }
}
