package spacecolonies;

import java.util.ArrayList;

/**
 * Planet class
 * 
 * @author Hamza Saif (hsaif)
 * @version 4/14/2022
 *
 */
public class Planet implements Comparable<Planet> {

    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;
    private ArrayList<Person> planets = new ArrayList<Person>();

    /**
     * Constructor takes in 5 parameters
     * 
     * @param planetName
     *            - name
     * @param planetAgri
     *            Agri skill level
     * @param planetMedi
     *            Med skill level
     * @param planetTech
     *            skill level
     * @param planetCap
     *            capacity of planet
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        capacity = planetCap;
        population = new Person[capacity];
        populationSize = 0;
        minSkills = new Skillset(planetAgri, planetMedi, planetTech);
    }


    /**
     * setter method
     * 
     * @param name
     *            takes in name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * getter method
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * getter method for min skill level
     * 
     * @return minSkills
     *         the minimum level of skill required
     */
    public Skillset getSkills() {
        return minSkills;
    }


    /**
     * getter method
     * 
     * @return
     *         the population
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * population size method
     * 
     * @return
     *         the population size of the planet
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * getter method
     * 
     * @return
     *         the capacity of the planet
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * getter method
     * 
     * @return
     *         the availabilty of space on that planet
     */
    public int getAvailability() {
        return getCapacity() - getPopulationSize();
    }


    /**
     * checks if the planet is full
     * 
     * @return
     *         true if planet is full
     */
    public boolean isFull() {
        return capacity == populationSize;
    }


    /**
     * adds a person to the planet
     * 
     * @param newbie
     *            the Person to add
     * @return
     *         true if person was added
     */
    public boolean addPerson(Person newbie) {
        if (newbie == null) {
            return false;
        }
        if (!isFull() && isQualified(newbie)) {
            planets.add(newbie);
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * check if the person meets the minimum skill level of the planet
     * 
     * @param newbie
     *            takes in a Person object
     * @return
     *         true if they meet the requirement
     */
    public boolean isQualified(Person newbie) {
        return (newbie.getSkills().getAgriculture() >= minSkills
            .getAgriculture() && newbie.getSkills().getMedicine() >= minSkills
                .getMedicine() && newbie.getSkills()
                    .getTechnology() >= minSkills.getTechnology());
    }


    /**
     * to string method
     * 
     * @return
     *         the string
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name);
        s.append(", population: " + planets.size());
        s.append(", capacity: " + capacity + ", ");
        s.append("Requires: A = " + minSkills.getAgriculture());
        s.append(" M = " + minSkills.getMedicine());
        s.append(" T = " + minSkills.getTechnology());
        return s.toString();
    }


    /**
     * equals method
     * 
     * @return
     *         true if name, skills, population and capacity are equal
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Planet otherPlanet = (Planet)obj;

        return (this.getName().equals(otherPlanet.getName()) && this.getSkills()
            .equals(otherPlanet.getSkills()) && this
                .getPopulationSize() == otherPlanet.getPopulationSize() && this
                    .getCapacity() == otherPlanet.getCapacity());

    }


    /**
     * compares the space avaiable in the planet
     * 
     * @return
     *         1 if it has more space, -1 if less, and 0 if equals
     */
    @Override
    public int compareTo(Planet other) {

        if (this.getAvailability() == other.getAvailability()) {
            return 0;
        }
        else if (this.getAvailability() < other.getAvailability()) {
            return -1;
        }

        return 1;
    }
}
