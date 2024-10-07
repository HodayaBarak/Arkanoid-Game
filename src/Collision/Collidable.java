package Collision;

//206750911 Hodaya Machluf

import GeometryPrimitives.Point;
import GeometryPrimitives.Velocity;



/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 *  The collision.Collidable interface represents an object that can participate in collisions.
 * It defines methods related to collision detection and response.
 *
 */

public interface Collidable {
    /**
     * getCollisionRectangle Method
     * <p>
     * Returns the collision shape of the object.
     * The collision shape is represented by a collision.Rectangle.
     * </p>
     * @return collision.Rectangle.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit Method
     * <p>
     * hit Method Notifies the object that a collision occurred at a specific collision point with a given velocity.
     * The method calculates and returns the new velocity expected after the hit, based on the force the object
     * inflicted.
     * </p>
     * @param collisionPoint Description: The point at which the collision occurred.
     * @param currentVelocity Description: The current velocity of the object.
     * @param hitter Description: The ball that hit the collidibale object.
     * @return GeometryPrimitives.Velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}