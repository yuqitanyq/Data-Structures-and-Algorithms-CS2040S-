import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //Initiate fast scanner.
        FastIO fastScanner = new FastIO();

        //Scan coordinates and store all coordinates in an arraylist. Create graph as well.
        Coordinate start = new Coordinate(fastScanner.nextDouble(), fastScanner.nextDouble());
        Coordinate end = new Coordinate(fastScanner.nextDouble(), fastScanner.nextDouble());
        int numOfCannons = fastScanner.nextInt();
        double[][] adjMatrix = new double[numOfCannons + 2][numOfCannons + 2];
        ArrayList<Coordinate> listOfCoordinates = new ArrayList<>();
        listOfCoordinates.add(start);
        for(int i = 0; i < numOfCannons; i++) {
            Coordinate temp = new Coordinate(fastScanner.nextDouble(), fastScanner.nextDouble());
            listOfCoordinates.add(temp);
        }
        listOfCoordinates.add(end);

        //Fill in data for graph.
        for(int a = 0; a < numOfCannons + 2; a++) {
            for(int b = 0; b < numOfCannons + 2; b++) {
                if(a == b) {
                    adjMatrix[a][b] = 0;
                } else if(a == 0 || b == 0) {
                    double dist = listOfCoordinates.get(a).distanceTo(listOfCoordinates.get(b));
                    adjMatrix[a][b] = dist / 5;
                } else {
                    double dist = listOfCoordinates.get(a).distanceTo(listOfCoordinates.get(b));
                    adjMatrix[a][b] = 2 + (Math.abs(dist - 50) / 5);
                }
            }
        }

        //Floyd Warshall's algorithm.
        for(int g = 0; g < numOfCannons + 2; g++) {
            for(int h = 0; h < numOfCannons + 2; h++) {
                for(int k = 0; k < numOfCannons + 2; k++) {
                    adjMatrix[h][k] = Math.min(adjMatrix[h][k], adjMatrix[h][g] + adjMatrix[g][k]);
                }
            }
        }

        //Print out the shortest time taken.
        System.out.println(String.format("%.6f", adjMatrix[0][numOfCannons + 1]));
    }
}
