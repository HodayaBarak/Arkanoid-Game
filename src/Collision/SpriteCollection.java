package Collision;

import biuoop.DrawSurface;

import java.util.ArrayList;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * Class collision.SpriteCollection  represents a collection of sprites.
 *  It provides methods to add sprites, update their time, and draw them on a surface.
 */

public class SpriteCollection {
    //define a relevent variable
    private ArrayList<Sprite> sprites;

    /**
     * constructor
     * <p>
     * creates new collision.SpriteCollection object and initializes the collection of
     * sprites as an empty ArrayList.
     * </p>
     */
    public SpriteCollection() {
        sprites = new ArrayList<Sprite>();
    }

    /**
     * addSprite Method
     * <p>
     * addSprite Method adds a sprite to the collection.
     * </p>
     * @param s Description: The sprite to be added.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }


    /**
     * notifyAllTimePassed Method
     * <p>
     * notifyAllTimePassed Method Updates the time for all sprites in the collection.
     * Calls the timePassed() method on each sprite.
     * </p>
     */

    public void notifyAllTimePassed() {
        // call timePassed() on all sprites.
        for (int i = 0; i < sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }


    /**
     * drawAllOn Method
     *  <p>
     * drawAllOn Method Draws all sprites in the collection on the specified surface.
     * </p>
     * @param d Description: The DrawSurface on which to draw the sprites.
     */

    public void drawAllOn(DrawSurface d) {
        // call drawOn(d) on all sprites.
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);

        }
    }

    /**
     * getSprites Method
     * <p>
     * getSprites method returns the list of sprites.
     * </p>
     * @return ArrayList <>. */
    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
}