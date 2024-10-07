package Game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The AnimationRunner class is responsible for running an animation by continuously displaying frames on a GUI.
 */

public class AnimationRunner {
    //define variable
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor.
     * <p>
     * creates a new AnimationRunner  with the given GUI and frames per second.
     * </p>
     * @param gui Description:  the GUI on which to display the animation.
     * @param framesPerSecond Description: the desired frames per second for the animation.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();
    }


    /**
     * getGui Method.
     * <p>
     * getGui Method returns the GUI associated with this AnimationRunner.
     * </p>
     * @return GUI
     */
    public GUI getGui() {
        return this.gui;
    }



    /**
     * run Method.
     * <p>
     * run Method runs the given Animation by continuously displaying frames on the GUI until the
     * Animation should stop.
     * </p>
     * @param animation Description: the Animation to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            // Draw all sprites on the GUI
            DrawSurface d = gui.getDrawSurface();
            // perform one frame of the animation
            animation.doOneFrame(d);
            // display the animation
            gui.show(d);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }

    }

}