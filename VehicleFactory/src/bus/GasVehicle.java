package bus;

public class GasVehicle extends Vehicle{

    private float fuelConsumed;

    public GasVehicle(){
        super();
        super.tripCounter = 100;
    }

    // Encapsulation
    public float getFuelConsumed(){
        return this.fuelConsumed;
    }
    public void setFuelConsumed(float fuelConsumed){
        this.fuelConsumed = fuelConsumed;
    }

    // toString
    public String toString(){
        return "";
    }

    @Override
    public float getMilesPerGallon() {
        return super.tripCounter / this.fuelConsumed;
    }
}