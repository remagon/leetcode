package com.feinno.algorithmic.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author renzhaolong
 *
 */
public class GraphUtil<T> {
	private Map<T, Vertex> vertexs;
	private List<Edge> edges;
	
	public GraphUtil() {
		vertexs = new HashMap<T, Vertex>();
		edges = new LinkedList<Edge>();
	}
	
	public void AddVertex(T value) {
		Vertex vertex = new Vertex();
		vertex.point = value;
		vertex.color = VertexColor.WHITE;
		vertexs.put(value, vertex);
	}
	
	public void AddSingleEdge(T t1, T t2) {
		Vertex v1 = vertexs.get(t1);
		Vertex v2 = vertexs.get(t2);
		Edge edge = new Edge();
		edge.startVertex = v1;
		edge.endVertex = v2;
		v1.edges.add(edge);
		edges.add(edge);
	}
	
	public void AddBothwayEdge(T t1, T t2) {
		AddSingleEdge(t1, t2);
		AddSingleEdge(t2, t1);
	}
	
	/**
	 * 深度优先遍历图
	 * @param t
	 * @return
	 */
	public List<T> DFS(T t) {
		for (Vertex v : vertexs.values()) {
			v.color = VertexColor.WHITE;
		}
		List<T> result = new LinkedList<T>();
		DFS(vertexs.get(t), result, true);
		for (Vertex v : vertexs.values()) {
			if (v.color != VertexColor.WHITE)
				continue;
			DFS(v, result, true);
		}
		return result;
	}

	/**
	 * 获取图的拓扑排序
	 * @param t
	 * @return
	 */
	public List<T> topologySort() {
		for (Vertex v : vertexs.values()) {
			v.color = VertexColor.WHITE;
		}
		List<T> result = new LinkedList<T>();
		//DFS(vertexs.get(t), result, false);
		for (Vertex v : vertexs.values()) {
			if (v.color != VertexColor.WHITE)
				continue;
			DFS(v, result, false);
		}
		return result;
	}
	
	private void DFS(Vertex v, List<T> result, boolean addBefore) {
		if (v.color != VertexColor.WHITE)
			return;
		v.color = VertexColor.GRAY;
		if (addBefore) {
			result.add(v.point);
		}
		for (Edge edge : v.edges) {
			DFS(edge.endVertex, result, addBefore);
		}
		if (!addBefore) {
			result.add(0, v.point);
		}
		v.color = VertexColor.BLACK;
	}
	
	private class Edge {
		Vertex startVertex;
		Vertex endVertex;
	}
	
	private class Vertex {
		T point;
		VertexColor color;
		List<Edge> edges = new LinkedList<Edge>();
	}
	
	private enum VertexColor {
		
		WHITE(1), GRAY(2), BLACK(3);

		private int value = 0;
		
		VertexColor(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		GraphUtil<String> testGraph = new GraphUtil<String>();
		testGraph.AddVertex("feinno-lib");
		testGraph.AddVertex("feinno-common");
		testGraph.AddVertex("feinno-ha");
		testGraph.AddVertex("feinno-app-engine");
		testGraph.AddVertex("feinno-app-extension");
		testGraph.AddVertex("feinno-app-master");
		testGraph.AddVertex("feinno-app-synczk");
		testGraph.AddSingleEdge("feinno-lib", "feinno-common");
		testGraph.AddSingleEdge("feinno-lib", "feinno-ha");
		testGraph.AddSingleEdge("feinno-lib", "feinno-app-engine");
		testGraph.AddSingleEdge("feinno-lib", "feinno-app-extension");
		testGraph.AddSingleEdge("feinno-lib", "feinno-app-master");
		testGraph.AddSingleEdge("feinno-common", "feinno-app-master");
		testGraph.AddSingleEdge("feinno-common", "feinno-ha");
		testGraph.AddSingleEdge("feinno-common", "feinno-app-engine");
		testGraph.AddSingleEdge("feinno-common", "feinno-app-extension");
		testGraph.AddSingleEdge("feinno-ha", "feinno-app-engine");
		testGraph.AddSingleEdge("feinno-ha", "feinno-app-extension");
		testGraph.AddSingleEdge("feinno-ha", "feinno-app-synczk");
		testGraph.AddSingleEdge("feinno-app-engine", "feinno-app-extension");
		testGraph.AddSingleEdge("feinno-app-engine", "feinno-app-master");
		testGraph.AddSingleEdge("feinno-app-engine", "feinno-app-synczk");
		System.out.println(testGraph.topologySort());
	}
}
