package Game;

import Collision.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.Random;


//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The YouWinAnimation class represents an animation displayed when the player wins the game.
 * It extends the KeyPressStoppableAnimation class.
 */
public class YouWinAnimation extends KeyPressStoppableAnimation {

    // define relevant variables
    private boolean stop;
    private Counter score;
    private final int width = 780, height = 590;
    private int[] flowerX = flowerRandomX();
    private int[] flowerY = flowerRandomY();


    /**
     * constructor
     * <p>
     * creates new GameFlow object and initializes its fields.
     * </p>
     * @param k Description: The KeyboardSensor used to handle keyboard input.
     * @param animation Description: The AnimationRunner used to run the game's animations.
     * @param score Description: The Counter representing the game score.
     * @param key Description: The key that stops the animation when pressed.
     */
    public YouWinAnimation(KeyboardSensor k, String key, Animation animation, Counter score) {
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
        drawFlowers(d);
        d.setColor(Color.white);
        d.fillOval(225, 120, 350, 250);
        d.setColor(Color.blue);
        // Display the win message and the player's score.
        d.drawText(325, 200, "You Win!", 32);
        d.drawText(275, d.getHeight() / 2, "Your score is " + this.score.getValue(), 32);

    }

    /**
     * flowerRandomX Method.
     * <p>
     * flowerRandomX method generates random x-coordinates for flowers
     * </p>
     * @return int[]
     */
    public int[] flowerRandomX() {
        Random random = new Random();
        int[] flowerX = new int[200];
        for (int i = 0; i < 200; i++) {
            int x = random.nextInt(780);
            flowerX[i] = x;
        }
        return flowerX;
    }

    /**
     * flowerRandomY Method.
     * <p>
     * flowerRandomY method generates random y-coordinates for flowers
     * </p>
     * @return int[]
     */
    public int[] flowerRandomY() {
        int[] flowerY = new int[200];
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            int y = random.nextInt(580);
            flowerY[i] = y;
        }
        return flowerY;
    }

    /**
     * drawFlowers Method.
     * <p>
     * drawFlowers method draws flowers on a DrawSurface object.
     * </p>
     * @param d Description: The surface on which to draw the flowers.
     */
    private void drawFlowers(DrawSurface d) {
        for (int i = 0; i < 200; i++) {
            // Draw flower stem
            d.setColor(new Color(153, 76, 0));
            d.fillOval(flowerX[i] - 2, flowerY[i], 4, 40);
            d.setColor(new Color(255, 71, 230));
            d.drawOval(flowerX[i] - 15, flowerY[i] - 30, 30, 30);
            // Draw flower petals
            d.setColor(new Color(238, 153, 192));
            d.fillOval(flowerX[i] - 15, flowerY[i] - 30, 30, 30);
            d.fillOval(flowerX[i] - 5, flowerY[i] - 40, 20, 20);
            d.fillOval(flowerX[i] + 5, flowerY[i] - 30, 30, 30);
            d.fillOval(flowerX[i] - 5, flowerY[i] - 20, 20, 20);
        }
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
      return super.shouldStop();
    }

}
