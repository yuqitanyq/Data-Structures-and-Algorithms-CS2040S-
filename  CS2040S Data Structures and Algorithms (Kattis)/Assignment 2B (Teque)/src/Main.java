import java.io.*;
public class Main {
    public static void main(String[] args) {
        //FastScanner is for scanning inputs fast
        FastIO fastScanner = new FastIO();

        //Number of operations on the Teque
        int numOfOps = fastScanner.nextInt();
        Teque structure = new Teque();

        //PrintWriter is for printing fast later on
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for(int i = 0; i < numOfOps; i++) {
            //Scan the commands and the input integer
            String command = fastScanner.next();
            int item = fastScanner.nextInt();

            //Matches respective Teque method calls depending on commands received from input
            if(command.equals("push_back")) {
                structure.pushBack(item);
            } else if(command.equals("push_front")) {
                structure.pushFront(item);
            } else if(command.equals("push_middle")) {
                structure.pushMiddle(item);
            } else if(command.equals("get")) {
                pw.println(structure.get(item));
            }

            //Rebalances the two underlying hashmaps in the Teque structure
            //This is to ensure both hashmaps are of the correct size after each iteration
            structure.rebalance();
        }

        //Flushes and closes the print writer
        pw.flush();
        pw.close();
    }
}
