package graphlib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestNode
{
    
    @Test
    public void testGetName()
    {
        Node node = new Node("A");
        assert node.getName().equals("A");
    }

    @Test
    public void testAddDirectedEdge()
    {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        nodeA.addDirectedEdge(nodeB, 1.0);
        assert nodeA.getNeighbors().contains(nodeB);
        assert nodeA.getWeight(nodeB) == 1.0;
    }

    @Test
    public void testAddUndirectedEdge()
    {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        nodeA.addUndirectedEdge(nodeB, 1.0);
        assert nodeA.getNeighbors().contains(nodeB);
        assert nodeA.getWeight(nodeB) == 1.0;
        assert nodeB.getNeighbors().contains(nodeA);
        assert nodeB.getWeight(nodeA) == 1.0;
    }

}
