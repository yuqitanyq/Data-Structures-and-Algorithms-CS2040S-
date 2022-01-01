public class Main {
    public static void main(String[] args) {
        String[] keyPress = new String[256];
        keyPress['a'] = "2";
        keyPress['b'] = "22";
        keyPress['c'] = "222";
        keyPress['d'] = "3";
        keyPress['e'] = "33";
        keyPress['f'] = "333";
        keyPress['g'] = "4";
        keyPress['h'] = "44";
        keyPress['i'] = "444";
        keyPress['j'] = "5";
        keyPress['k'] = "55";
        keyPress['l'] = "555";
        keyPress['m'] = "6";
        keyPress['n'] = "66";
        keyPress['o'] = "666";
        keyPress['p'] = "7";
        keyPress['q'] = "77";
        keyPress['r'] = "777";
        keyPress['s'] = "7777";
        keyPress['t'] = "8";
        keyPress['u'] = "88";
        keyPress['v'] = "888";
        keyPress['w'] = "9";
        keyPress['x'] = "99";
        keyPress['y'] = "999";
        keyPress['z'] = "9999";
        keyPress[' '] = "0";

        FastIO fastScanner = new FastIO();
        int cases = fastScanner.nextInt();
        StringBuilder finalOutput = new StringBuilder("");

            for(int i = 0; i < cases; i++) {
                int previousGroup = -1;
                StringBuilder output = new StringBuilder("Case #").append(i + 1).append(": ");
                String nextEntry = fastScanner.nextLine();
                int lengthOfLine = nextEntry.length();

                    for(int j = 0; j < lengthOfLine; j++) {
                        char letter = nextEntry.charAt(j);
                        char currentGroup = keyPress[letter].charAt(0);
                        if(currentGroup == previousGroup) {
                            output.append(" ");
                        }
                        output.append(keyPress[letter]);
                        previousGroup = currentGroup;
                    }
                output.append("\n");
                finalOutput.append(output);
            }
        System.out.print(finalOutput);
    }
}
