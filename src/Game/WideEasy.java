package Game;
import Collision.Ball;
import Collision.Block;
import Collision.Rectangle;
import Collision.Sprite;
import GeometryPrimitives.Point;
import GeometryPrimitives.Velocity;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The WideEasy class represents the level information for the "Wide Easy" level.
 */
public class WideEasy implements LevelInformation {
    private int numOfBalls;
    private String levelName;
    private Sprite backround;
    private DrawSurface d;
    private int numOfBlocksToRemove;
    private int x = 10, y = 20;
    private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.green, Color.blue, Color.PINK, Color.CYAN,
            Color.RED, Color.ORANGE, Color.YELLOW, Color.green, Color.blue, Color.PINK, Color.CYAN};
    private final int screenHeight = 590;
    private List<Velocity> velocities;
    private ArrayList<Block> blocks = new ArrayList<Block>();


    /**
     * constructor.
     * <p>
     * creates a new WideEasy object with the given GUI.
     * </p>
     * @param gui Description: the GUI on which to display the animation.
     */
    public WideEasy(GUI gui) {
        this.numOfBalls = 10;
        this.levelName = "Wide Easy";
        this.numOfBlocksToRemove = 12;
        this.d = gui.getDrawSurface();
        this.backround = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                // draw jungle Background
                jungleBackground(d);
                // draw tigers, bushes and trees
                paintComponent(d);
            }


            @Override
            public void timePassed() {

            }
        };

    }




    /**
     * JungleBackground Method.
     * <p>
     * JungleBackground Method Draws a jungle background on the given DrawSurface.
     * </p>
     * @param d Description:  the surface to draw on.
     */
    public void jungleBackground(DrawSurface d) {
       // d.setColor(new Color(34, 139, 34)); // Dark Green
                // Draw sky background
        d.setColor(new Color(135, 206, 235));
        d.fillRectangle(0, 20, 800, 590);

        // Draw ground background
        d.setColor(new Color(152, 251, 152));
        d.fillRectangle(0, 600 / 2, 800, 600 / 2);

        d.setColor(new Color(255, 255, 170));
        d.fillCircle(120, 120, 100);
        d.setColor(new Color(252, 252, 150));
        d.fillCircle(120, 120, 80);
        d.setColor(new Color(255, 255, 125));
        d.fillCircle(120, 120, 60);
        d.setColor(new Color(253, 253, 91));
        d.fillCircle(120, 120, 40);
    }

    /**
     * paintComponent Method.
     * <p>
     * paintComponent Method paints the components of the jungle scene on the given surface.
     * </p>
     * @param d Description:  the surface to draw on.
     */
    public void paintComponent(DrawSurface d) {


        // Draw tree trunks
        d.setColor(new Color(139, 69, 19)); // Brown
        d.fillRectangle(50, screenHeight - 340, 50, 150);
        d.fillRectangle(150, screenHeight - 390, 50, 200);
        d.fillRectangle(350, screenHeight - 290, 50, 100);
        d.fillRectangle(450, screenHeight - 390, 50, 200);
        d.fillRectangle(600, screenHeight - 290, 50, 100);

        // Draw tree tops (circles)
        d.setColor(new Color(34, 139, 34)); // Dark Green
        d.fillOval(20, screenHeight - 410, 110, 110);
        d.fillOval(120, screenHeight - 470, 110, 110);
        d.fillOval(320, screenHeight - 350, 110, 110);
        d.fillOval(430, screenHeight - 470, 110, 110);
        d.fillOval(570, screenHeight - 370, 110, 110);

        // Draw bushes (ellipses)
        d.setColor(new Color(50, 205, 50)); // Lime Green
        d.fillOval(400, screenHeight - 240, 100, 50);
        d.fillOval(500, screenHeight - 220, 80, 40);
        d.fillOval(600, screenHeight - 230, 120, 60);



        // Draw tigers
        drawTiger(d, 150, screenHeight - 190);
        drawTiger(d, 500, screenHeight - 170);
        drawTiger(d, 350, screenHeight - 150);
        drawTiger(d, 120, screenHeight - 70);
    }


    /**
     * drawTiger Method.
     * <p>
     * drawTiger Method draws a tiger on the given DrawSurface at the specified position.
     * </p>
     * @param d Description: the surface to draw on.
     * @param x Description: the x-coordinate of the tiger's position.
     * @param y Description: the y-coordinate of the tiger's position.
     */
    public void drawTiger(DrawSurface d, int x, int y) {
        d.setColor(Color.ORANGE);
        // Body
        d.fillRectangle(x + 10, y + 10, 40, 20);
        // Tail
        d.fillRectangle(x + 50, y + 10, 10, 30);
        d.setColor(Color.BLACK);
        // Head
        d.fillOval(x, y, 20, 20);
        // Left ear
        d.fillOval(x + 10, y + 20, 10, 10);
        // Right ear
        d.fillOval(x + 30, y + 20, 10, 10);
        d.setColor(Color.WHITE);
        // Left eye
        d.fillOval(x + 5, y + 5, 5, 5);
        // Right eye
        d.fillOval(x + 15, y + 5, 5, 5);
        d.setColor(Color.BLACK);
        // Left nostril
        d.fillOval(x + 7, y + 7, 2, 2);
        // Right nostril
        d.fillOval(x + 17, y + 7, 2, 2);
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

        int angle = 115;
        for (int i = 0; i < this.numOfBalls; i++) {
            this.velocities.add(Velocity.fromAngleAndSpeed(angle, 5));
            angle += 110;
        }
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
        return 500;
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
        return this.backround;
    }
    /**
     * blocks Method.
     * <p>
     * blocks Method returns he list of blocks in the level.
     * </p>
     * @return List of Block type objects
     */
    @Override
    public List<Block> blocks() {

        for (int i = 0; i < this.numOfBlocksToRemove; i++) {
            Block block = new Block(new Rectangle(new Point(10 + (i * 65), 175), 60, 20),
                   colors[i]);
            blocks.add(block);
        }
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

    /**
     * paddleUpperLeft Method.
     * <p>
     * paddleUpperLeft Method returns the upper-left point of the paddle in the level.
     * </p>
     * @return Point
     */
    @Override
    public Point paddleUpperLeft() {
        return new Point(150, 565);
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
        return Color.white;
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
        return Color.blue;
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
}
