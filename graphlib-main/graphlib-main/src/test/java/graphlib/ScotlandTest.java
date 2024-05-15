package graphlib;

import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.util.Scanner;

public class ScotlandTest
{
    @Test
    public void testGraphViz() throws Exception
    {
        Graph g = Graph.readUndirectedWeightedGraph(new FileInputStream("datafiles/scotlandc.txt"));
        Scanner sc = new Scanner(new FileInputStream("datafiles/scotlandloc.txt"));
        
        StringBuffer sb = new StringBuffer();

        sb.append("graph\n{\n");

        while (sc.hasNext())
        {
            String name = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            sb.append(String.format("%s [\n    label = %s\n    pos = \"%d,%d!\"\n]\n", name, name, x, y));
        }
        sc.close();

        for (Node node : g.getAllNodes())
        {
            for (Node neighbor : node.getNeighbors())
            {
                // make sure we only add each edge once
                if (node.getName().compareTo(neighbor.getName()) < 0)
                {
                    sb.append(String.format("  %s -- %s [label=\"%.1f\"];\n", node.getName(), neighbor.getName(), node.getWeight(neighbor)));
                }
            }
        }
        sb.append("}\n");

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception
    {
        // I can't figure out how to see System.out when I run JUnit through VS Code
        ScotlandTest test = new ScotlandTest();
        //test.testGraphViz();
        test.testGraphViz();
    }


}
