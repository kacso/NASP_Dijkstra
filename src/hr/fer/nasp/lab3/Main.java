package hr.fer.nasp.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String args[]) {
		List<Vertex> graph = new ArrayList<Vertex>();
		
		/**Create vertices*/
		Vertex a = new Vertex("a", null);
		Vertex b = new Vertex("b", null);
		Vertex c = new Vertex("c", null);
		Vertex d = new Vertex("d", null);
		Vertex e = new Vertex("e", null);
		Vertex f = new Vertex("f", null);
		Vertex g = new Vertex("g", null);
		Vertex h = new Vertex("h", null);
		Vertex i = new Vertex("i", null);
		Vertex j = new Vertex("j", null);
		
		
		/**Make connections*/
		List<Connection> con = new ArrayList<Connection>();
		
		/**For a*/
		con.add(new Connection(d, 4));
		con.add(new Connection(e, 1));
		con.add(new Connection(h, 10));
		a.connections = con;
		
		/**For b*/
		con = new ArrayList<Connection>();
		con.add(new Connection(c, 2));
		con.add(new Connection(f, 1));
		b.connections = con;
		
		/**For c*/
		con = new ArrayList<Connection>();
		con.add(new Connection(b, 2));
		con.add(new Connection(f, 3));
		c.connections = con;
		
		/**For d*/
		con = new ArrayList<Connection>();
		con.add(new Connection(a, 4));
		con.add(new Connection(h, 1));
		d.connections = con;
		
		/**For e*/
		con = new ArrayList<Connection>();
		con.add(new Connection(a, 1));
		con.add(new Connection(h, 5));
		con.add(new Connection(f, 3));
		e.connections = con;
		
		/**For f*/
		con = new ArrayList<Connection>();
		con.add(new Connection(b, 1));
		con.add(new Connection(c, 3));
		con.add(new Connection(e, 3));
		con.add(new Connection(i, 1));
		con.add(new Connection(g, 7));
		f.connections = con;

		/**For g*/
		con = new ArrayList<Connection>();
		con.add(new Connection(f, 7));
		con.add(new Connection(j, 1));
		g.connections = con;
		
		/**For h*/
		con = new ArrayList<Connection>();
		con.add(new Connection(a, 10));
		con.add(new Connection(d, 1));
		con.add(new Connection(e, 5));
		con.add(new Connection(i, 9));
		h.connections = con;

		/**For i*/
		con = new ArrayList<Connection>();
		con.add(new Connection(h, 9));
		con.add(new Connection(j, 2));
		con.add(new Connection(f, 1));
		i.connections = con;

		/**For j*/
		con = new ArrayList<Connection>();
		con.add(new Connection(g, 1));
		con.add(new Connection(i, 2));
		j.connections = con;


		/**Add vertices to graph*/
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		graph.add(h);
		graph.add(i);
		graph.add(j);

		Dijkstra dij = new Dijkstra(graph);
		Vertex source = d, dest = j;

		dij.getOptimumPath(source, dest);
		List<Vertex> opt = new ArrayList<Vertex>();
		
		opt.add(dest);
		Vertex prev = dest;
		Vertex v;
		while ((v = prev.predecessor) != source) {
			opt.add(v);
			prev = v;
		}
		opt.add(source);
		
		ListIterator<Vertex> it = opt.listIterator(opt.size());
		while (it.hasPrevious()) {
			v = it.previous();
			if (v != dest) {
				System.out.print(v.name + "->");
			} else {
				System.out.println(v.name);
			}
		}
	}
}
