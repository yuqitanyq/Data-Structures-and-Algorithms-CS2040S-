import java.io.*;

public class Main {
    public static void main(String[] args) {
        //FastScanner is for scanning inputs fast
        FastIO fastScanner = new FastIO();

        //PrintWriter is for printing fast later on
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Scanned the number of items to be added and the number of drawers given.
        //Create an instance of the Union Find Disjoint Set
        int numOfItems = fastScanner.nextInt();
        int numOfDrawers = fastScanner.nextInt();
        UnionFind drawerSet = new UnionFind(numOfDrawers);

        /* For each item, union the two drawers to be tried.
        Check if the item can be added or not. If can add,
        print "LADICA". Else print "SMECE".*/
        for(int i = 0; i < numOfItems; i++) {
            int index1 = fastScanner.nextInt() - 1;
            int index2 = fastScanner.nextInt() - 1;
            drawerSet.unionSet(index1, index2);
            int parent = drawerSet.findSet(index1);
            if(drawerSet.canAddOrNot(parent)) {
                pw.println("LADICA");
                drawerSet.addedItem(parent);
            } else {
                pw.println("SMECE");
            }
        }

        //Flushes and closes the print writer
        pw.flush();
        pw.close();
    }
}
