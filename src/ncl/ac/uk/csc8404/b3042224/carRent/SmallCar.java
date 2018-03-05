package ncl.ac.uk.csc8404.b3042224.carRent;

/**
 * @author Stella Englezou
 */
final class SmallCar extends CarsAbstr{
    private final static int TANK_CAPACITY=49;
    private final static int FUEL_CONSUMPTION=20;
    private final static int TOTAL_NUM_OF_SMALL_CARS=20;
    private final static int MIN_AGE_FOR_SMALL_CAR =20;
    private final static int MIN_LICENSE_HOLD=1;
    private final static String SMALL_CAR_TYPE = "small";

    /**
     * Constructor creates a small car with the given capacity in the super class
     */
    SmallCar() {
        super(TANK_CAPACITY);
    }


    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#driveCar(int)
     */
    public int driveCar(int km){
        if(!canBeDriven(km)){
            System.out.print("No Journey is undertaken");
            return 0;
        }
        int totalConsumedFuel = km/FUEL_CONSUMPTION;
        if((totalConsumedFuel*FUEL_CONSUMPTION)!=km){
            totalConsumedFuel++;
        }
        spentFuel(totalConsumedFuel);
        return totalConsumedFuel;

    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.toString() + " Small Car";
    }

    /**
     * Method returns the minimum age a customer must be to rent a small car
     * @return minimum number of years of having a license
     */
    public static int getMinAgeForSmallCar() {
        return MIN_AGE_FOR_SMALL_CAR;
    }

    /**
     * Method returns how long a customer must have their driving
     * license to rent a small car
     * @return minimum number of years of having a license
     */
    public static int getMinLicenseHold() {
        return MIN_LICENSE_HOLD;
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#getCar()
     */
    public Cars getCar(){
        return this;
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#getType()
     */
    public String getType(){
      return SMALL_CAR_TYPE;
    }

    /**
     * Method returns the total number of small cars the company has
     * @return Total number of small cars
     */
    public static int getTotalNumOfSmallCars() {
        return TOTAL_NUM_OF_SMALL_CARS;
    }
}
