package algorithms;

import com.carrotsearch.hppc.BitSet;
import com.carrotsearch.hppc.IntArrayDeque;
import computecore.ComputeRequest;
import computecore.Points;
import computecore.RequestPoints;
import graphrep.GraphRep;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ShortestPathCH extends GraphAlgorithm {

    private static Logger log = Logger.getLogger("algorithms");

    //public ProtoAlgorithm(GraphRep graph, DijkstraStructs resourceSharer) {
    public ProtoAlgorithm(GraphRep graph) {
        super(graph);
        //ds = resourceSharer;
    }

    @Override
    public void compute(ComputeRequest req) throws ComputeException {
        assert req != null : "We ended up without a request object in run";

        RequestPoints points = req.getPoints();
        // Check if we have enough points to do something useful
        if (points.size() < 1) {
            throw new ComputeException("Not enough points, need at least 1");
        }

        Points resultWay = req.getResulWay();
        int distance = 0;
        try {
            // First let's map the RequestPoints to Ids
            points.setIdsFromGraph(graph);
            // Then compute the multi hop shortest path of them
            distance = computeAlgorithm(points, resultWay, false);
        } catch (IllegalAccessException e) {
            // If this happens there likely is a programming error
            e.printStackTrace();
        }

        Map<String, Object> misc = new HashMap<String, Object>(1);
        misc.put("distance", distance);
        req.setMisc(misc);
    }

    protected int computeAlgorithm(RequestPoints points, Points resultWay, boolean tour) throws ComputeException, IllegalAccessException {
      resultWay.addPoint(graph.getNodeLat(1), graph.getNodeLon(2));
      log.fine("Added one point to the result");
      return distance;
    }
}