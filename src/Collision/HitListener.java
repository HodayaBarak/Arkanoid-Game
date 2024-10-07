package Collision;
//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-27
 * The collision.HitListener interface represents an object that listens for hit events.
 * Classes that implement this interface can register as listeners to receive hit events.
 *
 */
public interface HitListener {


    /**
     * hitEvent Method
     * <p>
     * hitEvent Method is called whenever the beingHit object is hit by a ball.
     * </p>
     * @param beingHit Description: the collision.Block that was hit.
     * @param hitter Description: the collision.Ball that hit the block.
     */
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the collision.Ball that's doing the hitting.
    void hitEvent(Block beingHit, Ball hitter);
}
