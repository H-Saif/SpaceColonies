package spacecolonies;

/**
 * test class for person
 * 
 * @author Hamza Saif (hsaif)
 * @version 04/17/2020
 */
public class PersonTest extends student.TestCase {
    private Person maxPerson;
    private Person maxPerson2;
    private Person maxPerson3;
    private Person minPerson;
    private Person namePerson;

    private Person noPerson;
    private Person nullPerson;

    /**
     * sets up before each method
     */
    public void setUp() {
        maxPerson = new Person("Test1", 5, 5, 5, "jupiter");
        maxPerson2 = new Person("Test1", 5, 5, 5, "jupiter");
        maxPerson3 = new Person("Test1", 5, 5, 5, "venus");

        namePerson = new Person("Test2", 5, 5, 5, "venus");
        minPerson = new Person("Test1", 1, 1, 1, "mars");

        noPerson = new Person("Test1", 2, 2, 2, "");
        nullPerson = null;
    }


    /**
     * tests the method for any buggers
     */
    public void testGetPlanetPreference() {
        assertEquals("jupiter", maxPerson.getPlanetPreference());
    }


    /**
     * tests the method for any buggers
     */
    public void testGetName() {
        assertEquals("Test1", maxPerson.getName());
    }


    /**
     * tests the method for any buggers
     */
    public void testGetSkills() {
        assertEquals(maxPerson2.getSkills(), maxPerson.getSkills());
    }


    /**
     * tests the method for any buggers
     */
    public void testEquals() {

        assertTrue(maxPerson.equals(maxPerson2)); // should be true?
        assertTrue(maxPerson.equals(maxPerson));

        assertFalse(maxPerson.equals(namePerson));
        assertFalse(maxPerson.equals(minPerson));
        assertFalse(maxPerson.equals(maxPerson3));
        assertFalse(maxPerson.equals(nullPerson));
        assertFalse(maxPerson.equals("dd"));

    }


    /**
     * tests the method for any buggers
     */
    public void testToString() {
        assertEquals(maxPerson.toString(), "Test1 A:5 M:5 T:5 Wants: jupiter");
        assertEquals(noPerson.toString(), "Test1 A:2 M:2 T:2 Wants: noWhere");
    }

}
