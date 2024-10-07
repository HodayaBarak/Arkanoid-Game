package Game;

import Collision.Block;
import Collision.Sprite;
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
 * The Green3 class represents the level information for the "Green3" level.
 */

public class Green3 implements LevelInformation {

        private int numOfBalls;
        private String levelName;
        private Sprite backround;
        private DrawSurface d;
        private int numOfBlocksToRemove;
        private int widthRow = 50, heightRow = 30;
        private int x = 10, y = 20;
        private Color[] colors = new Color[20];
        private List<Velocity> velocities = new ArrayList<>();;
        private ArrayList<Block> blocks = new ArrayList<Block>();
        private static final int BUILDING_WIDTH = 100;
        private static final int BUILDING_HEIGHT = 300;
        private static final int WINDOW_SIZE = 20;
        private static final int WINDOW_GAP = 30;
        private static final int CLOUD_RADIUS = 30;
        private static final int CLOUD_SPACING = 100;
        private static final int NUM_ROWS = 3;
        private static final int TREE_WIDTH = 30;
        private static final int TREE_HEIGHT = 80;


    /**
     * constructor.
     * <p>
     * creates a new Green3 object with the given GUI.
     * </p>
     * @param gui Description: the GUI on which to display the animation.
     */
        public Green3(GUI gui) {
            this.numOfBalls = 2;
            this.levelName = "Green 3";
            this.numOfBlocksToRemove = 54;
            this.d = gui.getDrawSurface();
            this.colors = getBrightColors(colors, colors.length);
            this.backround = new Sprite() {

                @Override
                public void drawOn(DrawSurface d) {
                    //draw the background
                    drawSky(d);
                    drawClouds(d);
                    drawBuildings(d);
                    drawTrees(d);
                }

                @Override
                public void timePassed() {

                }
            };

        }

    /**
     * getBrightColors Method.
     * <p>
     * getBrightColors Method generates an array of bright random colors.
     * </p>
     * @param colors Description: the array to store the generated colors.
     * @param size Description: the size of the array to store the generated colors.
     * @return Color[]
     */
        public Color[] getBrightColors(Color[] colors, int size) {
            // Generate random colors for the blocks and for the ball
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                double r = rand.nextFloat() / 2f + 0.5;
                double g = rand.nextFloat() / 2f + 0.5;
                double b = rand.nextFloat() / 2f + 0.5;
                Color randomColor = new Color((float) r, (float) g, (float) b);
                randomColor.brighter();
                colors[i] = randomColor;
            }
            return colors;
        }

    /**
     * drawSky Method.
     * <p>
     * drawSky Method draws the sky on the given surface.
     * </p>
     * @param d Description: the DrawSurface to draw on
     */
    private void drawSky(DrawSurface d) {
        // Draw light green sky
        d.setColor(new Color(204, 255, 209));
        d.fillRectangle(10, 20, 800, 580);
    }

    /**
     * drawClouds Method.
     * <p>
     * drawClouds Method draws the clouds on the given surface.
     * </p>
     * @param d Description: the DrawSurface to draw on
     */
    private void drawClouds(DrawSurface d) {
        int startX = 50;
        int startY = 100;
        int cloudCount = 5;
        d.setColor(Color.WHITE);
        for (int i = 0; i < cloudCount; i++) {
            int x = startX + (i * 2 * CLOUD_SPACING);
            int y = startY;
            for (int j = 0; j < NUM_ROWS; j++) {

                // Draw cloud using circles
                d.fillOval(x, y, CLOUD_RADIUS, CLOUD_RADIUS);
                d.fillOval(x + CLOUD_RADIUS, y, CLOUD_RADIUS, CLOUD_RADIUS);
                d.fillOval(x, y + CLOUD_RADIUS, CLOUD_RADIUS, CLOUD_RADIUS);
                d.fillOval(x + CLOUD_RADIUS, y + CLOUD_RADIUS, CLOUD_RADIUS, CLOUD_RADIUS);
                d.fillOval(x + (CLOUD_RADIUS / 2), y - (CLOUD_RADIUS / 2), CLOUD_RADIUS, CLOUD_RADIUS);
                d.fillOval(x + CLOUD_RADIUS + (CLOUD_RADIUS / 2), y - (CLOUD_RADIUS / 2), CLOUD_RADIUS, CLOUD_RADIUS);
                d.fillOval(x + (CLOUD_RADIUS / 2), y + CLOUD_RADIUS - (CLOUD_RADIUS / 2), CLOUD_RADIUS, CLOUD_RADIUS);
                d.fillOval(x + CLOUD_RADIUS + (CLOUD_RADIUS / 2), y + CLOUD_RADIUS - (CLOUD_RADIUS / 2), CLOUD_RADIUS,
                        CLOUD_RADIUS);
            }
        }
    }

    /**
     * drawTrees Method.
     * <p>
     * drawTrees Method draws the trees on the given surface.
     * </p>
     * @param d Description: the DrawSurface to draw on
     */
    private void drawTrees(DrawSurface d) {
        // Draw trees between buildings
        int startX = 190;
        int treeCount = 3;
        int treeSpacing = 200;

        for (int i = 0; i < treeCount; i++) {

            int x = startX + (i * treeSpacing);
            int y = 600 - TREE_HEIGHT;
            d.setColor(new Color(153, 76, 0));
            // Draw tree trunk
            d.fillRectangle(x, y, TREE_WIDTH, TREE_HEIGHT);

            // Draw tree top
            d.setColor(new Color(0, 100, 0));
            d.fillOval(x - (TREE_WIDTH / 2), y - (TREE_WIDTH / 2), TREE_WIDTH * 2, TREE_WIDTH * 2);
        }
    }


    /**
     * drawBuildings Method.
     * <p>
     * drawBuildings Method draws the buildings on the given surface.
     * </p>
     * @param d Description: the DrawSurface to draw on
     */
    private void drawBuildings(DrawSurface d) {

        int startX = 50;
        int buildingCount = 6;
        int buildingSpacing = 100;


        // Draw buildings
        d.setColor(Color.gray);
        for (int i = 0; i < buildingCount; i++) {
            int x = startX + (i * (BUILDING_WIDTH + buildingSpacing));
            int y = 590 - BUILDING_HEIGHT;

            d.setColor(Color.black);
            d.drawRectangle(x, y, BUILDING_WIDTH, BUILDING_HEIGHT);
            // Draw building
            d.setColor(colors[buildingCount + i]);
            d.fillRectangle(x, y, BUILDING_WIDTH, BUILDING_HEIGHT);

            // Draw windows

            d.setColor(Color.WHITE);
            int windowStartY = y + 20;
            int windowCount = (BUILDING_HEIGHT - 40) / (WINDOW_SIZE + WINDOW_GAP);


            for (int j = 0; j < windowCount; j++) {
                int windowX = x + 10;
                int windowY = windowStartY + (j * (WINDOW_SIZE + WINDOW_GAP));

                d.setColor(Color.black);
                d.drawRectangle(windowX, windowY, WINDOW_SIZE, WINDOW_SIZE);
                d.setColor(Color.WHITE);
                d.fillRectangle(windowX, windowY, WINDOW_SIZE, WINDOW_SIZE);
                d.setColor(Color.black);
                d.drawRectangle(windowX + WINDOW_SIZE + 10, windowY, WINDOW_SIZE, WINDOW_SIZE);
                d.setColor(Color.WHITE);
                d.fillRectangle(windowX + WINDOW_SIZE + 10, windowY, WINDOW_SIZE, WINDOW_SIZE);
                d.setColor(Color.black);
                d.drawRectangle(windowX + (2 * (WINDOW_SIZE + 10)), windowY, WINDOW_SIZE, WINDOW_SIZE);
                d.setColor(Color.WHITE);
                d.fillRectangle(windowX + (2 * (WINDOW_SIZE + 10)), windowY, WINDOW_SIZE, WINDOW_SIZE);
            }
        }
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
                angle += 120;
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
            return 150;
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
     * @return List of Block type objects.
     */
        @Override
        public List<Block> blocks() {
            // Create the game lower border
            Block bottomBlock = new Block(new Rectangle(new Point(0, 590), 800, 10),
                    new Color(204, 255, 229));
            blocks.add(bottomBlock);
            //create the first blocks layout
            for (int i = 0; i < 10; i++) {
                Rectangle rectangle = new Rectangle(new Point(740 - (i * widthRow), 120),
                        widthRow, heightRow);
                Block block = new Block(rectangle, Color.gray);
                blocks.add(block);
            }
            for (int i = 0; i < 10; i++) {
                Rectangle rectangle = new Rectangle(new Point(740 - (i * widthRow), 120),
                        widthRow, heightRow);
                Block block = new Block(rectangle, Color.gray);
                blocks.add(block);
            }

            //create the second blocks layout
            for (int i = 0; i < 10; i++) {
                Rectangle rectangle = new Rectangle(new Point(740 - (i * widthRow), 150),
                        widthRow, heightRow);
                Block block = new Block(rectangle, colors[2]);
                blocks.add(block);

            }

            //create the third blocks layout
            for (int i = 0; i < 9; i++) {
                Rectangle rectangle = new Rectangle(new Point(740 - (i * widthRow), 180),
                        widthRow, heightRow);
                Block block = new Block(rectangle, colors[3]);
                blocks.add(block);
            }

            //create the fourth blocks layout

            for (int i = 0; i < 8; i++) {
                Rectangle rectangle = new Rectangle(new Point(740 - (i * widthRow), 210),
                        widthRow, heightRow);
                Block block = new Block(rectangle, colors[4]);
                blocks.add(block);
            }

            //create the fifth blocks layout
            for (int i = 0; i < 7; i++) {
                Rectangle rectangle = new Rectangle(new Point(740 -  (i * widthRow), 240),
                        widthRow, heightRow);
                Block block = new Block(rectangle, colors[5]);
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
        return new Point(325, 560);
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
}


