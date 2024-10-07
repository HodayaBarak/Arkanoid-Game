package GeometryPrimitives;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-04-13
 * Class GeometryPrimitives.Point gets X value and Y value and create a new point (X,Y).
 * it also checks the distance between two points and if the points
 * are equals.
 */

public class Point {


    //define variables for the point`s values.
    private double x;
    private double y;
    private static final double EPSILON = 0.0001;

    // constructor
    /**
     * constructor
     * <p>
     * create new object 'GeometryPrimitives.Point' and assigns the x,y values that the
     * class GeometryPrimitives.Point gets in its fields.
     * </p>
     * @param x Description: a given x value.
     * @param y Description: a given y value.
     *
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * distance Method
     * <p>
     * distance Method gets two GeometryPrimitives.Point type objects and calculate
     * the distance between them by using the distance calculation
     * formula.
     * </p>
     * @param other Description: a given point that we can calculate the distance between it
     *              and another point.
     * @return double. */
    public double distance(Point other) {
        double x1 = this.x;
        double y1 = this.y;
        if (other == null) {
            return 0;
        }
        // distance -- return the distance of this point to the other point
        return (double) Math.sqrt(Math.pow(other.x - x1, 2) + Math.pow(other.y - this.y, 2));
    }

    /**
     * equals Method
     * <p>
     * equals Method gets two GeometryPrimitives.Point type objects and checks if
     * the points are equal by compare their x,y values.
     * </p>
     * @param other Description: a given point that we can compare between its
     *              values and another point.
     * @return boolean. */
    public boolean equals(Point other) {
        this.x = this.getX();
        this.y = this.getY();
        other.x = other.getX();
        other.y = other.getY();
        if (Math.abs(this.x - other.x) <= EPSILON) {
            this.x = other.x;
        }
        if (Math.abs(this.y - other.y) <= EPSILON) {
            this.y = other.y;
        }
        // equals -- return true is the points are equal, false otherwise
        return ((this.x == other.x) && (this.y == other.y));
    }

    /**
     * equalsY Method.
     * <p>
     * equalsY Method returns true is the y`s values are equal, false otherwise.
     * </p>
     * @param y Description: a point`s y value that compared to other point`s y value.
     * @return boolean. */

    public boolean equalsY(double y) {
        this.y = this.getY();
        double otherY = y;

        if (Math.abs(this.y - otherY) <= EPSILON) {
            this.y = otherY;
        }
        // equals -- return true is the y`s values are equal, false otherwise
        return  (this.y == otherY);
    }

    /**
     * equalsX Method.
     * <p>
     * equalsX Method returns true is the x`s values are equal, false otherwise.
     * </p>
     * @param x Description: a point`s x value that compared to other point`s x value.
     * @return boolean. */
    public boolean equalsX(double x) {
        this.x = this.getX();
        double otherX = x;

        if (Math.abs(this.x - otherX) <= EPSILON) {
            this.x = otherX;
        }
        // equals -- return true is the x`s values are equal, false otherwise
        return  (this.x == otherX);
    }
    /**
     * getX Method
     * <p>
     * getX Method returns the value of x of a given point.
     * </p>
     * @return double. */
    public double getX() {
        return this.x;
    }

    /**
     * getY Method
     * <p>
     * getY Method returns the value of y of a given point.
     * </p>
     * @return double. */
    public double getY() {
        return this.y;
    }

    /**
     * setX Method
     * <p>
     * setX Method updates the x`s value of the point
     * and returns it.
     * </p>
     * @param x Description: updated x value of the point.
     * @return double. */
    public double setX(double x) {
        this.x = x;
        return this.x;
    }
    /**
     * setY Method
     * <p>
     * setY Method updates the y`s value of the point
     * and returns it.
     * </p>
     * @param y Description: updated y value of the point.
     * @return double. */
    public double setY(double y) {
        this.y = y;
        return this.y;
    }

    /**
     * comparePoint Method
     * <p>
     * comparePoint Method compare between x,y`s values of one point to
     * x,y`s values of another point. if one point`s x,y values bigger than
     * the other point, the method returns true. otherwis, false.
     * and returns it.
     * </p>
     * @param other Description: a given point that the method compares between its
     *      *              x,y`s values and another point`s x,y values.
     * @return boolean. */
    public boolean comparePoint(Point other) {
        double x1 = this.x;
        double y1 = this.y;
        double x2 = other.getX();
        double y2 = other.getY();

        return  ((x1 >= x2) && (y1 >= y2));


    }




}
