package spacecolonies;

/**
 * test clacc
 * 
 * @author Hamza
 * @version 04/18/2022
 */
public class ColonyCalculatorTest extends student.TestCase {
    private ColonyCalculator calc;
    private Planet maxSkills;

    private Planet midSkills;
    private Planet minSkills;

    private Person maxPerson;
    private Person maxPerson2;
    private Person nullPerson;

    private ArrayQueue<Person> applicantQueue;

    private Planet[] planets;

    /**
     * sets up before test methods
     */
    public void setUp() {

        maxSkills = new Planet("maxSkills", 5, 5, 5, 1);
        midSkills = new Planet("midSkills", 3, 3, 3, 3);
        minSkills = new Planet("minSkills", 2, 2, 2, 5);

        // maxMed = new Planet("Mars", 5, 1, 1, 0);
        // maxTech = new Planet("Mars", 5, 5, 5, 0);
        // person4 = new Person("name4", 0, 5, 5, "Jupiter");

        maxPerson = new Person("maxPerson", 5, 5, 5, "maxSkills");
        maxPerson2 = new Person("maxPerson", 5, 5, 5, "maxSkills");

        nullPerson = null;

        applicantQueue = new ArrayQueue<Person>(6);
        applicantQueue.enqueue(maxPerson);

        planets = new Planet[3];
        planets[0] = maxSkills;
        planets[1] = midSkills;
        planets[2] = minSkills;

        calc = new ColonyCalculator(applicantQueue, planets);
    }


    /**
     * tests the method for any buggers
     */
    public void testgetPlanetForPerson() {

        Person midPerson = new Person("midPerson", 3, 3, 3, "maxSkills");
        Person minPerson = new Person("minPerson", 2, 2, 2, "minSKills");
        Person noPrefPerson = new Person("noPrefPerson", 2, 2, 2, "");
        Person invalidPrefPerson = new Person("invalidPrefPerson", 2, 2, 2,
            "noPref");
        Person rejectPerson = new Person("rejectPerson", 1, 1, 1, "minSKills");

        applicantQueue.enqueue(midPerson);
        applicantQueue.enqueue(minPerson);
        applicantQueue.enqueue(noPrefPerson);
        applicantQueue.enqueue(invalidPrefPerson);

        assertNull(calc.getPlanetForPerson(nullPerson));
        assertEquals(minSkills, calc.getPlanetForPerson(noPrefPerson));
        assertEquals(null, calc.getPlanetForPerson(rejectPerson));
        assertEquals(minSkills, calc.getPlanetForPerson(invalidPrefPerson));
        assertEquals(maxSkills, calc.getPlanetForPerson(maxPerson));
        maxSkills.addPerson(maxPerson2);
        assertEquals(null, calc.getPlanetForPerson(maxPerson));

    }


    /**
     * tests the method for any buggers
     */
    public void testGetPlanetIndex() {

        assertEquals(0, calc.getPlanetIndex("maxSkills"));
        assertEquals(1, calc.getPlanetIndex("midSkills"));
        assertEquals(2, calc.getPlanetIndex("minSkills"));

        assertEquals(-1, calc.getPlanetIndex("thisis"));
    }


    /**
     * tests the method for any buggers
     */
    public void testGetPlanets() {
        assertEquals(planets[1], midSkills);
        assertEquals(planets, calc.getPlanets());
    }


    /**
     * tests the method for any buggers
     */
    public void testGetQueue() {
        assertEquals(applicantQueue, calc.getQueue());

    }


    /**
     * tests the method for any buggers
     */
    public void testAccept() {

        assertTrue(calc.accept());
        assertFalse(calc.accept());
    }

}
