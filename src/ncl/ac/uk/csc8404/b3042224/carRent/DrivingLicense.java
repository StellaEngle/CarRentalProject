package ncl.ac.uk.csc8404.b3042224.carRent;

import java.util.Date;

/**
 * Created by Stella on 22/10/2016.
 */
public class DrivingLicense {
    private final Name name;
    private final DrivingLicenseFact dl;
    private final Date dateOfIssue;
    private final boolean isFull;
    private String fComponent;
    private String sComponent;
    private String tComponent;


    /**
     * Constructor, given the name, the date of issue of the
     * lisence and if it's full or not, it creates a driving license by passing
     * the name and the date to the getInstance Method in the DrivingLicenseFact
     * class.
     * @param n The name of the Customer
     * @param doIssue The date that the Customer acquired his license
     * @param full If it's full license or not
     */
    public DrivingLicense(Name n,Date doIssue,boolean full){
        this.name=n;
        this.isFull=full;
        this.dateOfIssue= new Date(doIssue.getTime());
        this.dl=DrivingLicenseFact.getInstance(this.name,this.dateOfIssue);
    }

    /**
     * Method returns the name of the holder of the license
     * @return the name of the Customer
     */
    public Name getName() {
        return name;
    }

    /**
     * Methods returns the string representation of the license
     * @return the driving license
     */
    public String getDl() {
        return dl.getFullLicense();
    }

    /**
     * Methods returns the date of issue of the license
     * @return date of issue of the driving license
     */
    public Date getDateOfIssue() {
        return (Date) dateOfIssue.clone();
    }

    /**
     * Method returns if the driving license is full or not
     * @return true or false
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     * Returns a string representation of the Driving License
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return dl.getFullLicense() ;
    }

    /**
     * Methods returns the first component of the driving license
     * @return The first component of the driving license
     */
    public String getFirstComponent(){
        final String[] licenseParts = getDl().split("-");
        if (licenseParts.length > 3){
            throw new ArrayIndexOutOfBoundsException("More than 3 parts in the license");
        }
       fComponent= licenseParts[0].trim();

        return  fComponent;
    }

    /**
     * Methods returns the second component of the driving license
     * @return The second component of the driving license
     */
    public String getSecondComponent(){
        final String[] licenseParts = getDl().split("-");
        if (licenseParts.length > 3){
            throw new ArrayIndexOutOfBoundsException("More than 3 parts in the license");
        }
        sComponent= licenseParts[1].trim();

        return  sComponent;
    }

    /**
     * Methods returns the third component of the driving license
     * @return The third component of the driving license
     */
    public String getThirdComponent(){
        final String[] licenseParts = getDl().split("-");
        if (licenseParts.length > 3){
            throw new ArrayIndexOutOfBoundsException("More than 3 parts in the license");
        }
        tComponent = licenseParts[2].trim();

        return  tComponent;
    }

}
