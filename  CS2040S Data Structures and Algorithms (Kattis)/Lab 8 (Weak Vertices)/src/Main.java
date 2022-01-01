public class Main {
    public static void main(String[] args) {
        //Initialize scanner and scan the number of vertices from input.
        FastIO fastScanner = new FastIO();
        int numOfVertices = fastScanner.nextInt();

        //While the number of vertices is not equal to -1 yet, carry on the loop.
        while(numOfVertices != -1) {

            //Create data structures and store data required for each graph.
            //Creates boolean array tracker which has all false values.
            boolean[] tracker = new boolean[numOfVertices];
            for(int p = 0; p < numOfVertices; p++) {
                tracker[p] = false;
            }

            //Creates the adjacency matrix to store the information on edges.
            int[][] adjMatrix = new int[numOfVertices][numOfVertices];
            for(int i = 0; i < numOfVertices; i++) {
                for(int j = 0; j < numOfVertices; j++) {
                    adjMatrix[i][j] = fastScanner.nextInt();
                }
            }

            /*For every vertex that has an edge, find another different vertex that it has an edge as well.
            If there's such a vertex, check if the two vertexes have an edge.
            If there's an edge, then change the boolean array of that particular index of the vertex to be true.*/
            for(int x = 0; x < numOfVertices; x++ ) {
                    for (int y = 0; y < numOfVertices; y++) {
                        if (adjMatrix[x][y] == 1) {

                            for (int k = y; k < numOfVertices; k++) {
                                if (adjMatrix[x][k] == 1) {

                                    if (adjMatrix[y][k] == 1) {
                                        tracker[x] = true;
                                    }
                                }
                            }
                        }
                    }
            }

            //String builder to print out vertices that have false in the boolean array tracker.
            StringBuilder result = new StringBuilder();
            for(int z = 0; z < numOfVertices; z++) {
                if(!tracker[z]) {
                    result.append(z + " ");
                }
            }
            if(result.length() == 0) {
                System.out.println(result);
            } else {
                System.out.println(result.deleteCharAt(result.length() - 1));
            }

            //Updates numOfVertices to the next number of vertices based on inputs.
            numOfVertices = fastScanner.nextInt();
        }
    }
}
