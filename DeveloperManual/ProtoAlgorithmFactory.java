package algorithms;

import graphrep.GraphRep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class ProtoAlgorithmFactory extends SharingAlgorithmFactory {
public class ProtoAlgorithmFactory extends AlgorithmFactory {
	public ProtoAlgorithmFactory(GraphRep graph) {
		super(graph);
	}

	//When using DijkstraStructs:
	//@Override
	//public Algorithm createAlgorithm(DijkstraStructs rs) {
	//	return new ProtoAlgorithm(graph, rs);
	//}

	// must be there even when not using DijkstraStructs:
	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.AlgorithmFactory#createAlgorithm()
	 */
	@Override
	public Algorithm createAlgorithm() {
		return new ProtoAlgorithm(graph, new DijkstraStructs(
				graph.getNodeCount(), graph.getEdgeCount()));
	}

	@Override
	public String getURLSuffix() {
		return "protoalg";
	}

	@Override
	public String getAlgName() {
		return "Proto Algorithm";
	}

	@Override
	public int getVersion() {
		return 1;
	}

	@Override
	public List<Map<String, Object>> getPointConstraints() {
		return null;
	}

	@Override
	public Map<String, Object> getConstraints() {
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("minPoints", Integer.valueOf(2));
		map.put("sourceIsTarget", Boolean.FALSE);
		return map;
	}

	@Override
	public boolean hidden() {
		return false;
	}
}
