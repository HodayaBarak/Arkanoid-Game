package Collision;

import biuoop.DrawSurface;
import Game.GameLevel;
import java.awt.Color;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-27
 * Class collision.ScoreIndicator represents a sprite that displays the current score on the screen.
 *  It implements the collision.Sprite interface.
 */

public class ScoreIndicator implements Sprite {
    //define variables
    private Counter score;
    private String levelName;
    private int x, y;


    /**
     * constructor.
     * <p>
     * creates new collision.ScoreIndicator object with the specified score counter.
     * </p>
     * @param score Description: the score counter to display.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * constructor.
     * <p>
     * creates new collision.ScoreIndicator object with the specified score counter.
     * </p>
     * @param score Description: the score counter to display.
     * @param levelName Description: the name of the level to display.
     */
    public ScoreIndicator(Counter score, String levelName) {
        this.score = score;
        this.levelName = levelName;
    }


    /**
     * drawOn Method
     * <p>
     * drawOn Method  draws the score on the specified DrawSurface.
     * </p>
     * @param drawSurface Description: the DrawSurface on which to draw the score
     */
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(Color.black);
        drawSurface.drawText(x, y, "Score: " + score.getValue(), 15);
        drawSurface.drawText(x + 250, y, "Level Name: " + levelName, 15);
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
     * setPosition Method
     * <p>
     * setPosition Method sets the position of the collision.ScoreIndicator on the screen.
     * </p>
     * @param x Description: the x-coordinate of the position
     * @param y Description: the y-coordinate of the position
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * addToGame Method
     * <p>
     * addToGame Method gets a game object and add the collision.ScoreIndicator to the sprite list.
     * </p>
     * @param game Description: Game.Game object that holds the sprites list.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

}
