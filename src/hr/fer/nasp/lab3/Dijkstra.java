package hr.fer.nasp.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
	private List<Vertex> graph;

	public Dijkstra(List<Vertex> graph) {
		this.graph = graph;
	}

	public void getOptimumPath(Vertex source, Vertex dest) {
		Map<Vertex, Integer> d = new HashMap<Vertex, Integer>();
		List<Vertex> toBeCh = new ArrayList<Vertex>();
		/** Initialization */
		for (Vertex vertex : graph) {
			if (vertex != source) {
				d.put(vertex, 999);
			} else {
				d.put(vertex, 0);
			}
			toBeCh.add(vertex);
		}

		while (!toBeCh.isEmpty()) {
			/** Find least */
			Vertex v = toBeCh.get(0);
			for (Vertex vTmp : toBeCh) {
				if (d.get(vTmp) < d.get(v)) {
					v = vTmp;
				}
			}

			/** If we are at dest then we find it */
			if (v == dest) {
				return;
			}

			toBeCh.remove(v);

			for (Connection u : v.connections) {
				if (toBeCh.contains(u.vertex)) {
					Map<Vertex, Integer> dNew = new HashMap<Vertex, Integer>();
					dNew.put(u.vertex, d.get(v) + u.value);
					if (dNew.get(u.vertex) < d.get(u.vertex)) {
						d.put(u.vertex, dNew.get(u.vertex));
						u.vertex.predecessor = v;
					}
				}
			}
		}

	}
}
