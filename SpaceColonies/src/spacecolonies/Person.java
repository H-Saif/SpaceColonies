package spacecolonies;

/**
 * person class
 * 
 * @author Hamza Saif
 * @version 4/14/2022
 *
 */
public class Person {

    private String name;
    private Skillset skills;

    private String planetPreference;

    /**
     * constructor takes in 5 parameters as below
     * 
     * @param name
     *            the name
     * @param agri
     *            - agricultrure skill level
     * @param medi
     *            - medicine skill level
     * @param tech
     *            - technology skill level
     * @param planet
     *            - planet prefernce
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        skills = new Skillset(agri, medi, tech);
        this.name = name;
        planetPreference = planet;
    }


    /**
     * getter method for planet preference
     * 
     * @return the prefered Planet
     */
    public String getPlanetPreference() {
        return planetPreference;
    }


    /**
     * getter method for name
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * getter method for skills
     * 
     * @return the skills of the person
     */
    public Skillset getSkills() {
        return skills;
    }


    /**
     * Equals method
     * 
     * @param obj
     *            the object equal to
     * @return true if equal
     */
    public boolean equals(Object obj) { // test
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person)obj;

        return (name.equals(other.name) && skills.equals(other.skills)
            && planetPreference.equals(other.planetPreference));
    }


    /**
     * to string method
     * 
     * @return returns the string
     */
    @Override
    public String toString() {
        StringBuilder str = null;
        if (planetPreference.length() == 0) {
            str = new StringBuilder(getName() + " " + skills.toString()
                + " Wants: noWhere");

        }
        else {
            str = new StringBuilder(getName() + " " + skills.toString()
                + " Wants: " + getPlanetPreference());
        }
        return str.toString();
    }
}
