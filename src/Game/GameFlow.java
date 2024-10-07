package Game;

import Collision.SpriteCollection;
import Collision.Counter;
import Collision.ScoreTrackingListener;
import biuoop.KeyboardSensor;
import java.util.List;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-06-13
 * The GameFlow class represents the flow of the game, including initializing components and running game levels.
 * It uses an AnimationRunner and KeyboardSensor for game interaction.
 */
public class GameFlow {
    // define relevant variables
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private biuoop.KeyboardSensor keyboard;
    private Counter score;
    private ScoreTrackingListener scoreTrack;
    private AnimationRunner runner;
    private int flag;
    private Animation gameOver, youWin;


    /**
     * constructor
     * <p>
     * creates new GameFlow object and initializes its fields.
     * </p>
     * @param ks Description: The KeyboardSensor used to handle keyboard input.
     * @param ar Description: The AnimationRunner used to run the game's animations.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.runner = ar;
        this.environment = new GameEnvironment();
        this.score = new Counter(0);
        this.scoreTrack = new ScoreTrackingListener(score);
        this.keyboard = ks;
        this.flag = 1;



    }


    /**
     * runLevels
     * <p>
     * the method Runs the game levels provided in the list.
     * </p>
     * @param levels Description: The KeyboardSensor used to handle keyboard input.
     */
    public void runLevels(List<LevelInformation> levels) {

       // Create a new GameLevel instance for the current level.
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo,
                    this.keyboard,
                    this.runner, this.score);

            // Initialize the current level.
            level.initialize();

            // Create animations for winning and pausing the game.
            this.youWin = new YouWinAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, level, this.score);
            Animation gameOverAnimation = new GameOverAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, level,
                    this.score);
            this.gameOver = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    gameOverAnimation);

            // Run the current level as long as there are remaining balls and blocks.
            while ((level.getRemaineBalls() > 0) && (level.getRemaineBlocks() > 0)) {
                level.run();
                }


            // If there are no remaining balls, show the game over animation and end the loop.
            if (level.getRemaineBalls() == 0) {
               runner.run(gameOver);
                this.flag = 0;
                break;
            }

        }
        // If the game was ended prematurely, return from the method.
        if (this.flag == 0) {
            return;
        }
        // Create the win animation and run it.
        this.youWin = new YouWinAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, this.youWin, this.score);
        Animation win = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, youWin);
        this.runner.run(win);
    }
}
