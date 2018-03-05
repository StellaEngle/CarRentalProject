package ncl.ac.uk.csc8404.b3042224.carRent;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Stella Englezou
 * @date 29/10/2016
 */
public final class TestLargeCar {

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.LargeCar}
     */
    @Test
    public void testCar(){
        Cars large = CarsAbstr.getInstance("large");
        assertTrue(0== large.driveCar(70));
        large.setRentStatus(true);
        assertTrue((large.driveCar(70)) == 7);
        assertTrue(53 == large.getCurrentFuel());
        assertTrue(1 == large.driveCar(1));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.LargeCar#getMinAgeForLargeCar()}
     */
    @Test
    public void testGetMinAge(){
        LargeCar l = new LargeCar();
        assertTrue(25 == l.getMinAgeForLargeCar());
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.LargeCar#getMinLicenseHoldL()}
     */
    @Test
    public void testGetMinLicenseHold(){
        LargeCar l = new LargeCar();
        assertTrue(5 == l.getMinLicenseHoldL());
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.LargeCar#getType()}
     */
    @Test
    public void testGetLargeCarType(){
        LargeCar l = new LargeCar();
        assertTrue("large".equals(l.getType()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.LargeCar#getCar()}
     */
    @Test
    public void testGetCar(){
        LargeCar l = new LargeCar();
        assertTrue(l.equals(l.getCar()));
    }
}
