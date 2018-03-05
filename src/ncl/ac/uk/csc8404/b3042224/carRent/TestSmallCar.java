package ncl.ac.uk.csc8404.b3042224.carRent;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Stella Englezou
 * @date 29/10/2016
 */
public final class TestSmallCar {

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.SmallCar}
     */
    @Test
    public void testCar(){
        Cars small = CarsAbstr.getInstance("small");
        assertTrue(0== small.driveCar(70));
        small.setRentStatus(true);
        assertTrue((small.driveCar(70)) == 4);
        assertTrue(45 == small.getCurrentFuel());
        assertTrue(1 == small.driveCar(1));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.SmallCar#getMinAgeForSmallCar()}
     */
    @Test
    public void testGetMinAge(){
        SmallCar s = new SmallCar();
        assertTrue(20 == s.getMinAgeForSmallCar());
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.SmallCar#getMinLicenseHold()}
     */
    @Test
    public void testGetMinLicenseHold(){
        SmallCar s = new SmallCar();
        assertTrue(1 == s.getMinLicenseHold());
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.SmallCar#getType()}
     */
    @Test
    public void testGetSmallCarType(){
        SmallCar s = new SmallCar();
        assertTrue("small".equals(s.getType()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.SmallCar#getCar()}
     */
    @Test
    public void testGetCar(){
        SmallCar s = new SmallCar();
        assertTrue(s.equals(s.getCar()));
    }

}
