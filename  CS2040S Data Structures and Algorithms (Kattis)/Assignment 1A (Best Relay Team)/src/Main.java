public class Main {
    public static void main(String[] args) {
        double totalTiming = 80;
        String [] finalOutput = new String[4];
        FastIO fastScanner = new FastIO();
        int numOfRunners = fastScanner.nextInt();
        Runner[] runners = new Runner[numOfRunners];

        //Store all the scanned inputs in an array as runner objects
        for (int i = 0; i < numOfRunners; i++) {
            String name = fastScanner.next();
            double firstTime = fastScanner.nextDouble();
            double secondTime = fastScanner.nextDouble();
            runners[i] = new Runner(name, firstTime, secondTime);
        }

        /*Sort the runners from fastest to slowest in the runners
        array according to second timing*/
        for(int j = 1; j < numOfRunners; j++) {
            Runner next = runners[j];
            double t1 = next.getSecondTiming();
            int k;
            for(k = j - 1; k >= 0 && runners[k].getSecondTiming() > t1; k--) {
                runners[k + 1] = runners[k];
            }
                runners[k + 1] = next;
        }

        /*for each of the runner in the list,
        try each runner as first runner and find next best 3 runners*/
        for(int m = 0; m < numOfRunners; m++) {
            Runner currRunner = runners[m];
            String name = currRunner.getName();
            double newTotalTime = 0;
            double firstTime = currRunner.getFirstTiming();
            newTotalTime += firstTime;
            String[] newOutput = new String[4];
            newOutput[0] = name;

            //if m < 3, next best 3 runners will be within the first 4 names in the list
            if(m < 3) {
                int counter = 1;
                for(int n = 0; n < 4 && counter < 5; n++) {
                    if(n != m) {
                        newTotalTime += runners[n].getSecondTiming();
                        newOutput[counter] = runners[n].getName();
                        counter++;
                    }
                }

            //else the nest best 3 will be the first 3 names in the list
            } else {
                newTotalTime += runners[0].getSecondTiming() +
                        runners[1].getSecondTiming() + runners[2].getSecondTiming();
                newOutput[1] = runners[0].getName();
                newOutput[2] = runners[1].getName();
                newOutput[3] = runners[2].getName();
            }

            /*if current total time < totalTiming, update totalTiming
             and newOutput of names*/
            if(newTotalTime < totalTiming) {
                totalTiming = newTotalTime;
                for(int p = 0; p < 4; p++) {
                    finalOutput[p] = newOutput[p];
                }
            }
        }

        //print out timing and names
        System.out.println(totalTiming);
        for(int q = 0; q < 4; q++) {
            System.out.println(finalOutput[q]);
        }
    }
}
