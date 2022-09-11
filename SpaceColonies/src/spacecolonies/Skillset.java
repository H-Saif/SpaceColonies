package spacecolonies;

/**
 * Skillset class, for person and planet skills
 * 
 * @author Hamza Saif
 * @version 04/18/2020
 *
 */
public class Skillset implements Comparable<Skillset> {
    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * Skillset constructor, takes in all 3 skills as parameters
     * 
     * @param ag
     *            agriculture parameter
     * @param med
     *            medicine parameter
     * @param tech
     *            technology parameter
     */
    public Skillset(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * getter method
     * 
     * @return agriculture value
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * getter method
     * 
     * @return medicine value
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * getter method
     * 
     * @return technology value
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * 
     * @param other
     *            skill set it is compared to
     * @return true if equal or false otherwise
     */
    public boolean isLessThanOrEqualTo(Skillset other) { // test

        return agriculture <= other.getAgriculture() && medicine <= other
            .getMedicine() && technology <= other.getTechnology();
    }


    /**
     * equals method, return true if all skills are equal
     * 
     * @param obj
     *            the object being compared to
     * @return true if they are equal
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
        Skillset other = (Skillset)obj;

        return (agriculture == other.getAgriculture() && medicine == other
            .getMedicine() && technology == other.getTechnology());
    }


    /**
     * compareTo method, compares the skills
     * return 1 if the total is greater, -1 if less, 0 if equal
     */
    @Override
    public int compareTo(Skillset skills) {
        if (this.getAgriculture() + this.getMedicine() + this
            .getTechnology() > skills.getAgriculture() + skills.getMedicine()
                + skills.getTechnology()) {
            return 1;
        }
        else if (this.getAgriculture() + this.getMedicine() + this
            .getTechnology() < skills.getAgriculture() + skills.getMedicine()
                + skills.getTechnology())

        {
            return -1;
        }
        return 0;
    }


    /**
     * toString method
     * 
     * @return the skills in string format
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("A:" + getAgriculture() + " M:"
            + getMedicine() + " T:" + getMedicine());
        return str.toString();
    }

}
