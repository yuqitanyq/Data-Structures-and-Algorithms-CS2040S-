import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        //Create scanner and scan the rows, columns.
        FastIO fastScanner = new FastIO();
        int rows = fastScanner.nextInt();
        int cols = fastScanner.nextInt();

        //Create the visited and data arrays, to store state of visitation and the letter in each grid.
        //Counter to count number of islands.
        int[][] visited = new int[rows][cols];
        char[][] data = new char[rows][cols];
        int count = 0;

        for(int r = 0; r < rows; r++) {
            String line = fastScanner.next();
            for (int c = 0; c < cols; c++) {
                visited[r][c] = 0;
                data[r][c] = line.charAt(c);
            }
        }

        //If letter in grid is 'L' then do breadth first search on that grid, else ignore.
        //Print count at the end.
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(visited[r][c] == 0) {
                    Index index = new Index(r, c);
                    if(data[r][c] == 'L') {
                        count = count + 1;
                        LinkedList<Index> q = new LinkedList<>();
                        q.add(index);

                        while (!q.isEmpty()) {
                            Index temp = q.poll();
                            if (visited[temp.row][temp.col] == 0) {
                                visited[temp.row][temp.col] = 1;
                                char item = data[temp.row][temp.col];
                                if (item != 'W') {
                                    if (!(temp.col + 1 > cols - 1)) {
                                        Index obj = new Index(temp.row, temp.col + 1);
                                        q.add(obj);
                                    }

                                    if (!(temp.row + 1 > rows - 1)) {
                                        Index obj = new Index(temp.row + 1, temp.col);
                                        q.add(obj);
                                    }

                                    if (!(temp.col - 1 < 0)) {
                                        Index obj = new Index(temp.row, temp.col - 1);
                                        q.add(obj);
                                    }

                                    if (!(temp.row - 1 < 0)) {
                                        Index obj = new Index(temp.row - 1, temp.col);
                                        q.add(obj);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
