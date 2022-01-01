import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Initiate scanner and print writer for scanning and printing.
        FastIO fastScanner = new FastIO();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Create arraylist of groups and the AVL.
        //Scan the number of teams and number of events.
        ArrayList<Group> groups = new ArrayList<>();
        AVL storage = new AVL();
        int numOfTeams = fastScanner.nextInt();
        int numOfEvents = fastScanner.nextInt();

        //For each group, create the group and add to the arraylist and the AVL.
        for (int k = 0; k < numOfTeams; k++) {
            Group temp = new Group(k + 1);
            groups.add(temp);
            storage.insert(temp);
        }

        //For each event, delete the group from avl, update the score for that group and add back to AVL.
        //Print the rank of the group 1 at the end of each iteration.
        //group 1 has index 0;
        for (int a = 0; a < numOfEvents; a++) {
            int teamNum = fastScanner.nextInt();
            int penalty = fastScanner.nextInt();
            storage.delete(groups.get(teamNum - 1));
            groups.set(teamNum - 1, groups.get(teamNum - 1).modifyScore(penalty));
            storage.insert(groups.get(teamNum - 1));
            int rank = storage.rank(groups.get(0), numOfTeams);
            pw.println(rank);
        }

        pw.flush();
        pw.close();
    }
}
