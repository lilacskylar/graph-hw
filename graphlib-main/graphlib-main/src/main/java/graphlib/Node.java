package graphlib;

import java.util.Collection;
import java.util.Map;

public class Node
{
    private String name;
    private Map<Node, Double> neighbors;

    public Node(String name)
    {
        this.name = name;
        neighbors = new java.util.HashMap<>();
    }

    public String getName()
    {
        return name;
    }

    public void addDirectedEdge(Node neighbor, double weight)
    {
        neighbors.put(neighbor, weight);
    }

    public void addUndirectedEdge(Node neighbor, double weight)
    {
        addDirectedEdge(neighbor, weight);
        neighbor.addDirectedEdge(this, weight);
    }

    public void addUnweightedDirectedEdge(Node neighbor)
    {
        addDirectedEdge(neighbor, 1.0);
    }

    public void addUnweightedUndirectedEdge(Node neighbor)
    {
        addUnweightedDirectedEdge(neighbor);
        neighbor.addUnweightedDirectedEdge(this);
    }

    public Collection<Node> getNeighbors()
    {
        return neighbors.keySet();
    }

    public double getWeight(Node neighbor)
    {
        return neighbors.get(neighbor);
    }

    
    public String toString()
    {
        return name;
    }

    public boolean hasEdge(Node neighbor)
    {
        return neighbors.containsKey(neighbor);
    }

}
