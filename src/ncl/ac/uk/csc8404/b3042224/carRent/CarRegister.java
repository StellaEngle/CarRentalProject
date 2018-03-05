package ncl.ac.uk.csc8404.b3042224.carRent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Stella on 21/10/2016.
 */
public final class CarRegister {

    private final String strFinal;
    private final static Map<String,CarRegister> CAR_REGISTER_MAP = new HashMap<>();
    private String fComponent;
    private String sComponent;

    /**
     * Constructor, creates a new registration number
     * for a car.
     * @param f The concatenated registration number of a car
     *          passed by the getInstance method
     */
    private  CarRegister(String f){
        this.strFinal=f;
    }


    /**
     * Static getInstance method. It creates a unique
     * registration number for a car. The newly created
     * number is checked against the values in the HashMap to check if its unique
     * or not before passing it to the Constructor method.
     * @return Returns the new registration number
     * @throws IllegalArgumentException If a registration number is created twice
     */
    public static CarRegister getInstance(){
        Random rand = new Random();
        String fComp= "";
        String sComp= "";
        int n;
        n=rand.nextInt(100)+10;
        for(int i=0; i<2;i++){
            int r = rand.nextInt(26);
            String alp= "abcdefghijklmnopqrstuvwxyz";
            fComp+= (alp.charAt(r));

        }

        for(int i=0; i<2;i++){
            int r = rand.nextInt(26);
            String alp= "abcdefghijklmnopqrstuvwxyz";
           sComp+= (alp.charAt(r));

        }

        final String strFinal = (fComp+n +" "+sComp).toUpperCase();
        if(!CAR_REGISTER_MAP.containsKey(strFinal)){
            CAR_REGISTER_MAP.put(strFinal, new CarRegister(strFinal));
            return CAR_REGISTER_MAP.get(strFinal);
        }else{
            throw new IllegalArgumentException("Duplicate Car Register Number");
        }
    }

    /**
     * Methods returns the String representation of the registration number
     * of the car.
     * @return The registration number.
     */
    public String getStrFinal() {
        return strFinal;
    }

    /**
     * Methods returns the first component of the registration number
     * @return The first component of the registration number.
     */
    public String getFirstComponent(){
        final String[] register = getStrFinal().split(" ");
        if (register.length > 2){
            throw new ArrayIndexOutOfBoundsException("More than 2 parts in the Car Registration Number");
        }
        fComponent= register[0].trim();

        return  fComponent;
    }

    /**
     * Methods returns the second component of the registration number
     * @return The second component of the registration number.
     */
    public String getSecondComponent(){
        final String[] register = getStrFinal().split(" ");
        if (register.length > 2){
            throw new ArrayIndexOutOfBoundsException("More than 2 parts in the Car Registration Number");
        }
        sComponent= register[1].trim();

        return  sComponent;
    }

    /**
     * Method returns the registration number created
     * @return The registration numbers.
     */
    public static Map<String, CarRegister> getCarRegisterMap() {
        return CAR_REGISTER_MAP;
    }

}
