import java.util.HashMap;
public class Teque {
    //Simulated 4 trackers, 2 for each half of the entire teque
    //The front of both hashmaps start from -1 so as to avoid clashing with back of respective hashmaps
    int firstHalfFront = -1;
    int firstHalfBack = 0;
    int secondHalfFront = -1;
    int secondHalfBack = 0;
    HashMap<Integer, Integer> firstHalf = new HashMap<>();
    HashMap<Integer, Integer> secondHalf = new HashMap<>();

    //Adds item to the end of the Teque
    //This is equivalent to adding to the back of the secondHalf hashmap.
    public void pushBack(int item) {
        secondHalf.put(secondHalfBack, item);
        secondHalfBack++;
    }

    //Adds item to the front of the Teque
    //This is equivalent to adding to the front of the firstHalf hashmap.
    public void pushFront(int item) {
        firstHalf.put(firstHalfFront, item);
        firstHalfFront--;
    }

    //Adds item to the middle of the Teque
    //If firstHalf hashmap is smaller than secondHalf hashmap, then put the item at the back of firstHalf.
    //Else put item at the front of the secondHalf hashmap
    public void pushMiddle(int item) {
        if(firstHalf.size() < secondHalf.size()) {
            firstHalf.put(firstHalfBack, item);
            firstHalfBack++;
        }else {
            secondHalf.put(secondHalfFront, item);
            secondHalfFront--;
        }
    }

    //Rebalances the two hashmaps at each step so that the pushMiddle method works
    /*If the total number of items in both hashmap is odd, then it is expected for one hashmap
    to have one item more than the other hashmap*/
    //Only if the difference is more than 1, rebalancing is required.
    //This is because pushMiddle will consider adding to firstHalf first.
    //Else if secondHalf is bigger than firstHalf, rebalancing is required as well
    public void rebalance() {
        int firstHalfSize = firstHalf.size();
        int secondHalfSize = secondHalf.size();
        if(firstHalfSize - secondHalfSize > 1) {
            secondHalf.put(secondHalfFront, firstHalf.get(firstHalfBack - 1));
            secondHalfFront--;

            firstHalfBack--;
            firstHalf.remove(firstHalfBack);
        } else if(secondHalfSize > firstHalfSize) {
            firstHalf.put(firstHalfBack, secondHalf.get(secondHalfFront + 1));
            firstHalfBack++;

            secondHalfFront++;
            secondHalf.remove(secondHalfFront);
        }
    }

    //Get item by accounting for the index positions since pointers start at -1 and 0 for front and back
    //Returns the item to be printed by print writer in Main.java
    public int get(int index) {
        if(index < firstHalf.size()) {
            return firstHalf.get(index + firstHalfFront + 1);
        } else {
            return secondHalf.get(index - firstHalf.size() + secondHalfFront + 1);
        }
    }
}
