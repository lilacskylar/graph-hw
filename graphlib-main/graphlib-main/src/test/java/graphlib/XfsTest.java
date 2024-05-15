package graphlib;

import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class XfsTest
{
    @Test
    public void testBfs() throws Exception
    {
        //System.out.println("Hello");
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/graph1.txt"));
        g.bfs("0", new NodeVisitor()
        {
            public void visit(Node node)
            {
                System.out.println(node.getName());
            }
        });
    }

    @Test
    public void testDfs() throws Exception
    {
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/graph1.txt"));
        g.dfs("0", new NodeVisitor()
        {
            public void visit(Node node)
            {
                System.out.println(node.getName());
            }
        });
    }

    static class CountingVisitor implements NodeVisitor
    {
        private int count = 0;

        public void visit(Node node)
        {
            count += 1;
        }

        public int getCount()
        {
            return count;
        }
    }


    @Test
    public void testMystery() throws Exception
    {
        Graph g = Graph.readUndirectedUnweightedGraph(new FileInputStream("datafiles/graph5.txt"));
        Collection<Node> nodes = g.getAllNodes();
        int max = 0;

        for (Node node : nodes)
        {
            CountingVisitor countingVisitor = new CountingVisitor();
            g.bfs(node.getName(), countingVisitor);
            if (countingVisitor.getCount() > max)
            {
                max = countingVisitor.getCount();
            }
        }
        System.out.printf("max: %d\n", max);
    }

}
