package Collision;
import Game.GameLevel;
import GeometryPrimitives.Line;
import GeometryPrimitives.Point;
import GeometryPrimitives.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import Game.LevelInformation;
import java.awt.Color;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * Class collision.SpriteCollection represents a paddle in the game.
 * Implements the collision.Sprite and collision.Collidable interfaces.
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block paddle;
    private LevelInformation levelInformation;
    private Point upperLeft, upperRight;
    private Point midleft;
    private Point midlright;
    private Point middle;
    private Rectangle rect;
    private Velocity velocity;
    private Block paddleBlock;
    private int width, height;
    private Line leftBorder = new Line(new Point(10, 0), new Point(10, 600));
    private Line rightBorder = new Line((new Point(790, 0)), new Point(790, 600));


    /**
     * constructor
     * <p>
     * creates new collision.Paddle object and assigns the rectangle and it`s color in the block`s fields.
     * </p>
     * @param keyboard Description:  The keyboard sensor used to control the paddle..
     */

    public Paddle(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
        this.upperLeft = new Point(275, 560);
        this.width = 150;
        this.height = 10;
        this.rect = new Rectangle(this.upperLeft,   this.width,  this.height);
        this.paddle = new Block(this.rect, Color.BLACK);
    }

    /**
     * constructor
     * <p>
     * creates new collision.Paddle object and assigns the rectangle and it`s color in the block`s fields.
     * </p>
     * @param keyboard Description: The keyboard sensor used to control the paddle.
     * @param levelInformation Description: the LevelInformation object containing information about the level
     */
    public Paddle(KeyboardSensor keyboard, LevelInformation levelInformation) {
        this.keyboard = keyboard;
        this.upperLeft = levelInformation.paddleUpperLeft();
        this.levelInformation = levelInformation;
        this.width = levelInformation.paddleWidth();
        this.height = levelInformation.paddleHeight();
        this.rect = new Rectangle(this.upperLeft, this.width,  this.height);
        this.paddle = new Block(this.rect, levelInformation.paddleColor());
    }


    /**
     * getWidth Method
     * <p>
     * getWidth Method returns the width of the paddle.
     * </p>
     * @return int.
     */
    public int getWidth() {
        return this.width;
    }


    /**
     * moveLeft Method
     * <p>
     * moveLeft Method moves the paddle to the left.
     * If the paddle reaches the left border, it stays in place.
     * </p>
     */
    public void moveLeft() {
        if (this.paddle.getCollisionRectangle().getUpperParallelX().isIntersecting(leftBorder)) {
            return;
        }
        this.paddle = new Block(new Rectangle(new Point(
                (this.paddle.getCollisionRectangle().getUpperLeft().getX() - this.levelInformation.paddleSpeed()),
                levelInformation.paddleUpperLeft().getY()), this.levelInformation.paddleWidth(), this.height),
                 levelInformation.paddleColor());
    }


    /**
     * moveRight Method
     * <p>
     * moveRight Method moves the paddle to the right.
     * If the paddle reaches the right border, it stays in place.
     * </p>
     */

    public void moveRight() {
        if ((this.paddle.getCollisionRectangle().getUpperParallelX().isIntersecting(rightBorder))) {
            return;
        }

        this.paddle = new Block(new Rectangle(new Point(
                (this.paddle.getCollisionRectangle().getUpperLeft().getX() + this.levelInformation.paddleSpeed()),
                levelInformation.paddleUpperLeft().getY()), this.width, this.height), levelInformation.paddleColor());

    }




    // collision.Sprite

    /**
     * timePassed Method
     * <p>
     * timePassed Method performs the logic of the paddle for a single frame.
     * Moves the paddle to the left or right based on the keyboard input
     * </p>
     */
    public void timePassed() {
        //if the user presset the right key in the keyboard
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            //move the paddle to the right
            moveRight();
        }
        //if the user presset the left key in the keyboard
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            //move the paddle to the left
            moveLeft();
        }

    }

    /**
     * drawOn Method
     * <p>
     * drawOn Method draws the paddle on the given DrawSurface.
     * </p>
     * @param d Description: The DrawSurface to draw on.
     */
    public void drawOn(DrawSurface d) {
        paddle.drawOn(d);

    }

    /**
     * getCollisionRectangle Method
     * <p>
     * getCollisionRectangle Method returns the collision rectangle of the paddle..
     * </p>
     * @return collision.Rectangle.
     */
    // collision.Collidable
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * getRectangleUpperPointX Method
     * <p>
     * getRectangleUpperPointX Method returns the x-coordinate of the upper-left point of the collision rectangle.
     * </p>
     * @return double.
     */
    public double getRectangleUpperPointX() {
        return this.paddle.getCollisionRectangle().getUpperLeft().getX();
    }

    /**
     * getRectangleUpperPointY Method
     * <p>
     * getRectangleUpperPointY Method returns the y-coordinate of the upper-left point of the collision rectangle.
     * </p>
     * @return double.
     */
    public double getRectangleUpperPointY() {
        return this.paddle.getCollisionRectangle().getUpperLeft().getY();
    }


    /**
     * hit Method
     *  <p>
     * hit Method determines the new velocity of the ball after a collision with the paddle according to the location
     * of the collosion point.
     * </p>
     * @param collisionPoint Description: The point of collision between the ball and the paddle.
     * @param currentVelocity Description: The current velocity of the ball.
     * @return The new velocity of the ball after the collision.
     */

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //divided the rectangle upper side to 5
        double regionSize = this.getCollisionRectangle().getWidth() / 5;

        Point upperLeft = this.getCollisionRectangle().getUpperLeft();
        double y = upperLeft.getY();

        // divided the rectangle upper side to 5 lines
        Line regionOne = new Line(upperLeft, new Point((upperLeft.getX() + regionSize), y));

        Line regionTwo = new Line(new Point((upperLeft.getX() + regionSize), y),
                new Point((upperLeft.getX() + (2 * regionSize)), y));

        Line regionThree = new Line(new Point((upperLeft.getX() + (2 * regionSize)), y),
                new Point((upperLeft.getX() + (3 * regionSize)), y));

        Line regionFour = new Line(new Point((upperLeft.getX() + (3 * regionSize)), y),
                new Point((upperLeft.getX() + (4 * regionSize)), y));


        Line regionFive = new Line(new Point((upperLeft.getX() + (4 * regionSize)), y),
                new Point((upperLeft.getX() + (5 * regionSize)), y));

        //assign the current velocity in local variables
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();


        // Check if the collision point is within each region of the paddle


        if (regionOne.pointOnLine(collisionPoint)) {
            // upadete the velocity angle
            currentVelocity = currentVelocity.fromAngleAndSpeed(300, Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            return currentVelocity;
        }
        if (regionTwo.pointOnLine(collisionPoint)) {
            // upadete the velocity angle
            currentVelocity = currentVelocity.fromAngleAndSpeed(330, Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
            return currentVelocity;
        }
        if (regionThree.pointOnLine(collisionPoint)) {
            // upadete the velocity angle
            currentVelocity = currentVelocity.fromAngleAndSpeed(0, Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            return currentVelocity;
        }
        if (regionFour.pointOnLine(collisionPoint)) {
            // upadete the velocity angle
            currentVelocity = currentVelocity.fromAngleAndSpeed(30, Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            return currentVelocity;
        }

        if (regionFive.pointOnLine(collisionPoint)) {
            // upadete the velocity angle
            currentVelocity = currentVelocity.fromAngleAndSpeed(60, Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

            return currentVelocity;
        }

        // If the collision point hits the left or right side of the paddle
        if ((this.getCollisionRectangle().getLeftParallelY().pointOnLine(collisionPoint))
                || (this.getCollisionRectangle().getRightParallelY().pointOnLine(collisionPoint))) {

            // the velocity changed to (-dx,dy)
            currentVelocity.setVelocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }

        return currentVelocity;
    }

    /**
     * addToGame Method
     * <p>
     * addToGame Method adds the paddle as a collidable and a sprite to the given game.
     *  * This method
     * </p>
     * @param g Description: The game to which the paddle should be added.
     */
    // Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}