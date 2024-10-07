package Game;

import Collision.Collidable;
import Collision.CollisionInfo;
import GeometryPrimitives.Line;
import GeometryPrimitives.Point;

import java.util.ArrayList;


//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * Class Game.GameEnvironment creates a Game.GameEnvironment object that contain an array
 * list of all of the objects that one may collide with.
 * it also can get the information about the closest collision between one and an element from the collidable list.
 */


public class GameEnvironment {

    //define a relevent variable
    private ArrayList<Collidable> collidables;


    /**
     * constructor
     * <p>
     * creates new object 'Game.GameEnvironment' by create a new array list of colidables.
     * </p>
     */
    public GameEnvironment() {
        collidables = new ArrayList<Collidable>();
    }
    /**
     * addCollidable Method
     * <p>
     * addCollidable Method adds a given element to the colidables list.
     * </p>
     * @param c Description: a given element.
     */
    // add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        collidables.add(c);

    }

    /**
     * getClosestCollision Method
     * <p>
     * getClosestCollision Method goes through all the element of the collidable list by for loop and checks for each
     * element if there is a closest intersection point to the start point of the line between the elment and the line.
     * if so, it returns a new collision.CollisionInfo object with the collision point and the relevent element
     * of the collidable list. otherwise, it returns null.
     * </p>
     * @param trajectory Description: the "line" the the ball moves on it.
     * @return collision.CollisionInfo.
     * */

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point collisionPoint;
        if (this.collidables.isEmpty()) {
            return null;
        }

        for (int i = 0; i < collidables.size(); i++) {

            //if there is an intersection point that closest to the start of the line with one of the elemnts
            collisionPoint = trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
            if (collisionPoint != null) {
                //return new CollisionInfi with the collision point and with the relevent elemnt from the list
                return new CollisionInfo(collisionPoint, collidables.get(i));
            }
        }
        //if there isn`t any intersection between the line and the elements - return null
        return null;
    }

    /**
     * getCollidables Method
     * <p>
     * getCollidables Method returns the list of collidable objects.
     * </p>
     * @return double. */
    public ArrayList<Collidable> getCollidables() {
        return collidables;
    }
}



