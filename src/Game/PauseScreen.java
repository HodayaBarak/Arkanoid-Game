package Game;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The PauseScreen class represents an animation that displays a pause screen.
 * It extends the KeyPressStoppableAnimation class and adds specific functionality for the pause screen.
 */

public class PauseScreen extends KeyPressStoppableAnimation {
    // define relevant variables
    private final boolean stop;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int CIRCLE_RADIUS = 100;

    /**
     * constructor
     * <p>
     * creates new GameFlow object and initializes its fields.
     * </p>
     * @param k Description: The KeyboardSensor used to detect key presses.
     * @param animation Description: The animation to be played and stopped.
     * @param key Description: The key that stops the animation when pressed.
     */
    public PauseScreen(KeyboardSensor k, String key, Animation animation) {
        super(k, key, animation);
        this.stop = false;
    }



    /**
     * doOneFrame Method.
     * <p>
     * the method perform one frame of the animation
     * </p>
     * @param d Description: the surface on which the animation is drawn.
     */
    public void doOneFrame(DrawSurface d) {
        //draw background
        d.setColor(new Color(230, 230, 250));
        d.drawRectangle(0, 0, 800, 600);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        int circleX = 780 / 2 - CIRCLE_RADIUS;
        int circleY = HEIGHT / 2 - CIRCLE_RADIUS;
        d.setColor(Color.WHITE);
        d.fillOval(circleX, circleY, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);
        d.setColor(Color.black);
        d.drawOval(circleX + 8, circleY + 8, 185, 185);
        d.setColor(Color.gray);
        d.fillOval(circleX + 8, circleY + 8, 185, 185);
        d.setColor(Color.black);
        d.drawOval(circleX + 18, circleY + 18, 165, 165);
        d.setColor(Color.white);
        d.fillOval(circleX + 18, circleY + 18, 165, 165);
        d.setColor(Color.BLACK);
        d.fillRectangle(350, 250, 25, 100);
        d.fillRectangle(400, 250, 25, 100);
        // Display the pause message on the screen

        // //d.getHeight() / 2.
        d.drawText(180, 500, "paused -- press space to continue", 32);

        return;
    }


    /**
     * shouldStop Method.
     * <p>
     * shouldStop method checks if the animation should stop.
     * </p>
     * @return boolean
     */
    public boolean shouldStop() {
        return super.shouldStop();
    }
}