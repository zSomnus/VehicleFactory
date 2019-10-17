package bus;

public class GasVehicle extends Vehicle{

    private float fuelConsumed;

    public GasVehicle(){
        super();
        super.tripCounter = 100;
    }

    @Override
    public void makeTrip() {
        super.tripCounter = 100.f;
        this.fuelConsumed = 5.3f;
        //setFuelConsumed(5.3f);
    
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
        return super.toString() + "[Fuel Consumed: " + this.fuelConsumed + "] ";
    }

    @Override

    public float getMilesPerGallon() {
        return super.tripCounter / this.fuelConsumed;
    }
}