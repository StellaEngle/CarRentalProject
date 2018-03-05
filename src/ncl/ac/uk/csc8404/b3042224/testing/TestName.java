package ncl.ac.uk.csc8404.b3042224.testing;
import ncl.ac.uk.csc8404.b3042224.carRent.Name;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * @author Stella Englezou
 * @date 28/10/2016.
 */

public final class TestName {


    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#Name(java.lang.String, java.lang.String)}
     */
    @Test
    public void testNameCreation(){
        Name n1 = Name.getInstance("Stella", "Englezou");

        assertTrue("Stella".equals(n1.getFirstName()));
        assertTrue("Englezou".equals(n1.getLastName()));

        Name n2 = Name.getInstance("Stella", "Englezou");
        assertTrue("Stella".equals(n2.getFirstName()));
        assertTrue("Englezou".equals(n2.getLastName()));

        Name n3 = Name.getInstance("Alex", "Turner");
        assertTrue("Alex".equals(n3.getFirstName()));
        assertTrue("Turner".equals(n3.getLastName()));
    }

    /**
     * Testing the return of the first name
     * {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#getFirstName()}
     */
    @Test
    public void testFirstName(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        assertTrue("Stella".equals(n1.getFirstName()));
        Name n3 = Name.getInstance("Alex", "Turner");
        assertTrue("Alex".equals(n3.getFirstName()));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#getLastName()}
     */
    @Test
    public void testLastName(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        assertTrue("Stella".equals(n1.getFirstName()));
        Name n3 = Name.getInstance("Alex", "Turner");
        assertTrue("Alex".equals(n3.getFirstName()));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#equals(java.lang.Object)}
     */
    @Test
    public void testEquals(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        Name n2 = Name.getInstance("Stella", "Englezou");
        assertTrue(n1.equals(n2));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#toString()}
     */
    @Test
    public void testToString(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        assertTrue("Stella Englezou".equals(n1.toString()));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#valueOf(java.lang.String)}
     */
    @Test
    public void testValueOf(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        assertTrue(n1.toString().equals(Name.valueOf("Stella Englezou").toString()));
    }

    /**
     * Method to check if I get an ArrayIndexOutOfBoundsException
     * {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#valueOf(java.lang.String)}
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void valueOfLessParameters(){
        Name.valueOf("Stella");
    }

    /**
     * Method to check if I get an ArrayIndexOutOfBoundsException
     * {@link ncl.ac.uk.csc8404.b3042224.carRent.Name#valueOf(java.lang.String)}
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void valueOfMoreParameters(){
        Name.valueOf("Stella Stella Englezou");
    }


}
