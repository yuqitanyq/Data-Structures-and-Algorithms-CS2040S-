import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Number of incoming names
        int numOfNamesNext = sc.nextInt();
        sc.nextLine();
        while (numOfNamesNext != 0) {
            String[] listOfNames = new String[numOfNamesNext];

            //Store each name in numOfNamesNext
            for (int i = 0; i < numOfNamesNext; i++) {
                listOfNames[i] = sc.nextLine();
            }

            //If first letters are the same, sort names based on second letter;
            //else the names remain in the original position
            Arrays.sort(listOfNames, (x, y) -> x.charAt(0) != y.charAt(0)
                                                    ? x.charAt(0) - y.charAt(0)
                                                    : x.charAt(1) - y.charAt(1));

            //Print each name in the sorted list out
            for (String name : listOfNames) {
                System.out.println(name);
            }

            //Get next integer for incoming new batch
            numOfNamesNext = sc.nextInt();
            sc.nextLine();

            //Between batches of names, leave a line
            //Once the end is reached, don't leave a line
            if (numOfNamesNext != 0) {
                System.out.println("\n");
            }
        }
    }
}
