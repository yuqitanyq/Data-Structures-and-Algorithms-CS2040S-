import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //Initiate scanner.
        FastIO fastScanner = new FastIO();

        //Scan the number of villages.
        int numOfVillages = fastScanner.nextInt();

        //Edge list to represent the graph, set to represent queue of edges, edge set for union find.
        ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();
        LinkedList<Edge> set = new LinkedList<>();
        UnionFind edgeSet = new UnionFind(numOfVillages);

        //Scan data and input into the data structures.
        for(int i = 0; i < numOfVillages; i++) {
            ArrayList<Edge> temp = new ArrayList<>();
            edgeList.add(temp);
            for(int j = 0; j < numOfVillages; j++) {
                int weight = fastScanner.nextInt();
                if(j > i) {
                        Edge edge = new Edge(i, j, weight);
                        ArrayList<Edge> existing = edgeList.get(i);
                        existing.add(edge);
                        edgeList.set(i, existing);
                        set.add(edge);
                }
            }
        }

        //Sort the queue based on lowest weight come first, for Kruskal's algorithm.
        Collections.sort(set, new EdgeComparator());

        /*While minimum spanning tree has not been completed yet, continue to poll from the queue,
        check if a cycle is present based on union find. If no cycle is present, then add the edge to
        minimum spanning tree.*/
        int edgeCount = 0;
        while (edgeCount < numOfVillages - 1) {
            Edge item = set.poll();
            int m = edgeSet.findSet(item.beginIndex);
            int n = edgeSet.findSet(item.endIndex);
            if(m != n) {
                edgeSet.unionSet(item.beginIndex, item.endIndex);
                edgeCount++;

                //Print out the edge that has been added to minimum spanning tree.
                System.out.println((item.beginIndex + 1) + " " + (item.endIndex + 1));
            }
        }
    }
}
