package ncl.ac.uk.csc8404.b3042224.carRent;

/**
 * @author Stella Englezou
 */
public abstract class CarsAbstr implements Cars {

    private  boolean rentedStatus;
    private final int capacity;
    private final CarRegister carRegister;
    private int currentFuelCap;

    /**
     * Constructor creates a car using the getInstance method of
     * thr Carregister method, given the maximun fuel capacity of
     * the car
     * @param fuelCapacity
     */
    CarsAbstr(int fuelCapacity){
        this.capacity=fuelCapacity;
        this.currentFuelCap=fuelCapacity;
        this.carRegister= CarRegister.getInstance();

    }

    /**
     * Creates an instance of a car of the specified type.
     * If wrong type is given an exception is thrown
     * @param carType The type of the car we want to create
     * @throws IllegalArgumentException if the <code>carType</code>
     * is not small or large
     * @return Type of the Car specified
     */
    public static CarsAbstr getInstance(String carType){
        String type = carType.toLowerCase().trim();

        if(type.equals("small")){
            return new SmallCar();
        }else if(type.equals("large")){
            return  new LargeCar();
        }
        throw new IllegalArgumentException("No such carRent type exist.");
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#canBeDriven(int)
     */
    public boolean canBeDriven(int distance) {

        return isRented() && getCurrentFuel() > 0 && distance > 0;
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#getCarsRegistrNum()
     */
    public String getCarsRegistrNum(){
        return carRegister.toString();
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#getFuelCapacity()
     */
    public int getFuelCapacity(){
        return capacity;

    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#getCurrentFuel()
     */
    public int getCurrentFuel(){
        return currentFuelCap;
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#isTankFull()
     */
    public  boolean isTankFull(){
        boolean check= (getFuelCapacity()== getCurrentFuel());
        return check;
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#isTankFull()
     */
    public void setRentStatus(boolean s){
        rentedStatus=s;
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#isRented()
     */
    public boolean isRented(){
        return rentedStatus;
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#usedFuel()
     */
    public int usedFuel(){
        int calculate= getFuelCapacity()- getCurrentFuel();
        return calculate;
    }

    /**
     * Method calculates and returns the fuel left
     * @param litres fuel used
     * @return fuel left
     */
    public int spentFuel(int litres){
        currentFuelCap= currentFuelCap-litres;
        return currentFuelCap;
    }


    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Cars#addFuel(int)
     */
    public int addFuel(int fuel){
        //System.out.println(getCurrentFuel());
        if(!isRented() && getCurrentFuel()==getFuelCapacity()){
            return 0; //if the carRent is not rented and the fuel tank is fuel, return 0
        }
        int negativeFuel= getFuelCapacity()-usedFuel();

        if(negativeFuel<0){//if the carRent has negative fuel left
            return getFuelCapacity();
        }else if(usedFuel()<= fuel){
            int tempfuel = usedFuel();
            currentFuelCap+=usedFuel();
            return tempfuel;
        }else{//else if the given fuel is exactly what is needed we return that.
            currentFuelCap+=fuel;
            return fuel;
        }

    }

    /**
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return carRegister.toString();
    }


}
