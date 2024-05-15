package graphlib; 

import java.io.InputStream;
import java.util.Scanner;

public class Islands {
    private static String makeName(int r, int c){
        return r + "-" + c;
    }
    public static Graph readIslands(InputStream in){
        Scanner sc = new Scanner(in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        Graph g = new Graph();
        int[][] grid = new int[rows][cols];
        for (int x = 0; x < rows; x++){
            String line = sc.nextLine();
            for (int y = 0; y < cols; y++){
                grid[x][y] = Integer.parseInt(line.substring(y, y + 1));
            }
        }
        return g;
    }


    public static class CountingVisitor implements NodeVisitor {
        private int count = 0;
        @Override
        public void visit(Node n) {
            count++;
        }
        public int getCount(){
            return count;
        }
    }
    public static void main(String[] args){
        String islands = "3 4\n" +
                "1100\n" +
                "0010\n" +
                "1000";
        Graph g = readIslands(new java.io.ByteArrayInputStream(islands.getBytes());
        int max = 0;
        for (Node n : g.getAllNodes()){
            CountingVisitor v = new CountingVisitor();
            g.bfs(n.getName(), v);
            max = Math.max(max, v.getCount());
        }
        Scanner scan = new Scanner(islands);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        int[][] grid = new int[rows][cols];
        
        for (int x = 0; x < rows; x++) {
            scan.nextLine();
            for (int y = 0; y < cols; y++) {
                grid[x][y] = scan.nextInt();
            }
        }
        scan.close();
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (grid[x][y] == 1) {
                    String name = makeName(x, y);
                    Node n = g.getOrCreateNode(name);
                    //up right
                    if (x > 0 && y < cols - 1 && grid[x - 1][y + 1] == 1) {
                        String newName = makeName(x - 1, y + 1);
                        n.addUnweightedUndirectedEdge(g.getOrCreateNode(newName));
                    }
                    //down right
                    if (x < rows - 1 && y < cols - 1 && grid[x + 1][y + 1] == 1) {
                        String newName = makeName(x + 1, y + 1);
                        n.addUnweightedUndirectedEdge(g.getOrCreateNode(newName));
                    }
                    //right
                    if (y < cols - 1 && grid[x][y + 1] == 1) {
                        String newName = makeName(x, y + 1);
                        n.addUnweightedUndirectedEdge(g.getOrCreateNode(newName));
                    }
                    //down
                    if (x < rows - 1 && grid[x + 1][y] == 1) {
                        String newName = makeName(x + 1, y);
                        n.addUnweightedUndirectedEdge(g.getOrCreateNode(newName));
                    }
                    System.out.println(max);
                }
            }
        }
    }
}
