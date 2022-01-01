/*Work station has 2 attributes, the start and the end of the grace period.*/
public class WorkStation {
    int startGracePeriod;
    int endGracePeriod;

    WorkStation(int startGracePeriod, int endGracePeriod) {
        this.startGracePeriod = startGracePeriod;
        this.endGracePeriod = endGracePeriod;
    }

    //Setter to update start of the grace period.
    void setStartGracePeriod(int input) {
        this.startGracePeriod = input;
    }

    //Setter to update end of the grace period.
    void setEndGracePeriod(int input) {
        this.endGracePeriod = input;
    }
}
