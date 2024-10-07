package Collision;
//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-27
 * The collision.HitNotifier interface represents an object that can notify listeners of hit events.
 * Classes that implement this interface can add and remove hit listeners, and notify them when a hit event occurs.
 */
public interface HitNotifier {


    /**
     * addHitListener Method
     * <p>
     * addHitListener Method adds a hit listener to the list of listeners to be notified of hit events.
     * </p>
     * @param hl Description: the hit listener to be added
     */
    // Add hl as a listener to hit events.
    void addHitListener(HitListener hl);

    /**
     * removeHitListener Method
     * <p>
     * removeHitListener Method removes a hit listener from the list of listeners.
     * </p>
     * @param hl Description: the hit listener to be removed.
     */
    // Remove hl from the list of listeners to hit events.
    void removeHitListener(HitListener hl);

}