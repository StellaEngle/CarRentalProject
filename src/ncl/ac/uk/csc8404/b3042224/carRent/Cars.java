package ncl.ac.uk.csc8404.b3042224.carRent;

/**
 * Created by Stella on 21/10/2016.
 */
public interface Cars {

    /**
     * Method returns the car's registration number
     * @return the car's registration number
     */
    String getCarsRegistrNum();

    /**
     * Method gets a car's fuel tank capaticity
     * @return fuels tank capacity
     */
    int getFuelCapacity();

    /**
     * Method returns the current fuel in the car
     * @return current fuel
     */
    int getCurrentFuel();

    /**
     * Method returns if the fuel tank of a car is full or not
     * @return true or false
     */
    boolean isTankFull();

    /**
     * Method to add a given number of fuel to a car and return
     * how much fuel was added.
     * @param fuel the fuel to add
     * @return the fuel added
     */
    int addFuel(int fuel);

    /**
     * Method calculates the amount of fuel sonsumed
     * during a journey.
     * @param km The distance of the journey
     * @return The fuel consumed
     */
    int driveCar(int km);

    /**
     * Method to check if the car is rented or not
     * @return true or false
     */
    boolean isRented();

    /**
     * Method to set the rent status of a car
     * @param s true if the car is rented out, false if it's not rented
     */
    void setRentStatus(boolean s);

    /**
     * Method  gets a car
     * @return a car
     */
    Cars getCar();

    /**
     * Method gets the type of a car
     * @return type of car
     */
    String getType();

    /**
     * Method gets how much fuel was used
     * @return used fuel
     */
    int usedFuel();

    /**
     * Method checks if a car can be driven
     * @param distance
     * @return false or true
     */
    boolean canBeDriven(int distance);
}
