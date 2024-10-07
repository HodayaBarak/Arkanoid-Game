package Game;

import Collision.Sprite;
import Collision.Block;
import Collision.Rectangle;
import GeometryPrimitives.Point;
import GeometryPrimitives.Velocity;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The DirectHit class represents the level information for the "Direct Hit" level.
 */

public class DirectHit implements LevelInformation {
    private int numOfBalls;
    private String levelName;
    private Sprite background;
    private DrawSurface d;
    private int numOfBlocksToRemove;
//    private int widthRow = 50;
//    private int heightRow = 20;
//    private int widthRec = 100, heightRec = 100;
//    private int x = 10, y = 20;
    private Color[] blockColors = new Color[60];
    private Color[] backgroundColors = new Color[80];
    private List<Velocity> velocities;
    private ArrayList<Block> blocks = new ArrayList<Block>();




    /**
     * constructor.
     * <p>
     * creates a new DirectHit object with the given GUI.
     * </p>
     * @param gui Description: the GUI on which to display the animation.
     */
    public DirectHit(GUI gui) {
        this.numOfBalls = 1;
        this.levelName = "Direct Hit";
        this.numOfBlocksToRemove = 1;
        this.d = gui.getDrawSurface();
        this.backgroundColors = backgroundColors();
        this.blockColors = getColors(blockColors, blockColors.length);
        // set the background
        this.background = new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                drawBlockBackground(d);
                drawTarget(d);

            }

            @Override
            public void timePassed() {

            }
        };

    }

    /**
     * backgroundColors Method.
     * <p>
     * backgroundColors Method Generates an array of background colors for the block background.
     * </p>
     * @return Color[]
     */

    private Color[] backgroundColors() {
        for (int i = 0; i < 80; i++) {
            if ((i % 2) == 0) {
                backgroundColors[i] = Color.white;
            } else {
                backgroundColors[i] = Color.lightGray;
            }

        }
        return backgroundColors;
    }

    /**
     * drawBlockBackground Method.
     * <p>
     * drawBlockBackground Method draws the block background on the given DrawSurface.
     * </p>
     * @param d Description: the surface to draw on.
     */
    public void drawBlockBackground(DrawSurface d) {
        int widthRec = 100;
        int heightRec = 50;
        // draw row of blocks
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 8; i++) {
                d.setColor(backgroundColors[i + j]);
                d.fillRectangle(10 + (i * widthRec), 20 + (j * heightRec), widthRec, heightRec);
                d.setColor(Color.black);
                d.drawRectangle(10 + (i * widthRec), 20 + (j * heightRec), widthRec, heightRec);
            }
        }
        //draw white rectangle where thw paddle is
        d.setColor(Color.white);
        d.fillRectangle(10, 550, 780, 590);

    }


    /**
     * drawTarget Method.
     * <p>
     * drawTarget Method draws a target on the given DrawSurface.
     * </p>
     * @param d Description: the surface to draw on.
     */
    public void drawTarget(DrawSurface d) {
            // draw circles for the target
            d.setColor(Color.red);
            d.fillCircle(400, 200, 100);
            d.setColor(Color.white);
            d.fillCircle(400, 200, 80);
            d.setColor(Color.red);
            d.fillCircle(400, 200, 60);
            d.setColor(Color.white);
            d.fillCircle(400, 200, 40);
            d.setColor(Color.red);
            d.fillCircle(400, 200, 20);
            d.setColor(Color.WHITE);
            d.fillCircle(400, 200, 10);

        }

    /**
     * getColors Method.
     * <p>
     * getColors Method generates an array of random colors.
     * </p>
     * @param colors Description: the array to store the generated colors.
     * @param size Description: the size of the array to store the generated colors.
     * @return Color[]
     */
    public Color[] getColors(Color[] colors, int size) {
        // Generate random colors for the blocks and for the ball
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            double r = rand.nextFloat();
            double g = rand.nextFloat();
            double b = rand.nextFloat();
            Color randomColor = new Color((float) r, (float) g, (float) b);
            randomColor.brighter();
            colors[i] = randomColor;
        }
        return colors;
    }



    /**
     * numberOfBalls Method.
     * <p>
     * numberOfBalls Method returns the number of balls in the level.
     * </p>
     * @return int
     */
    @Override
    public int numberOfBalls() {
        return this.numOfBalls;
    }

    /**
     * initialBallVelocities Method.
     * <p>
     * initialBallVelocities Method returns the initial velocities of the balls in the level.
     * </p>
     * @return List of Velocity type objects.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        this.velocities = new ArrayList<>();
        velocities.add(new Velocity(0, 6));
        return this.velocities;

    }

    /**
     * paddleSpeed Method.
     * <p>
     * paddleSpeed Method returns the speed of the paddle in the level.
     * </p>
     * @return int
     */
    @Override
    public int paddleSpeed() {
        return 10;
    }

    /**
     * paddleWidth Method.
     * <p>
     * paddleWidth Method returns the width of the paddle in the level.
     * </p>
     * @return int
     */
    @Override
    public int paddleWidth() {
        return 100;
    }

    /**
     * levelName Method.
     * <p>
     * levelName Method returns the name of the level.
     * </p>
     * @return String
     */
    @Override
    public String levelName() {
        return this.levelName;
    }

    /**
     * getBackground Method.
     * <p>
     * getBackground Method returns the background sprite of the level.
     * </p>
     * @return Sprite
     */
    @Override
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * paddleUpperLeft Method.
     * <p>
     * paddleUpperLeft Method returns the upper-left point of the paddle in the level.
     * </p>
     * @return Point
     */
    @Override
    public Point paddleUpperLeft() {
        return new Point(350, 560);
    }
    /**
     * paddleColor Method.
     * <p>
     * paddleColor Method returns the color of the paddle in the level.
     * </p>
     * @return Color
     */
    @Override
    public Color paddleColor() {
        return Color.yellow;
    }
    /**
     * BallColor Method.
     * <p>
     * BallColor Method returns the color of the balls in the level.
     * </p>
     * @return Color
     */
    @Override
    public Color ballColor() {
        return Color.black;
    }
    /**
     * paddleHeight Method.
     * <p>
     * paddleHeight Method returns the height of the paddle in the level.
     * </p>
     * @return int
     */
    @Override
    public int paddleHeight() {
        return 10;
    }


    /**
     * blocks Method.
     * <p>
     * blocks Method returns he list of blocks in the level.
     * </p>
     * @return  List of Block type objects
     */
    @Override
    public List<Block> blocks() {
        int widthRec = 50;
        int heightRec = 20;

        Block hitBlock = new Block(new Rectangle(new Point(375, 180), 50, 40), Color.black);
        blocks.add(hitBlock);

        return blocks;
    }
    /**
     * numberOfBlocksToRemove Method.
     * <p>
     * numberOfBlocksToRemove Method returns the number of blocks to remove in the level.
     * </p>
     * @return int
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.numOfBlocksToRemove;
    }
}
