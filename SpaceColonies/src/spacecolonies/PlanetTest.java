package spacecolonies;

/**
 * test class for planets
 * 
 * @author Hamza Saif
 * @version 04/12/2020
 *
 */
public class PlanetTest extends student.TestCase {
    private Planet maxSkills;
    private Planet maxSkills2;
    private Planet maxSkills3;
    private Planet maxSkills4;

    private Planet maxTech;
    private Planet maxMed;
    private Planet nullPlanet;

    private Person maxPerson;
    private Person person3;
    private Person person2;
    private Person person4;
    private Person nullPerson;

    /**
     * sets up before each method
     */
    public void setUp() {
        maxSkills = new Planet("Jupiter", 5, 5, 5, 2);
        maxSkills2 = new Planet("Jupiter", 5, 5, 5, 2);
        maxSkills3 = new Planet("Jupiter", 5, 5, 5, 2);
        maxSkills4 = new Planet("Jupiter", 5, 5, 5, 1);

        maxMed = new Planet("Mars", 5, 1, 1, 0);
        maxTech = new Planet("Mars", 5, 5, 5, 0);
        nullPlanet = null;

        maxPerson = new Person("name1", 5, 5, 5, "Jupiter");
        person2 = new Person("name2", 5, 5, 0, "Jupiter");
        person3 = new Person("name3", 5, 0, 5, "Jupiter");
        person4 = new Person("name4", 0, 5, 5, "Jupiter");
        nullPerson = null;

    }


    /**
     * tests the method for any buggers
     */
    public void testSetName() {
        maxSkills.setName("Fade");
        assertEquals("Fade", maxSkills.getName());
    }


    /**
     * tests the method for any buggers
     */
    public void testGetName() {
        assertEquals("Jupiter", maxSkills.getName());
    }


    /**
     * tests the method for any buggers
     */
    public void testGetSkills() {

        assertEquals("A:5 M:5 T:5", maxSkills.getSkills().toString());

    }


    /**
     * tests the method for any buggers
     */
    public void testGetPopulation() {
        assertEquals(2, maxSkills.getPopulation().length);
    }


    /**
     * tests the method for any buggers
     */
    public void testGetPopulationSize() {
        assertEquals(0, maxSkills.getPopulationSize());
        maxSkills.addPerson(person4);
        maxSkills.addPerson(maxPerson);
        maxSkills.addPerson(maxPerson);
        maxSkills.addPerson(maxPerson);
        assertEquals(2, maxSkills.getPopulationSize());
    }


    /**
     * tests the method for any buggers
     */
    public void testGetCapacity() {
        assertEquals(2, maxSkills.getCapacity());
    }


    /**
     * tests the method for any buggers
     */
    public void testGetAvailability() {
        assertEquals(2, maxSkills.getAvailability());
    }


    /**
     * tests the method for any buggers
     */
    public void testIsFull() {
        assertFalse(maxSkills.isFull());
        maxSkills.addPerson(maxPerson);
        maxSkills.addPerson(maxPerson);
        assertTrue(maxSkills.isFull());

    }


    /**
     * tests the method for any buggers
     */
    public void testAddPerson() {
        assertTrue(maxSkills.addPerson(maxPerson));
        assertFalse(maxSkills.addPerson(nullPerson));
        assertFalse(maxSkills.addPerson(person2));
    }


    /**
     * tests the method for any buggers
     */
    public void testIsQualified() {
        assertTrue(maxSkills.isQualified(maxPerson));
        assertFalse(maxSkills.isQualified(person4));
        assertFalse(maxSkills.isQualified(person3));
        assertFalse(maxSkills.isQualified(person2));

    }


    /**
     * tests the method for any buggers
     */
    public void testToString() {
        assertEquals(maxSkills.toString(),
            "Jupiter, population: 0, capacity: 2, Requires: A = 5 M = 5 T = 5");
    }


    /**
     * tests the method for any buggers
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {

        maxSkills3.addPerson(maxPerson);

        assertTrue(maxSkills.equals(maxSkills));
        assertTrue(maxSkills.equals(maxSkills2));

        assertFalse(maxSkills.equals(maxSkills3));
        assertFalse(maxSkills.equals(maxSkills4));
        assertFalse(maxSkills.equals(nullPlanet));
        assertFalse(maxTech.equals(maxMed));
        assertFalse(maxSkills.equals(maxTech));
        assertFalse(maxSkills.equals("dd"));

    }


    /**
     * tests the method for any buggers
     */
    public void testCompareTo() {
        assertEquals(1, maxSkills.compareTo(maxMed));
        assertEquals(0, maxSkills.compareTo(maxSkills2));
        assertEquals(-1, maxMed.compareTo(maxSkills));

    }
}
