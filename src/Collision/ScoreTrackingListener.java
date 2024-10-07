package Collision;
//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-27
 * Class collision.ScoreTrackingListener is a collision.HitListener that keeps track of the score.
 * It implements the collision.HitListener interface.
 */
public class ScoreTrackingListener implements HitListener {
    //define variable
    private Counter currentScore;

    /**
     * constructor.
     * <p>
     * creates a new collision.ScoreTrackingListener with the specified score counter.
     * </p>
     * @param scoreCounter Description: the score counter to track.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * getScoreValue Method.
     * <p>
     * getScoreValue Method returns the current value of the score.
     * </p>
     * @return int
     */
    public int getScoreValue() {
       return this.currentScore.getValue();
    }

    /**
     * hitEvent Method.
     * <p>
     * hitEvent Method updates the score when a block is hit by increasing it by 5.
     * </p>
     * @param beingHit Description: the collision.Block that was hit.
     * @param hitter Description:  the collision.Ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }

    /**
     * levelCleared Method.
     * <p>
     * levelCleared Method increases the score by 100 when the level is cleared (all blocks removed).
     * </p>
     */
    public void levelCleared() {
        currentScore.increase(100);
    }

}