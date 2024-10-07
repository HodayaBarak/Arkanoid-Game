package Game;

import Collision.Block;
import GeometryPrimitives.Point;
import GeometryPrimitives.Velocity;
import Collision.Sprite;

import java.awt.Color;
import java.util.List;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The LevelInformation interface defines the properties and methods required for a game level.
 */
public interface LevelInformation {


    /**
     * numberOfBalls Method.
     * <p>
     * numberOfBalls Method returns the number of balls in the level.
     * </p>
     * @return int
     */
    int numberOfBalls();


    /**
     * initialBallVelocities Method.
     * <p>
     * initialBallVelocities Method returns the initial velocities of the balls in the level.
     * </p>
     * @return List of Velocity type objects.
     */
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed Method.
     * <p>
     * paddleSpeed Method returns the speed of the paddle in the level.
     * </p>
     * @return int
     */
    int paddleSpeed();

    /**
     * paddleWidth Method.
     * <p>
     * paddleWidth Method returns the width of the paddle in the level.
     * </p>
     * @return int
     */
    int paddleWidth();

    /**
     * levelName Method.
     * <p>
     * levelName Method returns the name of the level.
     * </p>
     * @return String
     */
    // the level name will be displayed at the top of the screen.
    String levelName();

    /**
     * getBackground Method.
     * <p>
     * getBackground Method returns the background sprite of the level.
     * </p>
     * @return Sprite
     */
    // Returns a sprite with the background of the level
    Sprite getBackground();

    /**
     * blocks Method.
     * <p>
     * blocks Method returns he list of blocks in the level.
     * </p>
     * @return  List of Block type objects.
     */
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    List<Block> blocks();

    /**
     * numberOfBlocksToRemove Method.
     * <p>
     * numberOfBlocksToRemove Method returns the number of blocks to remove in the level.
     * </p>
     * @return int
     */
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    int numberOfBlocksToRemove();

    /**
     * paddleUpperLeft Method.
     * <p>
     * paddleUpperLeft Method returns the upper-left point of the paddle in the level.
     * </p>
     * @return Point
     */
    Point paddleUpperLeft();

    /**
     * paddleColor Method.
     * <p>
     * paddleColor Method returns the color of the paddle in the level.
     * </p>
     * @return Color
     */
     Color paddleColor();

    /**
     * BallColor Method.
     * <p>
     * BallColor Method returns the color of the balls in the level.
     * </p>
     * @return Color
     */
     Color ballColor();

    /**
     * paddleHeight Method.
     * <p>
     * paddleHeight Method returns the height of the paddle in the level.
     * </p>
     * @return int
     */
     int paddleHeight();
}