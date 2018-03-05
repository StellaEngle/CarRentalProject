package ncl.ac.uk.csc8404.b3042224.carRent;


import java.util.*;

/**
 * @author Stella Englezou
 * @date  25/10/2016
 */
public final class RentCar {
    private static final RentCar rent = new RentCar();
    private List<Cars> listCar ;
    private Map<DrivingLicense,Cars> rentedCars;


    /**
     * Constructor, creates an array list to store all the cars,
     * it also creates a HashMap to store all the rented cars
     * linking together the customers driving license and the car
     * they have rented.
     *
     * */
    public RentCar(){
        listCar = new ArrayList<Cars>();
        rentedCars = new HashMap<DrivingLicense,Cars>();
    }

    /**
     *  Method that returns an instance of the class
     *  @return the instance of the class RentCar
     * */
    public static RentCar getRentCar(){
        return rent;
    }


    /**
     * Method returns all the cars the company has
     * @return the cars of the company
     * */
    public List<Cars> getListCar() {
        return listCar;
    }

    /**
     * Method returns the number of cars of the specified type
     * that are available to rent.
     * @param typeOfCar The type of car, we want to check the number of available cars
     * @return number of available cars of a type
     * */
    public int availableCars(String typeOfCar){
        String type = typeOfCar.toLowerCase().trim();
        int availCars=0;
        if(type.equals("small")){
            for (Cars avail: listCar){
                if(avail.getType().equals(type) && avail.isRented()==false){
                    availCars++;
                }
            }
        }else if(type.equals("large")){
            for(Cars aCar: listCar){
                if(aCar.getType().equals(type) && aCar.isRented()==false){
                    availCars++;
                }
            }
        }else{
            throw new IllegalArgumentException("Wrong Type of Car. It can only be 'small' or 'large'.");
        }
        return  availCars;
    }

    /**
     * Method returns the car a person has rented.
     * @param personLicense the driving license of a particular customer
     * @return Cars
     * */
    public Cars getCar(DrivingLicense personLicense){
        if(rentedCars.containsKey(personLicense)){
           return rentedCars.get(personLicense);
        }else{
            System.out.print("This customer has not rent a carRent.");
            return null;
        }
    }

    /**
     * Method determines if a Customer is eligible to
     * rent a car. If there is a car available, it then issues
     * the car.
     * @param customer The customer
     * @param drivingLicence the driving license of the customer
     * @param typeOfCar The type of the car, we are requesting to rent
     *@returns true if can issue a car, otherwise false
     */
    public boolean issueCar(Customer customer, DrivingLicense drivingLicence, String typeOfCar){
        String type = typeOfCar.toLowerCase().trim();
        /*Checks if licence is full or not*/
        if(!drivingLicence.isFull()){
            System.out.println("The requested carRent cannot be rented!");
            return false;
        }

        /*Checks if the customer has already rented a carRent*/
        if(rentedCars.containsKey(drivingLicence)){
            System.out.println("The requested carRent cannot be rented!");
            return false;
        }


        if(!type.equals("small") && !(type.equals("large"))){
            System.out.println("The requested carRent cannot be rented!");
            return false;
        }

        Calendar dob = Calendar.getInstance();
        dob.setTime(customer.getDateOfBirth());
        Calendar currentDay = Calendar.getInstance();
        currentDay.add(Calendar.MONTH, 1);
        // Calculates the age of the user.
        int customerAge = currentDay.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        Calendar doi = Calendar.getInstance();
        doi.setTime(drivingLicence.getDateOfIssue());

        // Calculates the age of licence.
        int licenseYears = currentDay.get(Calendar.YEAR) - doi.get(Calendar.YEAR);


        if(type.equals("small")){
            if((customerAge<21)){
                return false;
            }
            if(licenseYears<1){
                return  false;
            }
        }

        if(type.equals("large")){
            if((customerAge<25)){
                return false;
            }
            if(licenseYears<5){
                return  false;
            }

        }
        Cars chosenCar = null;
        boolean availableCarFound= false;
        /*Check to see if there is available small carRent to rent*/
        if(type.equals("small")){
            for(Cars car: listCar){
                if(!availableCarFound && !car.isRented() && car.getType().equals("small")){
                    availableCarFound=true;
                    chosenCar=car;
                }

            }
        }else{
            for(Cars car: listCar){
                if(!availableCarFound && !car.isRented() && car.getType().equals("large")){
                    availableCarFound=true;
                    chosenCar=car;
                }

            }

        }
        if(chosenCar!=null) {
            rentedCars.put(drivingLicence, chosenCar);
            chosenCar.setRentStatus(true);
            System.out.println("A Car was issued to: " + drivingLicence);
            return true;
        }else{
            return false;
        }
    }


    /**
     * Method's terminates the given's customer rental contract.
     * @param license the license of a customer
     * @return refill
     * */
    public int terminateRental(DrivingLicense license){
        int  refill=0;
        if(rentedCars.containsKey(license)){
            Cars chosenCar = rentedCars.get(license);
            chosenCar.setRentStatus(false);
            rentedCars.remove(license);
            if(!chosenCar.isTankFull()){
                refill=chosenCar.usedFuel();
            }
            return refill;
        }else{
            return refill;
        }

    }

    /**
     * Method to add cars in the list
     * @param c A car
     */
    public void populateList(Cars c){
        listCar.add(c);
    }

}
