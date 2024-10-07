package Collision;
//206750911 Hodaya Machluf

import GeometryPrimitives.Point;

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * Class collision.CollisionInfo creates a collision.CollisionInfo object from a given
 * collision GeometryPrimitives.Point and collision Object.
 * the collision point is the ball`s collision point with a specific object.
 * the collision object is the object that the ball collided with it.
 *
 */


public class CollisionInfo {
    //define variables
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor
     * <p>
     * creates new object 'collision.CollisionInfo' and assigns the collision Object and the
     * collision Points in it`s fields.
     * </p>
     *
     * @param collisionPoint Description:  the ball`s collision point with a specific object.
     * @param collisionObject  Description: the object that the ball collided with it.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * collisionPoint Method
     * <p>
     * collisionPoint Method returns the point at which the collision occurs.
     * </p>
     * @return GeometryPrimitives.Point.
     */
    public Point collisionPoint() {
        return collisionPoint;
    }


    /**
     * collisionObject Method
     * <p>
     * collisionObject Method returns the collidable object involved in the collision.
     * </p>
     * @return collision.Collidable.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}



