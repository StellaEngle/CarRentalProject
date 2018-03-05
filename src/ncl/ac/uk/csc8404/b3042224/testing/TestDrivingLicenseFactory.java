package ncl.ac.uk.csc8404.b3042224.testing;

import ncl.ac.uk.csc8404.b3042224.carRent.CreateDates;
import ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicenseFact;
import ncl.ac.uk.csc8404.b3042224.carRent.Name;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;


/**
 * @author Stella Englezou
 * @date 28/10/2016
 */
public final class TestDrivingLicenseFactory {

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicenseFact#getFullLicense()}
     */
    @Test
    public void testGetFullLicense(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicenseFact dlf = DrivingLicenseFact.getInstance(n,doi1);
        assertTrue("SE-2013-00".equals(dlf.getFullLicense()));
    }

    /**
     * Method to check if I get an IllegalArgumentException
     * if I'm trying to created a license that already exists.
     * {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicenseFact#getInstance(Name, Date)}
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testForDuplicates(){
        DrivingLicenseFact.setNumForTest();
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicenseFact dlf = DrivingLicenseFact.getInstance(n,doi1);
        DrivingLicenseFact.setNumForTest();
        dlf = DrivingLicenseFact.getInstance(n,doi1);
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.DrivingLicenseFact#toString()}
     */
    @Test
    public void testToString(){
        CreateDates doi = new CreateDates(21,03,2013);
        Name n = Name.getInstance("Stella", "Englezou");
        Date doi1=doi.getDate();
        DrivingLicenseFact dlf = DrivingLicenseFact.getInstance(n,doi1);
        assertTrue("SE-2013-00".equals(dlf.toString()));
    }
}
