package ncl.ac.uk.csc8404.b3042224.carRent;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Stella Englezou
 * on 28/10/2016.
 */
public class CreateDates {

    private final Date date;

    /**
     * Constructor creates a Calendar instance, and sets the date
     * @param day The day of the month.
     * @param month The month of the year.
     * @param year The year.
     */
    public CreateDates(int day, int month, int year) {
        final Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        this.date = cal.getTime();
    }

    /**
     * Method clones the date and returns it.
     * @return Returns a copy of the date
     */
    public Date getDate() {
        return (Date) (date.clone());
    }

}
