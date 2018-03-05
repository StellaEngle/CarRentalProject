package ncl.ac.uk.csc8404.b3042224.testing;

import ncl.ac.uk.csc8404.b3042224.carRent.*;
import ncl.ac.uk.csc8404.b3042224.carRent.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Created by Stella on 29/10/2016.
 */
public class TestCarRent {

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.RentCar#availableCars(java.lang.String)}
     */
    @Test
    public void testAvailableCars(){
        RentCar rent = RentCar.getRentCar();
        final Cars car1 = CarsAbstr.getInstance("small");
        final Cars car2 = CarsAbstr.getInstance("large");
        final Cars car3 = CarsAbstr.getInstance("large");
        rent.populateList(car1);
        rent.populateList(car2);
        rent.populateList(car3);
        assertTrue(1==rent.availableCars("small"));
        assertTrue(2==rent.availableCars("Large"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAvailableCarsException(){
        RentCar rent = RentCar.getRentCar();
        rent.availableCars("little");
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.RentCar#populateList(Cars)}
     */
    @Test
    public void testPopulateList(){
        RentCar rent = RentCar.getRentCar();
        Name n = new Name("Stella","Englezou");
        CreateDates date1 = new CreateDates(21, 03, 1995);
        CreateDates dates2 = new CreateDates(21, 03, 2010);
        final Cars car1 = CarsAbstr.getInstance("small");
        final Cars car2 = CarsAbstr.getInstance("large");
        final Cars car3 = CarsAbstr.getInstance("large");
        rent.populateList(car1);
        rent.populateList(car2);
        rent.populateList(car3);
        assertTrue(1==rent.availableCars("small"));
        assertTrue(2==rent.availableCars("Large"));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.RentCar#issueCar(Customer, DrivingLicense, java.lang.String)}
     */
    @Test
    public void testIssueCar(){
        RentCar rent = RentCar.getRentCar();
        Name n = new Name("Stella","Englezou");
        CreateDates date1 = new CreateDates(21, 03, 1995);
        CreateDates dates2 = new CreateDates(21, 03, 2010);
        final Cars car1 = CarsAbstr.getInstance("small");
        final Cars car2 = CarsAbstr.getInstance("large");
        final Cars car3 = CarsAbstr.getInstance("large");
         Date dob= date1.getDate();
        Date doi = dates2.getDate();
        Customer c = new Customer(n,dob);
        DrivingLicense dl = new DrivingLicense(n,doi,true);
        rent.populateList(car1);
        rent.populateList(car2);
        rent.populateList(car3);
        assertTrue(1==rent.availableCars("small"));
        assertTrue(2==rent.availableCars("Large"));
        assertTrue(true==rent.issueCar(c,dl,"large"));


        /*If license is not full*/
        Name n2 = new Name("Matthew","Englezou");
        CreateDates dateB2 = new CreateDates(21, 03, 1989);
        CreateDates dateIss2 = new CreateDates(21, 03, 2011);
        Date dob2 = dateB2.getDate();
        Date doi2 = dateIss2.getDate();
        Customer c2= new Customer(n2,dob2);
        DrivingLicense dl2 = new DrivingLicense(n2,doi2,false);
        assertTrue(false== rent.issueCar(c2,dl2,"small"));

        /*If they has already rented a car*/
        assertTrue(false==rent.issueCar(c,dl,"large"));

        /*If wrong type is requested*/
        Name n3 = new Name("Matthew","Bellamy");
        CreateDates dateB3 = new CreateDates(21, 03, 1989);
        CreateDates dateIss3 = new CreateDates(21, 03, 2011);
        Date dob3 = dateB3.getDate();
        Date doi3 = dateIss3.getDate();
        Customer c3= new Customer(n3,dob3);
        DrivingLicense dl3 = new DrivingLicense(n3,doi3,true);
        assertTrue(false==rent.issueCar(c3,dl3,"little"));
    }


    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.RentCar#issueCar(Customer, DrivingLicense, java.lang.String)}
     */
    @Test
    public void testIssueCarAgeandExperience(){
        RentCar rent = RentCar.getRentCar();
        Name n = new Name("Stella","Englezou");
        CreateDates date1 = new CreateDates(21, 03, 1990);
        CreateDates dates2 = new CreateDates(21, 2, 2016);
        final Cars car1 = CarsAbstr.getInstance("small");
        final Cars car2 = CarsAbstr.getInstance("large");
        final Cars car3 = CarsAbstr.getInstance("large");
        Date dob= date1.getDate();
        Date doi = dates2.getDate();
        Customer c = new Customer(n,dob);
        DrivingLicense dl = new DrivingLicense(n,doi,true);
        rent.populateList(car1);
        rent.populateList(car2);
        rent.populateList(car3);

        /*Has less than 1 year driving experience, rent small and large cars*/
        assertTrue(false==rent.issueCar(c,dl,"small"));
        assertTrue(false==rent.issueCar(c,dl,"large"));

        Name n3 = new Name("Matthew","Bellamy");
        CreateDates dateB3 = new CreateDates(21, 03, 1997);
        CreateDates dateIss3 = new CreateDates(21, 03, 2010);
        Date dob3 = dateB3.getDate();
        Date doi3 = dateIss3.getDate();
        Customer c3= new Customer(n3,dob3);
        DrivingLicense dl3 = new DrivingLicense(n3,doi3,true);
        /*Age less than 21 and 25*/
        assertTrue(false==rent.issueCar(c3,dl3,"small"));
        assertTrue(false==rent.issueCar(c3,dl3,"large"));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.RentCar#issueCar(Customer, DrivingLicense, java.lang.String)}
     */
    @Test
    public void testIssueCarAvailability(){
        RentCar rent = RentCar.getRentCar();
        Name n3 = new Name("Matthew","Bellamy");
        CreateDates dateB3 = new CreateDates(21, 03, 1980);
        CreateDates dateIss3 = new CreateDates(21, 03, 2000);
        Date dob3 = dateB3.getDate();
        Date doi3 = dateIss3.getDate();
        Customer c3= new Customer(n3,dob3);
        DrivingLicense dl3 = new DrivingLicense(n3,doi3,true);
        assertTrue(false==rent.issueCar(c3,dl3,"small"));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.RentCar#terminateRental(DrivingLicense)}
     */
    @Test
    public void testTerminate(){
        RentCar rent = RentCar.getRentCar();
        Name n3 = new Name("Matthew","Bellamy");
        CreateDates dateB3 = new CreateDates(21, 03, 1980);
        CreateDates dateIss3 = new CreateDates(21, 03, 2000);
        Date dob3 = dateB3.getDate();
        Date doi3 = dateIss3.getDate();
        final Cars car1 = CarsAbstr.getInstance("small");
        final Cars car2 = CarsAbstr.getInstance("large");
        final Cars car3 = CarsAbstr.getInstance("large");
        rent.populateList(car1);
        rent.populateList(car2);
        rent.populateList(car3);
        Customer c3= new Customer(n3,dob3);
        DrivingLicense dl3 = new DrivingLicense(n3,doi3,true);
        rent.issueCar(c3,dl3,"small");
        Cars selectedCar= rent.getCar(dl3);
        selectedCar.driveCar(40);
        assertTrue(2==rent.terminateRental(dl3));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.RentCar#getCar(DrivingLicense)}
     */
    @Test
    public void testGetCar(){
        RentCar rent = RentCar.getRentCar();
        Name n3 = new Name("Matthew","Bellamy");
        CreateDates dateB3 = new CreateDates(21, 03, 1980);
        CreateDates dateIss3 = new CreateDates(21, 03, 2000);
        Date dob3 = dateB3.getDate();
        Date doi3 = dateIss3.getDate();
        final Cars car1 = CarsAbstr.getInstance("small");
        final Cars car2 = CarsAbstr.getInstance("large");
        final Cars car3 = CarsAbstr.getInstance("large");
        rent.populateList(car1);
        rent.populateList(car2);
        rent.populateList(car3);
        Customer c3= new Customer(n3,dob3);
        DrivingLicense dl3 = new DrivingLicense(n3,doi3,true);
        rent.issueCar(c3,dl3,"small");
        assertTrue(car1.equals(rent.getCar(dl3)));
    }

}
