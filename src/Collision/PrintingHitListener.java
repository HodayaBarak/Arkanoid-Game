package Collision;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-04-27
 * Class PrintingHitListener implementation the HitListener interface and prints a message to the console
 * when a collision occurs between a Block and a Ball.
*/

public class PrintingHitListener implements HitListener {

    /**
     * hitEvent Method.
     * <p>
     * This method is called when a collision occurs between a Block and a Ball.
     * </p>
     * @param beingHit Description: the Block object that was hit
     * @param hitter Description: the Ball object that hit the Block
     */
        public void hitEvent(Block beingHit, Ball hitter) {
            System.out.println("A collision.Block was hit.");
        }
    }

