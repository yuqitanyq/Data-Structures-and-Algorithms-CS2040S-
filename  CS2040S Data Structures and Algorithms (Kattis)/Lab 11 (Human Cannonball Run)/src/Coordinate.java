public class Coordinate {
    //Attributes, x and y coordinates.
    double x;
    double y;

    //Constructor.
    Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Distance between this current point and another point, temp.
    double distanceTo(Coordinate temp) {
       double dist = Math.sqrt(Math.pow((this.x - temp.x), 2) + Math.pow((this.y - temp.y), 2));
       return dist;
    }
}
