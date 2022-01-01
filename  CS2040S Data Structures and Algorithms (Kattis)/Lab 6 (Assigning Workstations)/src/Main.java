import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) {
        //Counter to count number of unlocks saved.
        int counter = 0;

        /*Initiate fast scanner and scan the first line of inputs.
        Mainly: number of researchers and the inactivity time.*/
        FastIO fastScanner = new FastIO();
        int numOfResearcher = fastScanner.nextInt();
        int inactivity = fastScanner.nextInt();

        //Create 2 priority queues, each to store the researchers and work stations respectively.
        PriorityQueue<Researcher> researcherQueue = new PriorityQueue<Researcher>((x, y) -> x.arrivalTime - y.arrivalTime);
        PriorityQueue<WorkStation> stationQueue = new PriorityQueue<WorkStation>((a, b) -> a.endGracePeriod - b.endGracePeriod);

        //Create researchers and add them into the researcher queue.
        for(int i = 0; i < numOfResearcher; i++) {
            int tempArrTime = fastScanner.nextInt();
            int tempStayTime = fastScanner.nextInt();
            researcherQueue.add(new Researcher(tempArrTime, tempStayTime));
        }

        //Repeat until all researchers have been accounted for.
        while (researcherQueue.size() != 0) {
            //Poll the researcher that has earliest arrival time, then calculate the start and end of grace period.
            Researcher temp = researcherQueue.poll();
            int start = temp.arrivalTime;
            int end = temp.stayTime;
            int total = start + end;
            if(stationQueue.size() == 0) {
                /*Create new workstation and pass in the start and end of grace period,
                and add station into station queue.*/
                WorkStation workStation = new WorkStation(total, total + inactivity);
                stationQueue.add(workStation);
            } else {
                //Repeat until the current researcher has a work station to work in.
                while (stationQueue.size() != 0) {
                    WorkStation existing = stationQueue.peek();

                    /*If arrival time is within grace period, update the work station timings, increment counter,
                    and add back into station queue.
                    Else if arrival time is earlier than start of grace period, create new work station and add
                    to the station queue.
                    Else if arrival time is later than end of grace period, just poll the work station.*/
                    if (temp.arrivalTime >= existing.startGracePeriod && temp.arrivalTime <= existing.endGracePeriod) {
                        stationQueue.poll();
                        existing.setStartGracePeriod(total);
                        existing.setEndGracePeriod(total + inactivity);
                        counter++;
                        stationQueue.add(existing);
                        break;
                    } else if(temp.arrivalTime < existing.startGracePeriod) {
                        WorkStation workStation = new WorkStation(total, total + inactivity);
                        stationQueue.add(workStation);
                        break;
                    } else if(temp.arrivalTime > existing.endGracePeriod) {
                        stationQueue.poll();
                    }
                }
            }
        }
        //Print out the counter.
        System.out.println(counter);
    }
}
