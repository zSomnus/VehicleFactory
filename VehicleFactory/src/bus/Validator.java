package bus;

import java.util.ArrayList;

public class Validator{
    public boolean stringValidate(String value, ArrayList<Vehicle> list){
        for(Vehicle element : list){
            if(element.getSerialNumber() == value){
                return true;
            }
        }
        System.out.println("Your input is not valid");
        return false;
    }
}