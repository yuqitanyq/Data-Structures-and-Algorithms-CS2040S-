//Edge class to represent an edge.
public class Edge {
    //Attributes of an edge.
    int beginIndex;
    int endIndex;
    int weight;

    //Constructor of an edge.
    Edge(int beginIndex, int endIndex, int weight) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.weight = weight;
    }

    //String representation of an edge, for debugging purposes.
    @Override
    public String toString() {
        return "[" + this.beginIndex + ", " + this.endIndex + ", " + this.weight + "]";
    }
}
