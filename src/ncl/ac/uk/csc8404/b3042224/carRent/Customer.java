package ncl.ac.uk.csc8404.b3042224.carRent;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Stella Englezou
 * @date 21/10/2016
 */
public  final class Customer implements CustomerInterface{

    private final Name name;
    private final Date dateOfBirth;

    /**
     * Constructor, creates Customer from the given Name,
     * and Date of Birth.
     * @param n The name of the customer
     * @param dob the date of birth of the customer
     * @throws IllegalArgumentException if either the
     * <code>n</code> or <code>dob</code> is null
     *
     */
    public Customer(Name n, Date dob){
        if (n == null)
            throw new IllegalArgumentException("name is null");

        if (dob == null)
            throw new IllegalArgumentException("date of birth is null");

        this.name = new Name(n.getFirstName(),
                n.getLastName());

        this.dateOfBirth = new Date(dob.getTime());
    }

    /**
     * Method gets the Name of the Customer
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Name#getFirstName()
     * @see  ncl.ac.uk.csc8404.b3042224.carRent.Name#getLastName()
     */
    public Name getName() {
        return new Name(name.getFirstName(),
                name.getLastName());
    }

    /**
     * @see ncl.ac.uk.csc8404.b3042224.carRent.Customer#getDateOfBirth()
     */
    public Date getDateOfBirth() {
        return (Date) dateOfBirth.clone();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Customer))
            return false;

        final Customer person = (Customer) obj;

        return name.equals(person.name)
                && dateOfBirth.equals(person.dateOfBirth);
    }

    /**
     * Returns a string representation of the customer
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return name + " " + dateOfBirth;
    }

    /**
     * Cnstructs an instance of Customer from its String representation
     * The string representation of Customer consists of the first and last name,
     * and their date of birth.
     * @param customer The given customer
     * @return An instance of a Customer corresponding to the given representation
     */
    public static Customer valueOf(String customer){
        final String[] parts = customer.split(" ");
        if(parts.length >3){
            throw new ArrayIndexOutOfBoundsException("More arguments than needed for a Customer");
        }

        final String fName= parts[0].trim();
        final String lName= parts[1].trim();

        final String[] date = parts[2].split("/");
        final int day = Integer.parseInt(date[0].trim());
        final int month = Integer.parseInt(date[1].trim());
        final int year = Integer.parseInt(date[2].trim());

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        final Date dob = calendar.getTime();
        return new Customer(new Name(fName,lName),dob);
    }


}
