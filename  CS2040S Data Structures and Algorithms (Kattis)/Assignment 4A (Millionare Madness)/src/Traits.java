public class Traits {
    //Attributes of the Trait object.
    int row;
    int col;
    int heightDiff;

    //Constructor for the Traits object.
    Traits(int row, int col, int heightDiff) {
        this.row = row;
        this.col = col;
        this.heightDiff = heightDiff;
    }

    //String representation of the Traits object, for debugging purposes.
    @Override
    public String toString() {
        return "[" + this.row + "," + this.col + "]";
    }
}
