import java.util.Comparator;

//Comparator to compare which group is better in ranking.
/* First compare based on number of questions solved,
then compare based on total penalty incurred. If both are the same,
compare based on team number as tie breaker.
 */
public class GroupComparator implements Comparator<Group> {
    public int compare(Group G1, Group G2) {
        if(G1.totalSolved() > G2.totalSolved()) {
            return -1;
        } else if(G1.totalSolved() < G2.totalSolved()) {
            return 1;
        } else {
            if(G1.totalPenalty() < G2.totalPenalty()) {
                return -1;
            } else if(G1.totalPenalty() > G2.totalPenalty()) {
                return 1;
            } else {
                if(G1.teamNum < G2.teamNum) {
                    return -1;
                } else if(G1.teamNum > G2.teamNum){
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
