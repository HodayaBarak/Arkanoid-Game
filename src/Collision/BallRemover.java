package Collision;
import Game.GameLevel;



//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-27
 * The collision.BallRemover class is a collision.HitListener that removes balls from the game
 * when they hit a specific block.
 * It implements the collision.HitListener interface.
 * from the collidable list.
 */

public class BallRemover implements HitListener {
    //define variables
        private GameLevel gameLevel;
        private Counter remainingBalls;


    /**
     * constructor.
     * <p>
     * creates new collision.BallRemover object with the specified game and remaining balls counter.
     * </p>
     * @param gameLevel Description:  the game from which to remove balls.
     * @param removedBalls Description: the counter for the remaining balls.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }

    /**
     * hitEvent Method
     * <p>
     * hitEvent Method removes the hitter ball from the game when it hits the specified block.
     * Also removes the collision.BallRemover listener from the ball.
     * </p>
     * @param deathBlock Description: the collision.Block that was hit.
     * @param hitter Description: the collision.Ball that hit the block.
     */
        public void hitEvent(Block deathBlock, Ball hitter) {
            // Remove the block from the game
            gameLevel.removeBall(hitter);

            // Remove the hitEvent listener from the block
            hitter.removeHitListener(this);

        }
    }

