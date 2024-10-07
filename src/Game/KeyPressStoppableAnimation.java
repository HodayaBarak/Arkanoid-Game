package Game;


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The KeyPressStoppableAnimation class represents an animation that can be stopped by pressing a specific key on
 * the keyboard. It implements the Animation interface.
 */
public class KeyPressStoppableAnimation implements Animation {
    // define relevant variables
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean shouldStop;


    /**
     * constructor
     * <p>
     * creates new GameFlow object and initializes its fields.
     * </p>
     * @param sensor Description: The KeyboardSensor used to detect key presses.
     * @param key Description: The key that stops the animation when pressed.
     * @param animation Description: The animation to be played and stopped.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed  = true;
        this.shouldStop = false;

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
        this.animation.doOneFrame(d);
        // Check if the key is pressed and update the state variables accordingly.

        if ((sensor.isPressed(key) && !(isAlreadyPressed))) {
            this.shouldStop = true;
        }

        if (sensor.isPressed(key)) {
            this.isAlreadyPressed = false;
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
     //   return shouldStop;
        return this.shouldStop;
    }
}
