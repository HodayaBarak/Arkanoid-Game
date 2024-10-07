package Game;
import Collision.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The GameOverAnimation class represents an animation displayed when the game is over.
 * It extends the KeyPressStoppableAnimation class.
 */

public class GameOverAnimation extends KeyPressStoppableAnimation {
    // define relevant variables
    private boolean stop;
    private Counter score;
    private final int width = 780, height = 590;


    /**
     * constructor
     * <p>
     * creates new GameFlow object and initializes its fields.
     * </p>
     * @param k Description: The KeyboardSensor used to handle keyboard input.
     * @param animation Description: The AnimationRunner used to run the game's animations.
     * @param score Description: The Counter representing the game score.
     * @param key Description:  The key that stops the animation when pressed.
     */
    public GameOverAnimation(KeyboardSensor k, String key, Animation animation, Counter score) {
        super(k, key, animation);
        this.stop = false;
        this.score = score;
    }



    /**
     * doOneFrame Method.
     * <p>
     * the method perform one frame of the animation
     * </p>
     * @param d Description: the surface on which the animation is drawn.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // Set the background color to a light purple.
        d.setColor(new Color(230, 230, 250));
        d.drawRectangle(0, 0, 800, 600);
        d.fillRectangle(0, 0, 800, 600);
        drawPoints(d);
        d.setColor(Color.white);
        d.fillOval(225, 120, 350, 250);
        d.setColor(Color.BLACK);
        // Display the game over message and the player's score on the screen.
            d.drawText(315, 200, "Game Over.", 32);
        d.drawText(275, d.getHeight() / 2, "Your score is " + this.score.getValue(), 32);

    }

    /**
     * drawPoints Method.
     * <p>
     * the method draws circles along the borders of the surface object.
     * </p>
     * @param d Description: the surface on which the animation is drawn.
     */
    private void drawPoints(DrawSurface d) {
    // Set the circles color
        d.setColor(Color.blue);

    // Define circles parameters
    int circleSize = 50;
    int smallCircleSize = 10;

    // Draw circles along the top border
        for (int x = 10; x <=  width - circleSize; x += circleSize) {
        int y = 10;
        drawPoints(d, x, y, circleSize, smallCircleSize);
    }

    // Draw circles along the bottom border
        for (int x = 10; x <= width - circleSize; x += circleSize) {
        int y = height - circleSize - 10;
        drawPoints(d, x, y, circleSize, smallCircleSize);
    }

    // Draw circles along the left border
        for (int y = 10 + circleSize; y <= height - circleSize - 10; y += circleSize) {
        int x = 10;
        drawPoints(d, x, y, circleSize, smallCircleSize);
    }

    // Draw circles along the right border
        for (int y = 10 + circleSize; y <= height - circleSize - 10; y += circleSize) {
        int x = width - circleSize - 10;
        drawPoints(d, x, y, circleSize, smallCircleSize);
    }
}

    /**
     * drawPoints Method.
     * <p>
     * the method draws a circle at the specified coordinates on a surface object.
     * </p>
     * @param d Description: the surface on which the animation is drawn.
     * @param x Description: The x-coordinate of the circle.
     * @param y Description: The y-coordinate of the circle.
     * @param size Description: The size of the circle.
     * @param smallCircleSize Description: The size of the small circles.
     */
    private void drawPoints(DrawSurface d, int x, int y, int size, int smallCircleSize) {
        // Draw small circles
        d.fillOval(x, y, smallCircleSize, smallCircleSize);
        d.fillOval(x + size - smallCircleSize, y, smallCircleSize, smallCircleSize);
        d.fillOval(x, y + size - smallCircleSize, smallCircleSize, smallCircleSize);
        d.fillOval(x + size - smallCircleSize, y + size - smallCircleSize, smallCircleSize, smallCircleSize);

        // Draw circles center
        int centerSize = size - 2 * smallCircleSize;
        int centerX = x + smallCircleSize;
        int centerY = y + smallCircleSize;
        d.fillOval(centerX, centerY, centerSize, centerSize);
    }

    /**
     * shouldStop Method.
     * <p>
     * shouldStop method checks if the animation should stop.
     * </p>
     * @return boolean
     */
    @Override
    public boolean shouldStop() {
     // return this.stop;
        return super.shouldStop();
    }


}
