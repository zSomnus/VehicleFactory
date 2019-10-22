package bus;

public class Vehicle implements IMileageEfficiency {
    private String serialNumber;
    private String made;
    private String model;
    protected float tripCounter;
    private ColorEnum color;


    public Vehicle(){
        this.serialNumber = "";
        this.made = "";
        this.model = "";
        this.tripCounter = 0;
        this.color = ColorEnum.Unknown;
    }

    public Vehicle(String sn, String made, String model, ColorEnum color){
        this.serialNumber = sn;
        this.made = made;
        this.model = model;
        this.color = color;
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

    public ColorEnum getColor(){
        return this.color;
    }
    public void setColor(ColorEnum color){
        this.color = color;
    }

    // toString
    public String toString(){
        return "[S/N: " + this.serialNumber + "] [Made: " + this.made + "] [Modle: " + this.model + "] [Color: " + this.color + "] ";
    }
    
    @Override
    public float getMilesPerGallon() {
        // TODO Auto-generated method stub
        return 0;
    }
}
