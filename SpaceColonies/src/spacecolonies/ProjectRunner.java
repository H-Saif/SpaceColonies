package spacecolonies;

import java.io.FileNotFoundException;
import java.text.ParseException;



/**
 * project runner class that contains the main method
 * 
 * @author Hamza Saif (hsaif)
 * @version 04/17/2020
 */
public class ProjectRunner {

    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {

        if (args.length == 2) {
            new ColonyReader(args[0], args[1]);
        }
        else {
            new ColonyReader("input.txt", "planets.txt");
        }

    }
}
