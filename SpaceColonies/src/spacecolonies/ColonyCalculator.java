package spacecolonies;

// import queue.EmptyQueueExceptions;
import java.util.Arrays;
import list.AList;

/**
 * The ColonyCalculator class handles all the major calculations and
 * decision-making for the program
 * 
 * @author Hamza Saif (hsaif)
 * @version 04/17/2020
 */
public class ColonyCalculator {

    /**
     * number of planets
     */
    public static final int NUM_PLANETS = 3;
    /**
     * min skill level
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * max skill level
     */
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectbus;
    private Planet[] planets;

    /**
     * creates a colonyCalculator object that takes in a person and planet
     * 
     * @param person
     *            the person
     * @param planet
     *            the planet
     */
    public ColonyCalculator(ArrayQueue<Person> person, Planet[] planet) {
        if (person == null) {
            throw new IllegalArgumentException();
        }
        applicantQueue = person;
        planets = planet;
        rejectbus = new AList<Person>();

    }


    /**
     * method determines if the next person can be accepted to a planet
     * 
     * @param nextPerson
     *            thenextperson in the queue
     * @return
     *         returns the planet that applicant qualified to, or null if didnt
     *         meet any of the planets criteria
     */

    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson != null) {

            if (getPlanetIndex(nextPerson.getPlanetPreference()) != -1) {
                if (canAccept(nextPerson, planets[getPlanetIndex(nextPerson
                    .getPlanetPreference())])) {
                    return planets[getPlanetIndex(nextPerson
                        .getPlanetPreference())];
                }
                else {
                    return null;
                }
            }
            else { // do i need to check for invalid pref ?
                return getHighestCapacity(nextPerson);
            }
        }
        return null;
    }


    /**
     * Helper method determines if the applicant can be accepted
     * 
     * @param nextPerson
     *            the next person
     * @param planet
     *            the planet
     * @return true if can be accepeted
     */
    private boolean canAccept(Person nextPerson, Planet planet) {
        return !planet.isFull() && planet.isQualified(nextPerson);
    }


    /**
     * gets the highest avaiable capacity of a planet
     * 
     * @param newbie
     *            the person
     * @return
     *         the array
     */
    private Planet getHighestCapacity(Person newbie) {
        Planet[] copy = new Planet[planets.length];
        copy = Arrays.copyOf(planets, planets.length);
        Arrays.sort(copy);
        for (int i = NUM_PLANETS - 1; i >= 0; i--) {
            if (canAccept(newbie, copy[i])) {
                return copy[i];
            }
        }
        return null;
    }


    /**
     * attempts to accept the next applicant. Uses the planetPrefernce of the
     * person in the queue
     * 
     * @return returns false if it failed to accept
     */
    public boolean accept() { // not used anywhere ??
        if (!applicantQueue.isEmpty()) {

            Planet planetPref = getPlanetForPerson(applicantQueue.getFront());

            if (planetPref != null) {
                planetPref.addPerson(applicantQueue.dequeue());
                return true;
            }
        }
        return false;
    }


    /**
     * removes the person from the queue and adds them to the reject bus
     */
    public void reject() {
        rejectbus.add(applicantQueue.dequeue());
    }


    /**
     * return the index of the planet
     * 
     * @param planet
     *            the planet
     * @return the int representation for the given String (planet name). or -1
     *         if it does not match any
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < NUM_PLANETS; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * getter method for the queue.
     * 
     * @return applicantQueue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;

    }


    /**
     * getter method for the planets
     * 
     * @return planets
     */
    public Planet[] getPlanets() {
        return planets;
    }
}
