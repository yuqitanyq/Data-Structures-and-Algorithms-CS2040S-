import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
	    FastIO fastScanner = new FastIO();
	    int numOfSyllables = fastScanner.nextInt();
	    int numOfPlayers = fastScanner.nextInt();
        LinkedList<Hand> listOfHands = new LinkedList<>();

        /*Instantiate a Linked List of hand objects with player number and type of hand
        as attributes.
        type 0: folded
        type 1: fist
        type 2: palm
        Initially, all hand types are folded.(type 0)
         */
        for(int i = 0; i < numOfPlayers; i++) {
            int playerNum = i + 1;
            listOfHands.add(new Hand(playerNum, 0));
        }

        /* Repeat the game cycle until one hand is left */
        while (listOfHands.size() > 1) {

            //Simulation of counting off
            for (int j = 0; j < numOfSyllables - 1; j++) {
                Hand first = listOfHands.removeFirst();
                listOfHands.addLast(first);
            }

            //Remove the chosen hand after the rhyme has finished
            Hand currHand = listOfHands.removeFirst();
            int currType = currHand.getType();
            int currPlayer = currHand.getPlayer();

            //If card chosen is folded, split into two fist
            //else if card chosen is a fist, update it to be a palm
            //else it's a palm and removal is necessary
            if (currType == 0) {
                listOfHands.addFirst(new Hand(currPlayer, 1));
                listOfHands.addFirst(new Hand(currPlayer, 1));
            } else if (currType == 1) {
                listOfHands.addLast(new Hand(currPlayer, 2));
            }
        }
        
        //Print out winner
        int winner = listOfHands.getFirst().getPlayer();
        System.out.println(winner);
    }
}
