package ncl.ac.uk.csc8404.b3042224.testing;

import ncl.ac.uk.csc8404.b3042224.carRent.Cars;
import ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Stella Englezou
 * @date 28/10/2016
 */
public final class TestCarsAbstr {


    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#getInstance(java.lang.String)}
     */
    @Test
    public void testGetInstance(){
       Cars small= CarsAbstr.getInstance("Small");
        assertTrue("small".equals(small.getType()));

        Cars large=CarsAbstr.getInstance("LARGE");
        assertTrue("large".equals(large.getType()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetInstanceException(){
        Cars small= CarsAbstr.getInstance("St");
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#getFuelCapacity()}
     */
    @Test
    public void testGetFuelCapacity(){
        Cars small= CarsAbstr.getInstance("small");
        assertTrue(49==small.getFuelCapacity());

        Cars large = CarsAbstr.getInstance("large");
        assertTrue(60==large.getFuelCapacity());
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#getCurrentFuel()}
     */
    @Test
    public void testCurrentFuel(){
        Cars small= CarsAbstr.getInstance("small");
        small.setRentStatus(true);
        small.driveCar(500);
        assertTrue(24 == small.getCurrentFuel());

    }
    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#isTankFull()}
     */
    @Test
    public void testIsTankFull(){
        Cars small= CarsAbstr.getInstance("small");
        assertTrue(true==small.isTankFull());
        Cars large= CarsAbstr.getInstance("large");
        large.setRentStatus(true);
        large.driveCar(300);
        assertTrue(false==large.isTankFull());
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#isRented()}
     */
    @Test
    public void testIsRented(){
        Cars large= CarsAbstr.getInstance("large");
        large.setRentStatus(true);
        assertTrue(true==large.isRented());
        Cars small= CarsAbstr.getInstance("small");
        small.setRentStatus(false);
        assertTrue(false==small.isRented());
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#addFuel(int)}
     */
    @Test
    public void testAddFuel(){
        Cars small= CarsAbstr.getInstance("small");
        small.setRentStatus(false);
        assertTrue(0==small.addFuel(0));
        small.setRentStatus(true);
        small.driveCar(50);
        assertTrue(46 == small.getCurrentFuel());
        assertTrue(3 == small.addFuel(70)); // apo ta 70 evala mono t 3
        assertTrue(2==small.addFuel(2));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#usedFuel()}
     */
    @Test
    public void testUsedFuel(){
        Cars large= CarsAbstr.getInstance("large");
        assertTrue(0== large.usedFuel());
        large.setRentStatus(true);
        large.driveCar(50);
        assertTrue(5==large.usedFuel());
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarsAbstr#canBeDriven(int)}
     */
    @Test
    public void testCanBeDriven(){
        Cars large= CarsAbstr.getInstance("large");
        large.setRentStatus(true);
        assertTrue(true==large.canBeDriven(9));
        large.setRentStatus(false);
        assertTrue(false==large.canBeDriven(9));
        large.setRentStatus(true);
        large.driveCar(880);
        assertTrue(false==large.canBeDriven(9));

    }
}
