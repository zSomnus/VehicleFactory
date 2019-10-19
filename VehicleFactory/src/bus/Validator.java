package bus;

import java.util.ArrayList;

public class Validator{

    private boolean isValid = false;

    public boolean stringValidate(String value, ArrayList<Vehicle> list){
        for(Vehicle element : list){
            if(element.getSerialNumber().equals(value)){
                System.out.println("Your input is valid");
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}