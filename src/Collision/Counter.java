package Collision;
//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-27
 * The collision.Counter class represents a simple counter that holds an integer value.
 * This class is actually used to enumerate and update the number of objects
 * in the game and the user's score.
 */
public class Counter {
    //define variable for the counter
    private int number;

    /**
     * constructor.
     * <p>
     * creates new collision.Counter object with the specified initial value.
     * </p>
     * @param number Description: the initial value of the counter.
     */
    public Counter(int number) {
        this.number = number;
    }

    /**
     * increase Method
     * <p>
     * increase Method increases the counter value by the specified amount.
     * </p>
     * @param number Description: the number that added to the current counter`s amount. */
   public void increase(int number) {
        // add number to current count.
        this.number = this.number + number;
    }

    /**
     * decrease Method
     * <p>
     * decrease Method decrease the counter value by the specified amount.
     * </p>
     * @param number Description: the number that subtract from the current counter`s amount. */
    public void decrease(int number) {
        // subtract number from current count.
        this.number = this.number - number;
    }

    /**
     * getValue Method
     * <p>
     * getValue Method Returns the current value of the counter.
     * </p>
     * @return int
     */
    public int getValue() {
        // get current count.
        return this.number;
    }
}