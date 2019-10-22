package bus;

import java.util.ArrayList;

public class Validator{

    private boolean isValid = false;
    /* 
     * A Vehicle Identification Number (VIN) (also known as a serial number)
     * is a 17 character code of letters and numbers that identifies your vehicle.
     */
    public boolean stringValidate(String value, ArrayList<Vehicle> list){
        if(value.length() != 17 && value.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$")){
            System.out.println("Your input should be 17 characters and number");
            isValid = false;
        }else{
            for(Vehicle element : list){
                if(element.getSerialNumber().equals(value)){
                    isValid = true;
                    break;
                }else{
                    System.out.println("Your input is not in the list...");
                }
            }
        }
        return isValid;
    }
}