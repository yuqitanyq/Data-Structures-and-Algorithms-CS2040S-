import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Initialize fast scanner
        FastIO fastScanner = new FastIO();

        //Total number of frosh in input
        int numOfFrosh = fastScanner.nextInt();

        /*Initialize hashmap with arraylist of combination for each student as key
         and frequency of combination as value*/
        HashMap<ArrayList<Integer>, Integer> tracker = new HashMap<>();
        int maxFreq = 0;
        int totalStudents = 0;

        for (int i = 0; i < numOfFrosh; i++) {
            ArrayList<Integer> combination = new ArrayList<>();

            //Store the combination for each frosh in an arraylist
            for (int j = 0; j < 5; j++) {
                combination.add(fastScanner.nextInt());
            }

            //Sort the arraylist
            Collections.sort(combination);

            /*If combination is already inside tracker, update frequency
            by adding 1 to the frequency
            else insert the new key value pair inside the tracker,
            with frequency initialized as 1*/
            if (tracker.containsKey(combination)) {
                tracker.replace(combination, tracker.get(combination) + 1);
            } else {
                tracker.put(combination, 1);
            }

            //Find the max frequency out of all combinations
            if (tracker.get(combination) > maxFreq) {
                maxFreq = tracker.get(combination);
            }
        }

        /*For each mapping, if the frequency is equal to the max mapping,
        then add the frequency to the total number of students*/
        for (Map.Entry<ArrayList<Integer>, Integer> mapping : tracker.entrySet()) {
            if (mapping.getValue() == maxFreq) {
                totalStudents += mapping.getValue();
            }
        }

        //Print out the total number of students taking most popular combination
        System.out.println(totalStudents);
    }
}

/*Note: Arraylist works in this case because of the hashcode being dependent on the
items inside the arraylist. If items are the same for two arraylists, then they
will have the same reference. Arrays on the other hand, have their
hashcode as their memory addresses, so it won't work in this case.*/