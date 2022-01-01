import java.util.Comparator;

//Comparator to get the smallest height difference.
public class TraitsComparator implements Comparator<Traits> {
    public int compare(Traits t1, Traits t2) {
        if(t1.heightDiff < t2.heightDiff) {
            return -1;
        } else if(t1.heightDiff > t2.heightDiff) {
            return 1;
        } else {
            return 0;
        }
    }
}
