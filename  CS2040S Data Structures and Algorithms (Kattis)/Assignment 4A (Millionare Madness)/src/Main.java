import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        //Create fast scanner and print writer to scan and print respectively.
        FastIO fastScanner = new FastIO();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        /*Create visited array, coins array, where
        visited array is initialize to 0, and coins array will take in data from input.*/
        int rows = fastScanner.nextInt();
        int cols = fastScanner.nextInt();
        int height = 0;
        int[][] visited = new int[rows][cols];
        int[][] coins = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                visited[r][c] = 0;
                coins[r][c] = fastScanner.nextInt();
            }
        }

        //Create priority queue to get the smallest height difference.
        PriorityQueue<Traits> q = new PriorityQueue<>(new TraitsComparator());
        Traits source = new Traits(0, 0, 0);
        q.add(source);

        //While priority queue is not empty, continue polling out item and checking.
        while ((!q.isEmpty())) {
            Traits item = q.poll();
            if (visited[item.row][item.col] == 0) {
                visited[item.row][item.col] = 1;
                int stackSize = coins[item.row][item.col];
                if(item.heightDiff > height) {
                    height = item.heightDiff;
                }

                //Right neighbour.
                if (!(item.col + 1 > cols - 1)) {
                    if(visited[item.row][item.col + 1] == 0) {
                        int heightDiff = coins[item.row][item.col + 1] - stackSize;
                        if (heightDiff < 0) {
                            heightDiff = 0;
                        }
                        Traits neighbour = new Traits(item.row, item.col + 1, heightDiff);
                        q.add(neighbour);
                    }
                }

                //Bottom neighbour.
                if (!(item.row - 1 < 0)) {
                    if(visited[item.row - 1][item.col] == 0) {
                        int heightDiff = coins[item.row - 1][item.col] - stackSize;
                        if (heightDiff < 0) {
                            heightDiff = 0;
                        }
                        Traits neighbour = new Traits(item.row - 1, item.col, heightDiff);
                        q.add(neighbour);
                    }
                }

                //Left neighbour.
                if (!(item.col - 1 < 0)) {
                    if(visited[item.row][item.col - 1] == 0) {
                        int heightDiff = coins[item.row][item.col - 1] - stackSize;
                        if (heightDiff < 0) {
                            heightDiff = 0;
                        }
                        Traits neighbour = new Traits(item.row, item.col - 1, heightDiff);
                        q.add(neighbour);
                    }
                }

                //Top neighbour.
                if (!(item.row + 1 > rows - 1)) {
                    if(visited[item.row + 1][item.col] == 0) {
                        int heightDiff = coins[item.row + 1][item.col] - stackSize;
                        if (heightDiff < 0) {
                            heightDiff = 0;
                        }
                        Traits neighbour = new Traits(item.row + 1, item.col, heightDiff);
                        q.add(neighbour);
                    }
                }

            }

            //If end point reached, then break out of while loop.
            if(visited[rows - 1][cols - 1] == 1) {
                break;
            }

        }

        //Prints out the height of ladder.
        pw.println(height);


        //Flushes and closes the print writer.
        pw.flush();
        pw.close();
    }
}
