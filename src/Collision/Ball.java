package Collision;

import Game.GameEnvironment;
import GeometryPrimitives.Line;
import GeometryPrimitives.Point;
import GeometryPrimitives.Velocity;
import biuoop.DrawSurface;
import Game.GameLevel;
import java.awt.Color;
import java.util.ArrayList;


//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-04-13
 * Class collision.Ball creates a ball from a given center point, radius and color.
 * it defines the ball`s velocity depend on its radius and moves it along a given field without
 * out of its boundirias.
 *
 */
public class  Ball implements Sprite, HitNotifier {
    //define variables.
    private static final int RADIUSMAX = 50;
    private static final int FOUR = 4;
    private static final int ZERO = 0;
    private Point center;
    private final int radius;
    private final Color color;
    private Velocity v1;
    private GameEnvironment environment;
    private final int sWidth = 0;
    private final int eWidth = 400;
    private final int sHight = 0;
    private final int eHight = 400;
    private final double slowSpeedX = 3;
    private final double slowSpeedY = 3;
    private Ball ball;
    private ArrayList<HitListener> hitListeners = new ArrayList<HitListener>();

    /**
     * constructor
     * <p>
     * creates new collision.Ball object and assigns the center point, radius and color values that the
     * class GeometryPrimitives.Point gets in its fields.
     * the contructor also creates the velocity of the ball using its radius.
     * </p>
     *
     * @param center Description: the ball`s center point.
     * @param r  Description: the ball`s radius.
     * @param color Description: the ball`s color.
     */
    // constructor
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.environment = new GameEnvironment();

//        //if the radius = 0 - the ball`s velotity is (0,0)
//        if (this.radius == ZERO) {
//            this.v1 = new Velocity(ZERO, ZERO);
//            // if the radious bigger then 50 - the ball`s velotity is constant values - (3,3)
//        } else if (Math.abs(this.radius) > RADIUSMAX) {
//            this.v1 = new Velocity(slowSpeedX, slowSpeedY);
//            // The velocity is determined by the radius of the ball
//            // The larger the radius, the lower the velocity (because the dx,dy values are determined by
//            // dividing a constant number by the radius. The larger the radius,
//            // the larger the denominator and the smaller the resulting dx,dy values)
//        } else {
//            this.v1 = new Velocity(((double) RADIUSMAX / Math.abs(this.radius) + FOUR),
//                    ((double) RADIUSMAX / Math.abs(this.radius) + FOUR));
//        }
//        this.environment = new GameEnvironment();

    }




    /**
     * constructor
     * <p>
     * creates new object 'collision.Ball' and assigns the radius and color values that the
     * class GeometryPrimitives.Point gets in its fields. it also creates a new GeometryPrimitives.Point
     * object from the given x,y values to and assign it in the center field.
     * the contructor also creates the velocity of the ball using its radius.
     * </p>
     * @param x Description: the center`s x value.
     * @param y Description: the center`s y value.
     * @param r Description: the ball`s radius.
     * @param color Description: the ball`s color.
     */
    public Ball(double x, double y, int r, Color color) {
        this.radius = r;
        this.color = color;
        center = new Point(x, y);
        //this.v1 = new Velocity(6, 3);
    }
    // accessors
    /**
     * getX Method
     * <p>
     * getX Method returns the center`s x value.
     * </p>
     * @return int.
     */
    public double getX() {
        return center.getX();
    }


    /**
     * addToGame Method
     * <p>
     * addToGame Method gets a game object and add the ball to the sprite list.
     * </p>
     *
     * @param game Description: Game.GameLevel object that holds the sprites and the collidables.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }


    /**
     * getY Method
     * <p>
     * getX Method returns the center`s y value.
     * </p>
     *
     * @return int.
     */
    public double getY() {
        return center.getY();
    }

    /**
     * getSize Method
     * <p>
     * getSize Method returns the ball`s radius value.
     * </p>
     *
     * @return int.
     */
    public int getSize() {
        return radius;
    }

    /**
     * getColor Method
     * <p>
     * getColor Method returns the ball`s color.
     * </p>
     *
     * @return java.awt.Color.
     */
    public Color getColor() {
        return color;
    }


    /**
     * drawOn Method
     * <p>
     * drawOn Method gets a surface and draw a ball on top of it.
     * </p>
     * @param surface Description: a given field.
     */
    public void drawOn(DrawSurface surface) {
        // draw the ball on the given DrawSurface
        DrawSurface d = surface;
        d.drawCircle((int) getX(), (int) getY(), getSize());
        d.setColor(getColor());
        d.fillCircle((int) getX(), (int) getY(), getSize());
    }

    /**
     * timePassed Method
     *  <p>
     * timePassed Method updates the state of the sprite that the ball finish moving.
     * </p>
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }


    /**
     * setVelocity Method
     * <p>
     * setVelocity Method gets a velocity object and assign it in the velocity field.
     * </p>
     *
     * @param velocity Description: a given velocity.
     * @return GeometryPrimitives.Velocity.
     */
    public Velocity setVelocity(Velocity velocity) {
        //assign the values to the dx,dy fields
//        this.v1 = velocity;
        this.v1 = new Velocity(velocity.getDx(), velocity.getDy());
        // create a new velocity object and return it
        return velocity;
    }

    /**
     * setVelocity Method
     * <p>
     * setVelocity Method gets a dx,dy values and creates from them a new velocity object.
     * then, update the exist velocity to be the new velocity object
     * </p>
     *
     * @param dx Description: the change in position in the horizontal direction
     *           (the change in position in the x-direction).
     * @param dy Description: the change in position in the vertical direction
     *          (the change in position in the y-direction).
     * @return GeometryPrimitives.Velocity.
     */
    public Velocity setVelocity(double dx, double dy) {
        this.v1 = new Velocity(dx, dy);
        return v1;
    }


    /**
     * getVelocity Method
     * <p>
     * getVelocity Method returns the velocity of the ball.
     * </p>
     * @return GeometryPrimitives.Velocity.
     */
    public Velocity getVelocity() {
        return this.v1;
    }


    /**
     * moveOneStep Method
     * <p>
     * moveOneStep Method checks if a ball touches the boundaries of the field by
     * checking the field`s start and end point (minimun x,y values and maximum x,y values), and checking if
     * by adding/subtract the ball`s center point, its radius and its velocity`s x,y values,and checking if
     * the resulting result is bigger/smaller then the maximun/minimum point's values.
     * </p>
     *
     * @param minX Description: The x value of the starting point of the field.
     * @param minY Description: The y value of the starting point of the field.
     * @param maxX Description: The x value of the ending point of the field.
     * @param maxY Description: The y value of the ending point of the field.
     */
    public void moveOneStep(int minX, int minY, int maxX, int maxY) {

        // Check if the ball hits the right border
        if ((int) this.center.getX() + this.getSize() + v1.getDx() > maxX) {
            // Setting the center`s x value so that the ball stays within the boundaries of the field
            this.center.setX(maxX - this.getSize() + this.v1.getDx());
            // Setting the velocity`s dx value so that the direction of movement of the ball will be reversed.
            setVelocity(-this.v1.getDx(), this.v1.getDy());
            // Check if the ball hits the left border
        } else if ((int) this.center.getX() - this.getSize() + v1.getDx() < minX) {
            // Setting the center`s x value so that the ball stays within the boundaries of the field
            this.center.setX(minX + this.getSize());
            // + this.v1.getDx()
            // Setting the velocity`s dx value so that the direction of movement of the ball will be reversed.
            setVelocity(-this.v1.getDx(), this.v1.getDy());
        }

        // Check if the ball hits the top border
        if ((int) this.center.getY() + this.getSize() + v1.getDy() > maxY) {
            // Setting the center`s y value so that the ball stays within the boundaries of the field
            this.center.setY(maxY - this.getSize() + this.v1.getDy());
            // Setting the velocity`s dy value so that the direction of movement of the ball will be reversed.
            setVelocity(this.v1.getDx(), -this.v1.getDy());
            // Check if the ball hits the bottom border
        } else if ((int) this.center.getY() - this.getSize() + v1.getDy() < minY) {
            // Setting the center`s y value so that the ball stays within the boundaries of the field
            this.center.setY(minY + this.getSize() + this.v1.getDy());
            // Setting the velocity`s dy value so that the direction of movement of the ball will be reversed.
            setVelocity(this.v1.getDx(), -this.v1.getDy());
        }

        // Update the position of the ball based on its velocity
        this.center = this.getVelocity().applyToPoint(this.center);

    }


    /**
     * moveOneStep Method
     * <p>
     * moveOneStep Method creates a new line that the ball "moves" on it. it checks if there id any coliision between
     * this line and all the collidable object using getClosestCollision method. the result assigned to
     * collision.CollisionInfo object.
     * if the collision.CollisionInfo != null - it change the ball`s velocity using the hit method.
     * whether the ball hits any object or not, the method change the ball`s center.
     * </p>
     */
    public void moveOneStep() {
        //create the axis on which the ball will move in 2.5 iterations
        Line trajectory = new Line(this.center.getX(), this.center.getY(), this.center.getX() + this.v1.getDx(),
                this.center.getY() + this.v1.getDy());
        //create the axis on which the ball moves
        //gets the list of the collision objects
        ArrayList<Collidable> collidables = environment.getCollidables();
        //check if there is any collision
        CollisionInfo collisionInfo =  environment.getClosestCollision(trajectory);
        if (collisionInfo != null) {
         //   hitEvent( this);
            //create a new velocity and assign it in the velocity of the ball
            Velocity newVelocity = collisionInfo.collisionObject()
                                                .hit(this, collisionInfo.collisionPoint(), this.v1);
            this.v1 = v1.setVelocity(newVelocity);
            //update the center point of the ball
            this.center = this.v1.applyToPoint(this.center);
            //check if the ball is into one of the collison objects
            for (Collidable collidable : collidables) {
                if (collidable.getCollisionRectangle().contains(this.center)) {
                    //if so - update the center point and the velocity of the ball
                    this.v1 = setVelocity(this.v1.getDx(), -this.v1.getDy());
                    this.center = this.v1.applyToPoint(this.center);
                    return;
                }
            }
            return;
        }
        // Update the position of the ball based on its velocity

        this.center = this.v1.applyToPoint(this.center);

    }


    /**
     * setGameEnvironment Method
     * <p>
     * setGameEnvironment Method update the ball`s environment field to a new Game.GameEnvironment object.
     * </p>
     * @param g Description: new Game.GameEnvironment.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.environment = g;
    }

    /**
     * addHitListener Method
     * <p>
     * addHitListener Method adds a hit listener to the list of listeners to be notified of hit events.
     * </p>
     * @param hl Description: the hit listener to be added
     */
    // Add hl as a listener to hit events.
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * removeHitListener Method
     * <p>
     * removeHitListener Method removes a hit listener from the list of listeners.
     * </p>
     * @param hl Description: the hit listener to be removed.
     */
    // Remove hl from the list of listeners to hit events.
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}



