package ncl.ac.uk.csc8404.b3042224.testing;

import ncl.ac.uk.csc8404.b3042224.carRent.CreateDates;
import ncl.ac.uk.csc8404.b3042224.carRent.Customer;
import ncl.ac.uk.csc8404.b3042224.carRent.Name;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * @author Stella Englezou
 * @date 29/10/2016
 */
public class TestCustomer {

    /**
     * Test Method for {@link Customer#Customer(Name, Date)}
     */
    @Test
    public void testCustomerCreation(){
        Name n = Name.getInstance("Stella","Englezou");
        CreateDates dob = new CreateDates(21,03,1995);
        Customer customer =  new Customer(n,dob.getDate());

        assertTrue("Stella Englezou".equals(customer.getName().toString()));
        System.out.println(customer.getDateOfBirth().toString());
        assertTrue(dob.getDate().equals(customer.getDateOfBirth()));
    }

    /**
     * Test Method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Customer#getName()}
     */
    @Test
    public void testGetName(){
        Name n = Name.getInstance("Stella","Englezou");
        CreateDates dob = new CreateDates(21,03,1995);
        Customer customer =  new Customer(n,dob.getDate());
        assertTrue("Stella Englezou".equals(customer.getName().toString()));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Customer#getDateOfBirth()}}
     */
    @Test
    public void testGetDoB(){
        Name n = Name.getInstance("Stella","Englezou");
        CreateDates dob = new CreateDates(21,03,1995);
        Customer customer =  new Customer(n,dob.getDate());
        assertTrue(dob.getDate().equals(customer.getDateOfBirth()));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Customer#equals(java.lang.Object)}
     */
    @Test
    public void testEquals(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        CreateDates dob1 = new CreateDates(21,03,1995);
        Name n2 = Name.getInstance("Stella", "Englezou");
        Customer c1 = new Customer(n1,dob1.getDate());
        Customer c2 = new Customer(n2,dob1.getDate());
        assertTrue(c1.equals(c2));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Customer#toString()}
     */
    @Test
    public void testToString(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        CreateDates dob1 = new CreateDates(21,03,1995);
        Customer c1 = new Customer(n1,dob1.getDate());
        assertTrue(("Stella Englezou" + " " + dob1.getDate()).equals(c1.toString()));
    }

    /**
     * Test method for {@link ncl.ac.uk.csc8404.b3042224.carRent.Customer#valueOf(String)}
     */
    @Test
    public void testValueOf(){
        Name n1 = Name.getInstance("Stella", "Englezou");
        CreateDates dob1 = new CreateDates(21,03,1995);
        SimpleDateFormat sd = new SimpleDateFormat(("dd/MM/yyyy"));
        Customer c1 = new Customer(n1,dob1.getDate());
        sd.format(dob1.getDate());
        assertTrue(c1.toString().equals(Customer.valueOf("Stella Englezou 21/03/1995").toString()));
    }

    /**
     * Method to check if I get an ArrayIndexOutOfBoundsException
     * {@link ncl.ac.uk.csc8404.b3042224.carRent.Customer#valueOf(java.lang.String)}
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void valueOfLessParameters(){
        Customer.valueOf("Stella");
    }

    /**
     * Method to check if I get an ArrayIndexOutOfBoundsException
     * {@link ncl.ac.uk.csc8404.b3042224.carRent.Customer#valueOf(java.lang.String)}
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void valueOfMoreParameters(){
        Name.valueOf("Stella Stella Englezou 21/03/1995");
    }

}
