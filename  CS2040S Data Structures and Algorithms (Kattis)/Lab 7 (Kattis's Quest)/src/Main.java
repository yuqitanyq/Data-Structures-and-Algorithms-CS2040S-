import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {
    	//Initialize scanner and scan the number of commands.
		//Initialize count for identification of each quest.
	    FastIO fastScanner = new FastIO();
	    long numOfCommands = fastScanner.nextLong();
		long count = 0L;

	    //Initialize tracker Treeset which takes in a Quest object.
        TreeSet<Quest> tracker = new TreeSet<>();

        /*For each command, if add command, create new Quest object based on data and add
        * to the tracker. If query command, find the Quest required. From the quest,
        * add the gold amount to sum. Subtract energy level from query. Repeat until query
        * goes to 0 or there is no other quest that Kattis can embark on.
        * */
	    for(int i = 0; i < numOfCommands; i++) {
	        String command = fastScanner.next();
	        //System.out.println(command);
	        if(command.equals("add")) {
	            long energy = fastScanner.nextLong();
	            long reward = fastScanner.nextLong();
	            count += 1;
	            long id = count;
				//System.out.println(energy + " " + reward + " " + id);
	            Quest newQuest = new Quest(energy, reward, id);
	            tracker.add(newQuest);
            } else {
	            long query = fastScanner.nextLong();
	            //System.out.println("queries: " + query + " ");
	            long sum = 0L;
	            while (query > 0) {
	                long maxReward = Long.MAX_VALUE;
	                long maxId = Long.MAX_VALUE;
	                Quest placeholder = new Quest(query, maxReward, maxId);
	                Quest temp = tracker.floor(placeholder);
	                if(temp == null) {
	                    break;
                    } else {
						if (query - temp.getEnergy() < 0) {
							query = query - temp.getEnergy();
						} else {
							query = query - temp.getEnergy();
							sum += temp.getGold();
							tracker.remove(temp);
						}
					}
	                //System.out.println(query + " ");
                }
	            //Print out sum, which is the total gold earned.
	            System.out.println(sum);
            }
        }
    }
}
