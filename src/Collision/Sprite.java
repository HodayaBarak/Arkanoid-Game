package Collision;

import biuoop.DrawSurface;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The collision.Sprite interface represents an object that can be drawn on a screen and updated over time.
 * It defines methods related to drawing and time progression.
 *
 */
public interface Sprite {

    /**
     * drawOn Method
     *  <p>
     * drawOn Method draws the sprite on the specified DrawSurface.
     * </p>
     * @param d The DrawSurface on which to draw the sprite.
     */
    // draw the sprite to the screen
    void drawOn(DrawSurface d);

    /**
     * timePassed Method
     *  <p>
     * timePassed Method notifies the sprite that a unit of time has passed.
     * This method is typically used to update the state of the sprite over time.
     * </p>
     */
    // notify the sprite that time has passed
    void timePassed();
}