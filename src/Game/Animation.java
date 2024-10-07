package Game;

import biuoop.DrawSurface;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 *  The Animation interface represents a single frame of an animation.
 */

public interface Animation {
    /**
     * doOneFrame Method.
     * <p>
     * the method perform one frame of the animation
     * </p>
     * @param d Description: the surface on which the animation is drawn.
     */
    void doOneFrame(DrawSurface d);
    /**
     * shouldStop Method.
     * <p>
     * shouldStop method checks if the animation should stop.
     * </p>
     * @return boolean
     */
    boolean shouldStop();
}