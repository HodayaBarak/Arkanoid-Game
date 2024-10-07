package Game;


import biuoop.DrawSurface;
import biuoop.Sleeper;
import Collision.SpriteCollection;
import java.awt.Color;

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The CountdownAnimation class is responsible for displaying a countdown animation on the screen before the
 * game starts.
 */

public class CountdownAnimation implements Animation {

    private int countFrom; // The number to count down from
    private SpriteCollection gameScreen; // The game screen to display
    private int currentCount; // The current count being displayed
    private Sleeper sleeper;;
    private long timer;

    /**
     * constructor.
     * <p>
     * creates a new CountdownAnimation with the given duration, countFrom value, and game screen.
     * </p>
     * @param numOfSeconds Description: the duration of the countdown in seconds.
     * @param countFrom Description: the number to count down from.
     * @param gameScreen Description: the game screen to display during the countdown.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.currentCount = countFrom;
        this.gameScreen = gameScreen;
        this.timer = (long) (numOfSeconds / this.countFrom) * 100; // Calculate the time interval between each count
        this.sleeper = new Sleeper();
    }

    /**
     * doOneFrame Method.
     * <p>
     * the method perform one frame of the animation
     * </p>
     * @param d Description: the surface on which the animation is drawn.
     */
    public void doOneFrame(DrawSurface d) {
        // Draw the game screen
        gameScreen.drawAllOn(d);
        // Set the color for the countdown text
         d.setColor(Color.blue);
//            if (currentCount == 0) {
//                // Display "Go!" when the countdown reaches 0
//                d.drawText(d.getWidth() / 2, d.getHeight() / 2, "Go!", 60);
//                sleeper.sleepFor(500);
//                currentCount = -1;
//                shouldStop();
//            }
            if (currentCount > 0) {
                // Draw the countdown number
                d.drawText(d.getWidth() / 2, d.getHeight() / 2, String.valueOf(currentCount), 60);
            }

         // Wait for the specified time interval
            sleeper.sleepFor(this.timer);
         // Decrease the countdown number
            --currentCount;

    }

    /**
     * shouldStop Method.
     * <p>
     * This method checks if the animation should stop..
     * </p>
     * @return boolean
     */
    public boolean shouldStop() {
        return currentCount < 0;
    }
}
