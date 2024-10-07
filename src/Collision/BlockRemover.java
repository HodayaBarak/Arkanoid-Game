package Collision;
//206750911 Hodaya Machluf

import Game.GameLevel;


/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-27
 * The collision.BlockRemover is a collision.HitListener that removes blocks from the game when they are hit.
 * It implements the collision.HitListener interface.
 */
public class BlockRemover implements HitListener {
    //define variables
    private GameLevel gameLevel;
    private Counter remainingBlocks;



    /**
     * constructor.
     * <p>
     * creates a new collision.BlockRemover with the specified game and remaining blocks counter.
     * </p>
     * @param game Description:  the game from which to remove blocks.
     * @param removedBlocks Description: the counter for the remaining blocks.
     */
     public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.gameLevel = game;
        this.remainingBlocks = removedBlocks;
    }


    /**
     * hitEvent Method
     * <p>
     * hitEvent Method is called whenever the beingHit object is hit by a ball.
     * </p>
     * @param beingHit Description: the collision.Block that was hit.
     * @param hitter Description: the collision.Ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {

        // Remove the block from the game
        gameLevel.removeBlock(beingHit);

        // Remove the hitEvent listener from the block
        beingHit.removeHitListener(this);

    }
}