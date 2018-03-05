package ncl.ac.uk.csc8404.b3042224.testing;

import ncl.ac.uk.csc8404.b3042224.carRent.CreateDates;
import ncl.ac.uk.csc8404.b3042224.carRent.Customer;
import ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense;
import ncl.ac.uk.csc8404.b3042224.carRent.Name;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * @author Stella Englezou
 * @date 28/10/2016.
 */
public final class TestDrivingLicence {


    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#getDl()}
     */
    @Test
    public void testGetDL(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        assertTrue("SE-2013-00".equals(dl.getDl().toString()));
    }
    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#getDateOfIssue()}
     */
    @Test
    public void testGetDateOfIssue(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        assertTrue(doi1.toString().equals(dl.getDateOfIssue().toString()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#getName()}
     */
    @Test
    public void testGetName(){
        CreateDates dob = new CreateDates(21,03,1995);
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date dob1= dob.getDate();
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        assertTrue("Stella Englezou".equals(dl.getName().toString()));

    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#isFull()}
     */
    @Test
    public void testIsFull(){
        CreateDates dob = new CreateDates(21,03,1995);
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date dob1= dob.getDate();
        Date doi1=doi.getDate();
        Customer c = new Customer(n,dob1);
        DrivingLicense dl = new DrivingLicense(n,doi1,true);

        assertTrue(true==dl.isFull());


        dob = new CreateDates(12, 3, 1989);
        doi = new CreateDates(1, 11, 2003);
        dob1 = dob.getDate();
        doi1 = doi.getDate();
        DrivingLicense dl2 = new DrivingLicense(n, doi1,false);

        assertTrue(false == dl2.isFull());
    }

   /**
    * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#toString()}
    */
    @Test
    public void testToString(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        assertTrue("SE-2013-00".equals(dl.toString()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#DrivingLicense(Name, Date,boolean)}
     */
    @Test
    public void testDrivingLicense(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        assertTrue("Stella Englezou".equals(dl.getName().toString()));
        assertTrue(true==dl.isFull());
        assertTrue(doi1.toString().equals(dl.getDateOfIssue().toString()));
        assertTrue("SE-2013-00".equals(dl.getDl().toString()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#getFirstComponent()}
     */
    @Test
    public void testGetFirstComponent(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        String fComponent = "SE";
        assertTrue(fComponent.equals(dl.getFirstComponent()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#getSecondComponent()}
     */
    @Test
    public void testGetSecondComponent(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        String sComponent = "2013";
        assertTrue(sComponent.equals(dl.getSecondComponent()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicense#getThirdComponent()}
     */
    @Test
    public void testGetThirdComponent(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicense dl = new DrivingLicense(n,doi1,true);
        String tComponent = "00";
        assertTrue(tComponent.equals(dl.getThirdComponent()));
    }
}
