package bus;

public class Vehicle implements IMileageEfficiency {
    private String serialNumber;
    private String made;
    private String model;
    protected float tripCounter;

    public Vehicle(){

    }
    
    public void makeTrip(){

    }

    // Encapsulation
    public String getSerialNumber(){
        return this.serialNumber;
    }
    public void setSerialNumber(String value){
        this.serialNumber = value;
    }

    public String getMade(){
        return this.made;
    }
    public void setMade(String value){
        this.made = value;
    }

    public String getModel(){
        return this.model;
    }
    public void setModel(String value){
        this.model = value;
    }

    // toString
    public String toString(){
        return "";
    }
    
    @Override
    public float getMilesPerGallon() {
        // TODO Auto-generated method stub
        return 0;
    }
}
