import java.io.*;
import java.util.ArrayList;

public class Main {
    //DFS for Toposort.
    public static void dfs(int vertex, int[] visited, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> toposort) {
        visited[vertex] = 1;
        ArrayList<Integer> neighbourList = adjList.get(vertex);
        int length = neighbourList.size();
        for (int m = 0; m < length; m++) {
            int nextVertex = neighbourList.get(m);
            if (visited[nextVertex] == 0) {
                visited[nextVertex] = 1;
                dfs(nextVertex, visited, adjList, toposort);
            }
        }
        toposort.add(vertex);
    }

    //DFS for normal recursive.
    public static void dfs(int vertex, int[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[vertex] = 1;
        ArrayList<Integer> neighbourList = adjList.get(vertex);
        int length = neighbourList.size();
        for (int m = 0; m < length; m++) {
            int nextVertex = neighbourList.get(m);
            if (visited[nextVertex] == 0) {
                visited[nextVertex] = 1;
                dfs(nextVertex, visited, adjList);
            }
        }
    }

    public static void main(String[] args) {
        //Create fast scanner and print writer to scan and print respectively.
        FastIO fastScanner = new FastIO();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Scans number of test cases.
        int numOfTestCases = fastScanner.nextInt();
        //Runs this loop for each test case.
        for(int i = 0; i < numOfTestCases; i++) {
            //Scan number of tiles and number of lines.
            int numOfTiles = fastScanner.nextInt();
            int numOfLines = fastScanner.nextInt();

            //Initiate all the necessary visited arrays, toposort arraylist and graph adjacent list.
            int[] visited = new int[numOfTiles];
            int[] visited2 = new int[numOfTiles];
            ArrayList<Integer> toposort = new ArrayList<>();
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            for (int j = 0; j < numOfTiles; j++) {
                visited[j] = 0;
                visited2[j] = 0;
                ArrayList<Integer> temp = new ArrayList<>();
                adjList.add(temp);
            }

            //Scan all the data into the graph.
            for (int k = 0; k < numOfLines; k++) {
                int x = fastScanner.nextInt();
                int y = fastScanner.nextInt();
                int index = x - 1;
                int item = y - 1;
                ArrayList<Integer> neighbourList = adjList.get(index);
                neighbourList.add(item);
                adjList.set(index, neighbourList);
            }

            //DFS toposort to get the toposort arraylist with items in the correct order.
            for (int m = 0; m < numOfTiles; m++) {
                if (visited[m] == 0) {
                    Main.dfs(m, visited, adjList, toposort);
                }
            }

            /*In reverse order of the toposort array, for each item, for every neighbour, run DFS on the neighbour
            if not visited yet.*/
            int count = 0;
            for (int n = numOfTiles - 1; n >= 0; n--) {
                int item = toposort.get(n);
                if (visited2[item] == 0) {
                    count = count + 1;
                }
                ArrayList<Integer> neighbourList = adjList.get(item);
                int length = neighbourList.size();
                for (int p = 0; p < length; p++) {
                    int neighbour = neighbourList.get(p);
                    if (visited2[neighbour] == 0) {
                        visited2[neighbour] = 1;
                        dfs(neighbour, visited2, adjList);
                    }
                }
            }
            //Print the count, which is the minimum number of dominos that must be knocked over by hand.
            pw.println(count);
        }

        //Flushes and closes the print writer.
        pw.flush();
        pw.close();
    }
}