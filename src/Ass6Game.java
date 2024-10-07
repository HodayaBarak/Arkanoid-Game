
import Game.LevelInformation;
import Game.DirectHit;
import Game.WideEasy;
import Game.Green3;
import Game.AnimationRunner;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;

import Game.GameFlow;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * The Ass6Game class represents the main class for the Ass6Game program.
 * It initializes and runs the game.
 *
 */

public class Ass6Game {
    /**
     * main Method.
     * <p>
     * main Method id the main method of the program.
     * </p>
     *
     * @param args Description: command-line arguments.
     */
    public static void main(String[] args) {
        int[] levelsList = new int[args.length];
//        int[] levelsList = new int[0];
        ArrayList<LevelInformation> levelInformations = new ArrayList<>();
        GUI gui = new GUI("Game", 800, 600);
        AnimationRunner animationRunner = new AnimationRunner(gui, 60);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor);

        LevelInformation level1 = new DirectHit(gui);
        LevelInformation level2 = new WideEasy(gui);
        LevelInformation level3 = new Green3(gui);


        for (String arg : args) {
            try {
                // add levels based on the levels list
                if (Integer.parseInt(arg) == 1) {
                    levelInformations.add(level1);
                }
                if (Integer.parseInt(arg) == 2) {
                    levelInformations.add(level2);
                }
                if (Integer.parseInt(arg) == 3) {
                    levelInformations.add(level3);
                }
            } catch (NumberFormatException e) {
                // Ignore tokens that cannot be parsed as integers
                continue;
            }
        }
        // if the list is empty - arranged the levels in default order
        if (levelInformations.isEmpty()) {
            levelInformations.add(level1);
            levelInformations.add(level2);
            levelInformations.add(level3);


            // run the levels
            gameFlow.runLevels(levelInformations);

            // Close the GUI window
            animationRunner.getGui().close();


        }
    }
}