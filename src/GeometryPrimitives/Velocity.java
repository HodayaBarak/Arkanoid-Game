package GeometryPrimitives;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-04-21
 * Class GeometryPrimitives.Velocity specifies the change in position on the `x` and the `y` axes.
 *
 */


public class Velocity {

    //define variables for the velocity`s values.
    private double dx1, dy1;
    private double x1, y1;
    private Velocity velocity;

    // constructor
    /**
     * constructor
     * <p>
     * create new object 'GeometryPrimitives.Velocity' and assigns the dx,dy values that the
     * class GeometryPrimitives.Velocity gets in its fields.
     * </p>
     * @param dx Description: the change in position in the horizontal direction
     *          (the change in position in the x-direction).
     * @param dy Description: the change in position in the vertical direction
     *               (the change in position in the y-direction).
     */
    public Velocity(double dx, double dy) {
        this.dx1 = dx;
        this.dy1 = dy;
    }

    /**
     * getVelocityX
     * getDx Method
     * <p>
     * getVelocityX Method returns the dx`s value of the velocity.
     * </p>
     * @return double. */
    public double getDx() {
        return this.dx1;
    }

    /**
     * getVelocityY
     * getDy Method
     * <p>
     * getVelocityY Method returns the dy`s value of the velocity.
     * </p>
     * @return double. */
    public double getDy() {
        return this.dy1;
    }


    /**
     * setVelocity Method
     * <p>
     * The method creates a new velocity object from giving values and returns it.
     * </p>
     * @param dx Description: the change in position in the horizontal direction
     *           (the change in position in the x-direction).
     * @param dy Description: the change in position in the vertical direction
     *           (the change in position in the y-direction).
     * @return GeometryPrimitives.Velocity. */
    public Velocity setVelocity(double dx, double dy) {
        //assign the values to the dx,dy fields
        this.dx1 = dx;
        this.dy1 = dy;
        // create a new velocity object and return it
        return new Velocity(dx1, dy1);
    }

    /**
     * setVelocity Method
     * <p>
     * The method sets a new given velocity to the ball`s velocity field.
     * </p>
     * @param velocity Description:  the velocity to set
     * @return GeometryPrimitives.Velocity. */
    public Velocity setVelocity(Velocity velocity) {
        //assign the values to the dx,dy fields
        this.velocity = velocity;
        // create a new velocity object and return it
        return velocity;
    }

    /**
     * applyToPoint Method
     * <p>
     * The method Takes a point with position (x,y), creates a new point object with position (x+dx, y+dy)s
     * and returns it.
     * </p>
     * @param p Description: a given point with position (x,y)
     * @return GeometryPrimitives.Point. */

    public Point applyToPoint(Point p) {
        //assign the values to the x,y fields
        this.x1 = p.getX();
        this.y1 = p.getY();
        // create a new GeometryPrimitives.Point object and return it
        return new Point(this.x1 + this.dx1, this.y1 + this.dy1);

    }

    /**
     * fromAngleAndSpeed Method
     * <p>
     * The method gets angle and speed values and convert it to double type using Math.
     * then, it creates new velocity object from the values and returns it.
     * </p>
     * @param angle Description: Angle size
     * @param speed Description: the change in position in the horizontal direction
     * @return GeometryPrimitives.Point. */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {

        double dx =   speed * Math.sin(Math.toRadians(angle));
        double dy  = -(speed * Math.cos(Math.toRadians(angle)));

        return new Velocity(dx, dy);
    }
}