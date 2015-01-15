package hr.fer.nasp.lab3;

import java.util.List;

public class Vertex {
	public String name;
	public List<Connection> connections;
	public Vertex predecessor = null;
	
	public Vertex (String name, List<Connection> c) {
		this.name = name;
		this.connections = c;
		
	}
}
