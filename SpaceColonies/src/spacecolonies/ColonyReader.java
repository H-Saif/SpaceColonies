package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * reader class
 * 
 * @author Hamza Saif
 * @version 04.17,2020
 *
 */
public class ColonyReader {

    /**
     * Colony reader takes in two parameters, one for the queue and one for
     * planet
     * 
     * @param applicantFileName
     *            queue
     * @param planetFileName
     *            planet
     * @throws FileNotFoundException
     *             if the file was not found
     * @throws java.text.ParseException
     *             if the number of elements was not 5
     * @throws SpaceColonyDataException
     *             if the skills are not in skill range
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {

        Planet[] planetData = readPlanetFile(planetFileName);// is this needed ?
        ArrayQueue<Person> personData = readQueueFile(applicantFileName);
        new SpaceWindow(new ColonyCalculator(personData, planetData));

    }
 

    /**
     * helper method to determine if the skills are in skill range
     * 
     * @param num1
     *            agri
     * @param num2
     *            md
     * @param num3
     *            tech
     * @return
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        return ((num1 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num1 <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (num2 >= ColonyCalculator.MIN_SKILL_LEVEL
                && num2 <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (num3 >= ColonyCalculator.MIN_SKILL_LEVEL
                && num3 <= ColonyCalculator.MAX_SKILL_LEVEL));
    }


    /**
     * reader method for the planet file,
     * 
     * @param fileName
     *            the file name
     * @return
     *         the planets from the input file
     * @throws FileNotFoundException
     *             if the file was not found
     * @throws java.text.ParseException
     *             if the number of elements was not 5
     * @throws SpaceColonyDataException
     *             if the skills are not in skill range
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        java.text.ParseException,
        SpaceColonyDataException {

        Planet[] tempPlanets = new Planet[3];
        Scanner file = new Scanner(new File(fileName));

        int planetCount = 0;
        while (file.hasNextLine() && planetCount < 4) {
            String currline = file.nextLine();
            Scanner file2 = new Scanner(currline).useDelimiter(",\\s*");
            String[] value = new String[5];

            int tokenCount = 0;
            while(file2.hasNext() && tokenCount <= 5) {
                
                value[tokenCount++] = file2.next();
            }
            
            if (tokenCount != 5) {

                throw new java.text.ParseException(
                    "The number of elements was not 5 for planet", value.length);

            }

            String planetName = "";
            int planetAgri = 0;
            int planetMedi = 0;
            int planetTech = 0;
            int planetCap = 0;

            planetName = value[0];
            planetAgri = Integer.parseInt(value[1]);
            planetMedi = Integer.parseInt(value[2]);
            planetTech = Integer.parseInt(value[3]);
            planetCap = Integer.parseInt(value[4]);

            if (!isInSkillRange(planetAgri, planetMedi, planetTech)) {

                throw new SpaceColonyDataException("Skill is not in range");

            }

            Planet temp = new Planet(planetName, planetAgri, planetMedi,
                planetTech, planetCap);

            tempPlanets[planetCount] = temp;
            planetCount++;

        }
        if (planetCount < 3) {
            throw new SpaceColonyDataException("Less than required");
        }
        file.close();
        return tempPlanets;
    }


    /**
     * Reader method for the queuefile
     * @param fileName
     * @return the array queue of the peoples
     * @throws FileNotFoundException
     *             if the file was not found
     * @throws java.text.ParseException
     *             if the number of elements was not 5
     * @throws SpaceColonyDataException
     *             if the skills are not in skill range
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        java.text.ParseException,
        SpaceColonyDataException {
        
        ArrayQueue<Person> queue = new ArrayQueue<Person>(20); // ??
        Scanner file = new Scanner(new File(fileName));

        while (file.hasNextLine()) {
            
            String currline = file.nextLine();
            Scanner file2 = new Scanner(currline).useDelimiter(",\\s*");
            String[] value = new String[5];
            int tokenCount = 0;
            while(file2.hasNext() && tokenCount < 5) {
                
                value[tokenCount++] = file2.next();
            }

            if (tokenCount < 4 || tokenCount > 5) {
                
                System.out.println(tokenCount);
                System.out.println(currline);
                
                throw new java.text.ParseException( 
                    "The number of elements was not 5 for queue", tokenCount);

            }

            String personName = "";
            int personAgri = 0;
            int personMedi = 0;
            int personTech = 0;
            String personPrefence = "";

            personName = value[0];
            personAgri = Integer.parseInt(value[1]);
            personMedi = Integer.parseInt(value[2]);
            personTech = Integer.parseInt(value[3]);
            personPrefence = value[4]; 

            if (!isInSkillRange(personAgri, personMedi, personTech)) {

                throw new SpaceColonyDataException("Skill is not in range");

            }

            Person temp = new Person(personName, personAgri, personMedi,
                personTech, personPrefence);

            queue.enqueue(temp);

        }

        file.close();
        return queue;
    }
}
