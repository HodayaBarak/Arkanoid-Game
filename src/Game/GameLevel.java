package Game;


import Collision.Rectangle;
import Collision.Block;
import Collision.Ball;
import Collision.SpriteCollection;
import GeometryPrimitives.Point;
import Collision.Paddle;
import Collision.Counter;
import Collision.ScoreIndicator;
import Collision.ScoreTrackingListener;
import Collision.Sprite;
import Collision.Collidable;
import Collision.BlockRemover;
import Collision.BallRemover;
import Collision.PrintingHitListener;
import GeometryPrimitives.Velocity;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;
import java.util.Random;


//206750911 Hodaya Machluf

    /** @author Hodaya Machluf
     * @version 19.0.2
     * @since 2023-05-04
     * The GameLevel class represents a game level that implements the Animation interface
     *
     */

    public class  GameLevel implements Animation {

        //define variables
        private SpriteCollection sprites;
        private GameEnvironment environment;
        private GUI gui;
        private Paddle paddle;
        private biuoop.KeyboardSensor keyboard;
        private Counter counterBlocks, counterBalls, score;
        private ScoreTrackingListener scoreTrack;
        private ScoreIndicator scoreIndicator;
        private AnimationRunner runner;
        private boolean running;
        private Block scoreBar;
        private Sprite backRoundS;
        private LevelInformation levelInformation;
        private String levelName;



        /**
         * constructor
         * <p>
         * creates new GameLevel object and initializes its fields.
         * </p>
         *
         * @param levelInformation Description: The information for the level.
         * @param keyboard         Description: The keyboard sensor.
         * @param aR               Description: The animation runner.
         * @param score            Description: The score counter.
         */
        public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner aR,
                         Counter score) {
            this.levelInformation = levelInformation;
            this.levelName = levelInformation.levelName();
            this.runner = aR;
            this.sprites = new SpriteCollection();
            this.environment = new GameEnvironment();
            this.counterBlocks = new Counter(levelInformation.numberOfBlocksToRemove());
            this.counterBalls = new Counter(levelInformation.numberOfBalls());
            this.score = score;
            this.scoreTrack = new ScoreTrackingListener(score);
            this.keyboard = keyboard;
            this.backRoundS = levelInformation.getBackground();
            this.scoreBar = new Block(new Rectangle(new Point(0, 0), 800, 20),
                    new Color(216, 255, 255));
            this.scoreBar.addToGame(this);
        }


        /**
         * addCollidable Method
         * <p>
         * addCollidable Method adds a collidable object to the game environment.
         * </p>
         *
         * @param c Description: the collidable object to add
         */
        public void addCollidable(Collidable c) {
            if ((c.equals(this.levelInformation.getBackground())) || (c.equals(this.scoreBar))) {
                return;
            }
            environment.addCollidable(c);
        }


        /**
         * addSprite Method
         * <p>
         * addCollidable Method adds a sprite object to the game.
         * </p>
         *
         * @param s Description: the sprite  object to add
         */
        public void addSprite(Sprite s) {
            sprites.addSprite(s);
        }

        /**
         * removeBlock Method
         * <p>
         * removeBlock Method removes the specified block from the game.
         * </p>
         *
         * @param beingHit Description: the sprite object (collision.Block) to remove
         */
        public void removeBlock(Block beingHit) {
            //if the list is empty
            if (sprites.getSprites().isEmpty()) {
                return;
            }
            // find the block in the list of sprites
            for (Sprite sprite : sprites.getSprites()) {
                // if the block is found - removes it from the list of sprites
                // and decrease the counter of blocks by 1
                if (sprite.equals(beingHit)) {
                    sprites.getSprites().remove(sprite);
                    counterBlocks.decrease(1);
                    break;
                }
            }
            //if the collidable list is empty - return
            if (this.environment.getCollidables().isEmpty()) {
                return;
            }
            // find the block in the list of collidable
            for (Collidable collidable : this.environment.getCollidables()) {
                // if the block is found - removes it from the list of collidable
                if (collidable.equals(beingHit)) {
                    this.environment.getCollidables().remove(collidable);
                    return;
                }
            }
        }


        /**
         * getRemaineBalls Method
         * <p>
         * getRemaineBalls Method returns the number of remaining balls.
         * </p>
         *
         * @return int
         */
        public int getRemaineBalls() {
            return this.counterBalls.getValue();
        }

        /**
         * getRemaineBlocks Method
         * <p>
         * getRemaineBlocks Method returns the number of remaining blocks.
         * </p>
         *
         * @return int
         */
        public int getRemaineBlocks() {
            return this.counterBlocks.getValue();
        }


        /**
         * removeBall Method
         * <p>
         * removeBall Method removes the specified block from the game.
         * </p>
         *
         * @param beingDead Description: the sprite object (collision.Ball) to remove
         */
        public void removeBall(Ball beingDead) {
            //if the list is empty
            if (sprites.getSprites().isEmpty()) {
                return;
            }
            // find the ball in the list of sprites
            for (Sprite sprite : sprites.getSprites()) {
                // if the ball is found - removes it from the list of sprites
                // and decrease the counter of balls by 1
                if (sprite.equals(beingDead)) {
                    sprites.getSprites().remove(sprite);
                    counterBalls.decrease(1);
                    break;
                }
            }
        }


        /**
         * addScoreIndicator Method
         * <p>
         * addScoreIndicator Method create new collision.ScoreIndicator object,
         * initialize it`s location on the surface, add it to the list of sprites
         * and adds the score indicator to the game.
         * </p>
         */
        public void addScoreIndicator() {
            this.scoreIndicator = new ScoreIndicator(score, this.levelName);
            // Set the position of the score indicator on the screen
            scoreIndicator.setPosition(350, 15);
            // Add the score indicator as a sprite to the game
            addSprite(scoreIndicator);
            scoreIndicator.addToGame(this);
        }




        /**
         * createBlocks Method
         * <p>
         * createBlocks Method creates a layout of blocks in the game.
         * </p>
         *
         * @param ballRemover         Description: The BallRemover object responsible for removing balls from the game.
         * @param blockRemover        Description: The BlockRemover object responsible for removing blocks from the
         *                            game.
         * @param printingHitListener Description: The PrintingHitListener object responsible for printing
         *                            hit events to the console.
         * @param colors              Description: An array of Color objects representing the colors of the blocks.
         */
        public void createBlocks(BallRemover ballRemover, BlockRemover blockRemover,
                                 PrintingHitListener printingHitListener, Color[] colors) {


            // Create the game borders
            Block leftBlock = new Block(new Rectangle(new Point(0, 20), 10, 600),
                    Color.gray.brighter());
            Block upperBlock = new Block(new Rectangle(new Point(0, 20), 800, 10),
                    Color.gray.brighter());
            Block rightBlock = new Block(new Rectangle(new Point(790, 20), 10, 600),
                    Color.gray.brighter());
            Block bottomBlock = new Block(new Rectangle(new Point(0, 590), 800, 10),
                    Color.gray.brighter());
            // add the ballRemover hit listener to the bottomBlock
            bottomBlock.addHitListener(ballRemover);

            //add the paddle and the game borders to the game

            leftBlock.addToGame(this);
            upperBlock.addToGame(this);
            rightBlock.addToGame(this);
            bottomBlock.addToGame(this);
            //add the scoreIndicator
            addScoreIndicator();


            for (Block block : levelInformation.blocks()) {

                if (block.equals(bottomBlock)) {
                    removeBlock(bottomBlock);
                    block.addToGame(this);
                    block.addHitListener(ballRemover);
                }
                    block.addHitListener(printingHitListener);
                    block.addToGame(this);
                    //add the blockRemover hit listener to the block
                    block.addHitListener(blockRemover);
                    // increases the counterBlocks by 1
                    //adds the scoreTrack hit listener to the block
                    block.addHitListener(scoreTrack);
                }
            }



        /**
         * initialize Method
         * <p>
         * initialize Method initializes the game by creating blocks, ball, and paddle, and adding them to the game.
         * the Method adds a sprite object to the game.
         * </p>
         */

        // Initialize a new game: create the Blocks and collision.Ball (and collision.Paddle)
        // and add them to the game.
        public void initialize() {
            BlockRemover blockRemover = new BlockRemover(this, this.counterBlocks);
            BallRemover ballRemover = new BallRemover(this, this.counterBalls);
            PrintingHitListener printingHitListener = new PrintingHitListener();
            biuoop.KeyboardSensor keyboard = this.runner.getGui().getKeyboardSensor();
            Color[] colors = new Color[20];
            // Generate random colors for the blocks and for the ball
            Random rand = new Random();
            for (int i = 0; i < 20; i++) {
                double r = rand.nextFloat() / 2f + 0.5;
                double g = rand.nextFloat() / 2f + 0.5;
                double b = rand.nextFloat() / 2f + 0.5;
                Color randomColor = new Color((float) r, (float) g, (float) b);
                randomColor.brighter();
                colors[i] = randomColor;
            }
            this.addSprite(this.backRoundS);
            // Create the paddle
            paddle = new Paddle(this.keyboard, this.levelInformation);
            paddle.addToGame(this);
            //add the scoreIndicator
            addScoreIndicator();

            createBlocks(ballRemover, blockRemover, printingHitListener, colors);

        }


        /**
         * doOneFrame Method.
         * <p>
         * doOneFrame Method executes one frame of the game.
         * </p>
         *
         * @param d Description: the surface to draw on.
         */
        @Override
        public void doOneFrame(DrawSurface d) {

            this.sprites.drawAllOn(d);

            // Call timePassed on all sprites
            this.sprites.notifyAllTimePassed();

            //If there are no blocks left in the game
            if (this.counterBlocks.getValue() == 0) {
                //Add 100 points to the score
                this.scoreTrack.levelCleared();
                //change running to false
                this.running = false;
            }
            //If there are no balls left in the game
            if (this.counterBalls.getValue() == 0) {
                //change running to false
                this.running = false;
            }
            // if the "p" button is pressed - create new PauseScreen object
            if (this.keyboard.isPressed("p")) {
                Animation pause = new PauseScreen(this.keyboard, KeyboardSensor.SPACE_KEY, this);
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, pause));
            }
        }

        /**
         * shouldStop Method.
         * <p>
         * shouldStop Method checks if the animation should stop.
         * </p>
         *
         * @return boolean.
         */
        @Override
        public boolean shouldStop() {
            return !this.running;
        }


        /**
         * createBallsOnTopOfPaddle Method.
         * <p>
         * createBallsOnTopOfPaddle Method creates balls on top of the paddle.
         * </p>
         */
        public void createBallsOnTopOfPaddle() {
            BlockRemover blockRemover = new BlockRemover(this, this.counterBlocks);
            //  Ball[] balls = new Ball[this.levelInformation.numberOfBalls()];
            List<Velocity> velocities = this.levelInformation.initialBallVelocities();
            for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
                Ball ball = new Ball(400, this.levelInformation.paddleUpperLeft().getY() - 25, 5,
                        this.levelInformation.ballColor());
                ball.setVelocity(levelInformation.initialBallVelocities().get(i));
                ball.addToGame(this);
                ball.setGameEnvironment(this.environment);
                ball.addHitListener(blockRemover);

            }
        }


        /**
         * run Method
         * <p>
         * Runs the game by initializing necessary components and starting the animation loop.
         * This method is invoked when the game is started.
         * </p>
         */

        public void run() {
            // Create balls on top of the paddle.
            this.createBallsOnTopOfPaddle();

            // Use the animation runner to run the countdown animation, which prepares the game for play.
            // The countdown animation displays a countdown before the game starts.
            this.runner.run(new CountdownAnimation(30, 3, this.sprites));

            // Set the game to running state.
            this.running = true;

            // Use the animation runner to run the current game animation.
            // This is the main animation loop that keeps the game running.
            this.runner.run(this);

        }
    }