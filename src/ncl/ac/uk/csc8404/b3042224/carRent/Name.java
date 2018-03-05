package ncl.ac.uk.csc8404.b3042224.carRent;

/**
 * Created using the Lecture materials, I kept the Javadocs
 * lecture materials.
 */

/**
 * Created by Stella on 21/10/2016.
 */
public final class Name {
    private final String firstName;
    private final String lastName;

   /**
    * Constructor creates a name from the given first name and last
     * name.
     * @param fName the first name
     * @param lName the last name
     * @throws IllegalArgumentException if either
     * <code>fName</code> or <code>fName</code> is
     * empty
     */
    public Name(String fName, String lName){
        this.firstName=fName;
        this.lastName=lName;
    }

    /**
     * Method returns the first name of Name
     * @return First Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method returns the last name of Name
     * @return Last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Creates an Instance of a Name, from a given first name and
     * last name
     * @param firstName the first name
     * @param lastName the last name
     * @return Instance of a name from the given first and last names.
     */
    public static Name getInstance(String firstName, String lastName){
        if(firstName.length() == 0){
            throw new IllegalArgumentException("Blank first name");

        }

        if(lastName.length()==0){
            throw new IllegalArgumentException("Blank first name");
        }

        final  Name name = new Name(firstName,lastName);
        return name;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Name))
            return false;

        final Name name = (Name) obj;
        return firstName.equals(name.firstName)
                && lastName.equals(lastName);
    }

    /**
     * Returns a string representation of a Name.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * Constructs an instance of Name from its
     * given string representation.
     * @param name the given name
     * @return Instance of a Name corresponding to the given
     * string
     * @throws ArrayIndexOutOfBoundsException if there are more than
     * two component parts to <code>name</code> (first and last
     * names)
     */
    public static Name valueOf(String name) {
        final String[] parts = name.split(" ");
        if (parts.length > 2)
            throw new ArrayIndexOutOfBoundsException(
                    "More than 2 values in the Name Class");
        final String firstName = parts[0].trim();
        final String lastName = parts[1].trim();
        return new Name(firstName, lastName);
    }


}
