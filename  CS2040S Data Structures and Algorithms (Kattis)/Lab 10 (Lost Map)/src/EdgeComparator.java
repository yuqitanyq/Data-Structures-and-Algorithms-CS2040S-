import java.util.Comparator;

//Comparator to compare the edges, smaller edges come first.
public class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge e1, Edge e2) {
        if(e1.weight < e2.weight) {
            return - 1;
        } else if(e1.weight > e2.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}
