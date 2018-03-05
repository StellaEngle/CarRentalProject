package ncl.ac.uk.csc8404.b3042224.carRent;

import java.util.Date;

/**
 * @author Stella
 */
public class CarReantalSystem{

    /**
     * Method to test the application
    */
    public static void main(String [] args){
         RentCar rent =RentCar.getRentCar();
        Name n = new Name("Stella","Englezou");
        CreateDates date1 = new CreateDates(21, 03, 1995);
        CreateDates dates2 = new CreateDates(21, 03, 2013);
        Date d1= date1.getDate();
        Date d2 = dates2.getDate();
        Customer c = new Customer(n,d1);

        for(int i=0; i<10;i++){
            final Cars car =  CarsAbstr.getInstance("large");
            rent.populateList(car);
        }

        for(int i=0; i<20;i++){
            final Cars car =  CarsAbstr.getInstance("small");
            rent.populateList(car);
        }

        System.out.println("Total number of cars is correct if it returns 30: "+ rent.getListCar().size());
        System.out.println("Total number of Large cars available should return 10: "+ rent.availableCars("Large"));
        System.out.println("Total number of Small cars available should return 20: "+ rent.availableCars("Small"));


        DrivingLicense dl = new DrivingLicense(n,d2,true);
        rent.issueCar(c,dl,"small");

        System.out.println("Number of small cars available now should return 19: "+ rent.availableCars("small"));


        DrivingLicense license = null;
        Customer customer=null;
        for(int i=0;i<10;i++){
            CreateDates issueDate = new CreateDates(11, 10, 2000);
            Date doi= issueDate.getDate();
            Name name = Name.getInstance("Stella","Englezou");
            CreateDates bDay = new CreateDates(21, 03, 1975);
            Date dob = bDay.getDate();
            customer = new Customer(name,dob);
            license = new DrivingLicense(name, doi, true);
            rent.issueCar(customer,license, "large");
        }
        System.out.println("Number of Large cars available should return 0: "+ rent.availableCars("large"));
        System.out.println("Car cannot be issued. Must return False: "+ rent.issueCar(customer,license, "small"));
        rent.getCar(license).driveCar(40);
        System.out.println("Correct answer should be 4: "  + rent.terminateRental(license));

        CreateDates db3 = new CreateDates(21,03,1998);
        CreateDates ds3 = new CreateDates(21,03,2004);
        Name n3 = Name.getInstance("Stella","Engle");
        Date dob3 = db3.getDate();
        Date doi3 = ds3.getDate();
        Customer customer3 = new Customer(n3,dob3);
        DrivingLicense license3 = new DrivingLicense(n3,doi3,true);
        System.out.println("Correct if it returns false (because of the age of the driver): "+rent.issueCar(customer3,license3,"small"));

        CreateDates issue = new CreateDates(21,03,2015);
        Date issueDate = issue.getDate();
        customer3 = new Customer(n3,dob3);
        license3 = new DrivingLicense(n3,issueDate,true);
        System.out.println("Correct if it returns false (because of the experience of the driver): "+rent.issueCar(customer3,license3,"large"));







    }
}
