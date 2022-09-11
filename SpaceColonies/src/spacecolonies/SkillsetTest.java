package spacecolonies;

/**
 * test class for skills set 
 * @author Hamza Saif (hsaif)
 * @version 04/17/2020
 */
public class SkillsetTest extends student.TestCase {

    private Skillset skill1;
    private Skillset skill2;
    private Skillset skill3;
    private Skillset skill4;
    private Skillset skill5;
    private Skillset skill6;

    private Skillset nullSkill;

    /**
     * sets up before eevery test run 
     */
    public void setUp() {
        skill1 = new Skillset(5, 5, 5);
        skill6 = new Skillset(0, 5, 5);
        skill2 = new Skillset(5, 0, 5);
        skill3 = new Skillset(5, 5, 0);
        skill4 = new Skillset(5, 5, 5);
        skill5 = new Skillset(0, 0, 0);

        nullSkill = null;
    }


    /**
     * tests getAgriculture method 
     */
    public void testGetAgriculture() {
        assertEquals(5, skill1.getAgriculture());
    }

    /**
         * tests GetMedicine method 
 
     */
    public void testGetMedicine() {
        assertEquals(5, skill1.getMedicine());
    }

    /**
     * tests GetTechnology method 
     */
    public void testGetTechnology() {
        assertEquals(5, skill1.getTechnology());
    }

    /**
     * tests IsLessThanOrEqualTo method 
     */
    public void testIsLessThanOrEqualTo() {
        assertTrue(skill5.isLessThanOrEqualTo(skill1));
        assertTrue(skill2.isLessThanOrEqualTo(skill1));
        assertFalse(skill1.isLessThanOrEqualTo(skill2));
        assertTrue(skill1.isLessThanOrEqualTo(skill1));
        assertTrue(skill1.isLessThanOrEqualTo(skill4));

        assertFalse(skill1.isLessThanOrEqualTo(skill2));
        assertFalse(skill2.isLessThanOrEqualTo(skill3));
        assertFalse(skill1.isLessThanOrEqualTo(skill5));
        assertFalse(skill1.isLessThanOrEqualTo(skill6));
    }

    /**
     * tests Equals method 
     */
    public void testEquals() {

        assertTrue(skill1.equals(skill1));
        assertTrue(skill1.equals(skill4));

        assertFalse(skill1.equals(skill2));
        assertFalse(skill1.equals(skill3));
        assertFalse(skill1.equals(skill5));
        assertFalse(skill1.equals(skill6));
        assertFalse(skill1.equals(nullSkill));
        assertFalse(skill1.equals(""));

    }

    /**
     * tests ToString method 
     */
    public void testToString() {

        assertEquals(skill1.toString(), "A:5 M:5 T:5");
    }

    /**
     * tests CompareTo method 
     */
    public void testCompareTo() {
        assertEquals(0, skill1.compareTo(skill4));
        assertEquals(1, skill1.compareTo(skill2));
        assertEquals(-1, skill2.compareTo(skill1));

    }

}
