package ncl.ac.uk.csc8404.b3042224.carRent;

/**
 * Created by Stella on 25/10/2016.
 */
final class LargeCar extends CarsAbstr {

    private final static int TANK_CAPACITY=60;
    private final static int FUEL_CONSUMPTION_FIRST_50=10;
    private final static int FUEL_CONSUMPTION_REST=15;
    private final static int TOTAL_NUM_OF_LARGE_CARS=10;
    private final static int MIN_AGE_FOR_LARGE_CAR =25;
    private final static int MIN_LICENSE_HOLD_L=5;
    private final static String L_CAR_TYPE = "large";

    /**
     * Constructor creates a large car with the given capacity in the super class
     */
    LargeCar(){
        super(TANK_CAPACITY);
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#driveCar(int)
     */
    public int driveCar(int km){
        if(!canBeDriven(km)){
            System.out.println("No journey can be made.");
            return 0;
        }
        if(km<=50){
            int total=(km/FUEL_CONSUMPTION_FIRST_50);
            if((total*FUEL_CONSUMPTION_FIRST_50)!=km) {
                total++;
            }
                spentFuel(total);
                return total;
            }else if (km>50){
                km-=50;
                int totalSecond =(km/FUEL_CONSUMPTION_REST)+5;
                if((totalSecond*FUEL_CONSUMPTION_REST)!=km){
                    totalSecond++;

                }
                spentFuel(totalSecond);
                return totalSecond;
            }
            return 0;

    }

    /**
     * Method returns the total number of large cars the company has
     * @return total number of large cars
     */
    public static int getTotalNumOfLargeCars() {
        return TOTAL_NUM_OF_LARGE_CARS;
    }

    /**
     * Method returns the minimum age a customer must be to rent a large car
     * @return minimum number of years of having a license
     */
    public static int getMinAgeForLargeCar() {
        return MIN_AGE_FOR_LARGE_CAR;
    }

    /**
     * Method returns how long a customer must have their driving
     * license to rent a large car
     * @return minimum number of years of having a license
     */
    public static int getMinLicenseHoldL() {
        return MIN_LICENSE_HOLD_L;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.toString() + " Large Car";
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
        return L_CAR_TYPE;
    }
}
