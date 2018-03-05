package ncl.ac.uk.csc8404.b3042224.carRent;

import java.util.Date;

/**
 * @author Stella Englezou
 */
public interface CustomerInterface {

    /**
     * Method  gets the name.
     * @return the name of the Customer
     */
    Name getName();

    /**
     * Methods gets the date of birth.
     * @return the date of birth of the Customer
     */
    Date getDateOfBirth();
}
