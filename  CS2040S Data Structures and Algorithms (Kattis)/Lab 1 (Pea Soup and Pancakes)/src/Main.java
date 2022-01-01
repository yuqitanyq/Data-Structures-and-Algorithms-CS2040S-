import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        boolean peasCheck = false;
        boolean pancakeCheck = false;

        for (int i = 0; i < n; i++) {
            peasCheck = false;
            pancakeCheck = false;
            int k = sc.nextInt();
            sc.nextLine();
            String resName = sc.nextLine();

            for (int j = 0; j < k; j++) {
                String menuItem = sc.nextLine();
                if (menuItem.equals("pea soup")) {
                    peasCheck = true;
                } else if (menuItem.equals("pancakes")) {
                    pancakeCheck = true;
                }
                if (peasCheck && pancakeCheck) {
                    System.out.println(resName);
                    break;
                }
            }

            if(peasCheck && pancakeCheck) {
                break;
            }
        }

        if (!peasCheck || !pancakeCheck) {
            System.out.println("Anywhere is fine I guess");
        }
    }
}
