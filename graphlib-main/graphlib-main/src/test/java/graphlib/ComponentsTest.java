package graphlib;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;

import org.junit.jupiter.api.Test;

public class ComponentsTest
{

    @Test
    public void testCrazySimple()
    {
        Graph g = new Graph();
        Node a = g.getOrCreateNode("A");
        Node b = g.getOrCreateNode("B");
        a.addUnweightedUndirectedEdge(b);

        assertEquals(1, g.getNumComponents());
    }

    @Test
    public void testCrazySimple2()
    {
        Graph g = new Graph();
        Node a = g.getOrCreateNode("A");
        Node b = g.getOrCreateNode("B");

        assertEquals(2, g.getNumComponents());
    }

    @Test
    public void testOneBigComponent()
    {
        Graph g = new Graph();
        Node a = g.getOrCreateNode("A");
        Node b = g.getOrCreateNode("B");
        Node c = g.getOrCreateNode("C");
        Node d = g.getOrCreateNode("D");
        Node e = g.getOrCreateNode("E");
        a.addUnweightedUndirectedEdge(b);
        b.addUnweightedUndirectedEdge(c);
        c.addUnweightedUndirectedEdge(d);
        d.addUnweightedUndirectedEdge(a);
        d.addUnweightedUndirectedEdge(e);

        assertEquals(1, g.getNumComponents());
    }

    @Test
    public void testTwoComponents()
    {
        Graph g = new Graph();
        Node a = g.getOrCreateNode("A");
        Node b = g.getOrCreateNode("B");
        Node c = g.getOrCreateNode("C");
        Node d = g.getOrCreateNode("D");
        Node e = g.getOrCreateNode("E");
        a.addUnweightedUndirectedEdge(b);
        b.addUnweightedUndirectedEdge(c);
        c.addUnweightedUndirectedEdge(d);
        d.addUnweightedUndirectedEdge(a);
        d.addUnweightedUndirectedEdge(e);
        g.getOrCreateNode("F");

        assertEquals(2, g.getNumComponents());
    }

    @Test
    public void testTwoComponentsFromFile() throws Exception
    {
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/component1.txt"));

        assertEquals(2, g.getNumComponents());
    }

}
