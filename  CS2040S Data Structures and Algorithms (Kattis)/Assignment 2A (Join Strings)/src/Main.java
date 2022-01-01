public class Main {

    public static void main(String[] args) {
        FastIO fastScanner = new FastIO();
        int numOfStrings = fastScanner.nextInt();

        //Instantiate an array of TailedLinkedList of size numOfStrings
        TailedLinkedList[] tracker = new TailedLinkedList[numOfStrings];

        //Create the linked lists to store each string for each spot in the array
        for (int i = 0; i < numOfStrings; i++) {
            TailedLinkedList individual = new TailedLinkedList();
            individual.addFront(fastScanner.nextLine());
            tracker[i] = individual;
        }

        //For N-1 pairs, concatenate the strings in O(1) time using .append method
        int finalIndex = 0;
        for (int j = 0; j < numOfStrings - 1; j++) {
            int leftIndex = fastScanner.nextInt() - 1;
            int rightIndex = fastScanner.nextInt() - 1;
            tracker[leftIndex].append(tracker[rightIndex]);
            if(j == numOfStrings - 2) {
                //Keep track of final index that has all the strings
                finalIndex = leftIndex;
            }
        }

        //Print the string out
        tracker[finalIndex].print();
    }
}