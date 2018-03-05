package ncl.ac.uk.csc8404.b3042224.carRent;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  Stella
 */
public final class DrivingLicenseFact {

    private static final Map<String, DrivingLicenseFact> DRIVING_LICENCE = new HashMap<>();
    private static int NUM=0;
    private final  String fullLicense;

    /**
     * Private constructor. Constructs a new driving license.
     */
    private DrivingLicenseFact(String fLicense){
        this.fullLicense = fLicense;
    }

    /**
     * Returns a string representation of the license number
     * @see java.lang.Object#toString()
     */
   public String toString() {
        return fullLicense;
    }

    /**
     * It creates a unique driving license from the Name and
     * the date of issue of acquiring the license. The newly created
     * license is checked against the values in the HashMap, to check if its
     * unique or not.If it's not unique then an exception is thrown. Otherwise
     * is passed to the constructor and put in the Map.
     * @param name The name of the customer the license is  created for
     * @param d The date when the customer acquired the license
     * @return Instance of DrivingLicenseFact
     */
    public static DrivingLicenseFact getInstance(Name name, Date d){
        Date date = new Date(d.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int year = cal.get(Calendar.YEAR);

        String strLicense = String.valueOf(name.getFirstName().charAt(0))+ String.valueOf(name.getLastName().charAt(0))
                + "-" + year + "-" + String.format("%02d",NUM);


        if(DRIVING_LICENCE.get(strLicense)!=null){
            throw new IllegalArgumentException(
                    "Duplicate license number.");
        }


        final DrivingLicenseFact factory = new DrivingLicenseFact(strLicense);
        DRIVING_LICENCE.put(strLicense,factory);
        NUM++;
         return factory;

    }

    /**
     * Returns the driving licenses created.
     * @return the Driving licenses
     */
    public static Map<String, DrivingLicenseFact> getDrivingLicence() {
        return DRIVING_LICENCE;
    }


    /**
     * Methos returns a string representation of the license.
     * @return the driving license license
     */
    public String getFullLicense() {
        return fullLicense;
    }


    /**
     * Method only used for testing.
     */
    public static void setNumForTest() {
        NUM = 4;

    }

}
