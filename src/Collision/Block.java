package Collision;

import Game.GameLevel;
import GeometryPrimitives.Point;
import GeometryPrimitives.Velocity;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * Class collision.Block creates a collision.Block object from a given reactangle and color.
 * it allso can change the ball velocity according to the information about a ball`s
 * collision point with a specific block.
 *
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private ArrayList<HitListener> hitListeners = new ArrayList<HitListener>();
    //define relevent variables.
    private Rectangle rectangle;
    private Color color;
    private static final double EPSILON = 0.0001;

    /**
     * constructor
     * <p>
     * creates new collision.Block object and assigns the rectangle and it`s color in the block`s fields.
     * </p>
     * @param rectangle Description: object "rectangle".
     * @param color  Description: the block`s color.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }






    /**
     * addHitListener Method
     * <p>
     * addHitListener Method adds the specified collision.HitListener to the list of listeners for hit events.
     * </p>
     * @param hl Description: the collision.HitListener to be added.
     */

    public void addHitListener(HitListener hl) {
        // Add hl as a listener to hit events.
        hitListeners.add(hl);
    }

    /**
     * removeHitListener Method
     * <p>
     * removeHitListener Method removes the specified collision.HitListener from the list of listeners for hit events.
     * </p>
     * @param hl Description: the collision.HitListener to be removed.
     */
    public void removeHitListener(HitListener hl) {
        // Remove hl from the list of listeners to hit events.
        hitListeners.remove(hl);
    }



    /**
     * notifyHit Method
     * <p>
     * notifyHit Method notifies all HitListeners objects on the list
     * about a hit event with the specified collision.Ball.
     * </p>
     * @param hitter Description: the collision.Ball object involved in the hit event.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        ArrayList<HitListener> listeners = new ArrayList<>(this.hitListeners);
      //  List<collision.HitListener> listeners = new ArrayList<collision.HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


    /**
     * getColor Method
     * <p>
     * getColor Method returns the block`s color.
     * </p>
     * @return Color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * drawOn Method
     * <p>
     * drawOn Method gets a surface and draw a rectangle on top of it.
     * </p>
     * @param surface Description: a given field.
     */
    public void drawOn(DrawSurface surface) {
        // draw the rectangle on the given DrawSurface
        DrawSurface d = surface;
        d.setColor(Color.black);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }




    /**
     * timePassed Method
     * <p>
     * This method is called in each frame of the animation.
     * </p>
     */
    @Override
    public void timePassed() {

    }


    /**
     * getCollisionRectangle Method
     * <p>
     * getCollisionRectangle Method returns the block`s rectangle.
     * </p>
     * @return collision.Rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * addToGame Method
     * <p>
     * addToGame Method gets a game object and add the block to the sprite and collidable lists.
     * </p>
     * @param gameLevel Description: Game.Game object that holds the sprites and the collidables.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * hit Method
     * <p>
     * hit Method calculates the new velocity of the ball after a collision with the block.
     * Determines the collision point on the block and updates the velocity accordingly.
     </p>
     * @param collisionPoint Description: the point of collision with the block
     * @param currentVelocity Description: the current velocity of the ball
     * @return GeometryPrimitives.Velocity
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {


        //  checks if the collision point equal to any of the rectangle vertices
        if (collisionPoint.equals(this.rectangle.getUpperLeft())
                || collisionPoint.equals(this.rectangle.getBottomLeft())
                || collisionPoint.equals(this.rectangle.getUpperRight())
                ||  collisionPoint.equals(this.rectangle.getBottomRight())) {

            // the velocity changed to (-dx,-dy)
            currentVelocity = currentVelocity.setVelocity(-currentVelocity.getDx(), -currentVelocity.getDy());



            // if the collision point hits the upper/bottom side of the rectangle that parallel to X axe
        } else if ((this.rectangle.getBottomParallelX().pointOnLine(collisionPoint))
                || (this.rectangle.getUpperParallelX().pointOnLine(collisionPoint))) {

            // the velocity changed to (dx,-dy)
            currentVelocity =  currentVelocity.setVelocity(currentVelocity.getDx(), -currentVelocity.getDy());



            // if the collision point hits the left/right side of the rectangle that parallel to Y axe
        } else if ((this.rectangle.getLeftParallelY().pointOnLine(collisionPoint))
                || (this.rectangle.getRightParallelY().pointOnLine(collisionPoint))) {

            // the velocity changed to (-dx,dy)
            currentVelocity = currentVelocity.setVelocity(-currentVelocity.getDx(), currentVelocity.getDy());

        }

        // notify about the hit
        this.notifyHit(hitter);


        return currentVelocity;
    }

}
