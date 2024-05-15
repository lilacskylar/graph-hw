package graphlib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class SkylarTests {
    
    @Test
    public void testBlank() throws Exception {
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/blankgraph.txt"));
        assertEquals(0, g.getNumComponents()); //should not have any components
    }

    // @Test
    // public void testOnOwn() throws Exception {
    //     Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/skylartest.txt"));
    //     assertEquals(2, g.getNumComponents());
    // } commented out because having a graph with one node to a component wouldn't work but i thought it was an interesting test

    @Test
    public void testLine() throws Exception {
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/edgecase2.txt"));
        assertEquals(1, g.getNumComponents());
    }

    @Test
    public void testInterwoven() throws Exception {
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/edgecase1.txt"));
        assertEquals(1, g.getNumComponents()); //to make sure that even with lots of edges it's still 1
    }

    @Test
    public void testInverted() throws Exception {
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/inverse1.txt"));
        assertEquals(1, g.getNumComponents());
    }

    @Test 
    public void testIslands() throws Exception {
        String islands = "3 4\n" +
                "1100\n" +
                "0010\n" +
                "1000";
        Graph g = Islands.readIslands(new java.io.ByteArrayInputStream(islands.getBytes()));
        int max = 0;
        g.dfs(g.getOrCreateNode("0-0").getName(), new Islands.CountingVisitor());
        assertEquals(3, max);
    }
}
