package ncl.ac.uk.csc8404.b3042224.testing;

import ncl.ac.uk.csc8404.b3042224.carRent.CarRegister;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Stella Englezou
 * @date 29/10/2016
 */
public final class TestCarRegister {

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarRegister#getFirstComponent()}}
     */
    @Test
    public void testGetFirstComponent(){
        CarRegister cr = CarRegister.getInstance();
       String fComponent = cr.getStrFinal().substring(0,4);
        assertTrue(fComponent.equals(cr.getFirstComponent()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.CarRegister#getSecondComponent()}}
     */
    @Test
    public void testGetSecondComponent(){
        CarRegister cr = CarRegister.getInstance();
        String sComponent = cr.getStrFinal().substring(5,7);
        assertTrue(sComponent.equals(cr.getSecondComponent()));
    }


}
