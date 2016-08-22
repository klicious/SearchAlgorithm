import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DFS {

	public static void main(String arg) {
		// get Input
		String result = null;
		
		String[] lines = arg.split(System.lineSeparator());
		
		String[] temp = lines[0].split(" ");
		int numOfNodes = Integer.parseInt(temp[0]);
		int startingNode = Integer.parseInt(temp[1]);
		
		temp = lines[1].split(" ");
		
		ArrayList<pair> graph = new ArrayList<>();
		for(int i = 0; i < temp.length; i++) {
			graph.add(new pair(Integer.parseInt(temp[i]), Integer.parseInt(temp[++i])));
		}
		
		

	}

}

class Graph {
	Map<Integer, ArrayList<Edge>> vertex;
	
	Graph() {
		init();
	}
	
	private void init() {
		vertex = new HashMap<>();
	}
	
	public void addVertex(int v) {
		this.vertex.put(v, new ArrayList<Edge>());
	}
	
	public void addEdge(Edge e) {
		int v = e.from;
		vertex.get(v).add(e);
		
	}
	
	public void addEdge(int from, int to) {
		int v = from;
		this.vertex.get(v).add(new Edge(from,to));
	}
}

class Vertex {
	int vertex;
	ArrayList<Edge> edges;
	
	Vertex(){
		init();
	}
	
	Vertex(int v) {
		init();
		this.vertex = v;
	}
	
	private void init(){
		this.vertex = -1;
		this.edges = new ArrayList<Edge>();
	}
	
	public void add(Edge e) {
		this.edges.add(e);
	}
	
}

class Edge {
	int from;
	int to;
	
	Edge() {
		init();
	}
	
	Edge(int f, int t) {
		init();
		this.from = f;
		this.to = t;
	}
	
	private void init() {
		this.from = -1;
		this.to = -1;
	}
}

class pair {
	int left;
	int right;
	
	pair() {
		init();
	}
	
	pair(int l, int r) {
		this.left = l;
		this.right = r;
	}
	
	private void init() {
		this.left = 0;
		this.right = 0;
	}
	
	public boolean isEnd() {
		return (left == -1 && right == -1);
	}
}