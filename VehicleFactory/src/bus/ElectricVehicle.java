package bus;

public class ElectricVehicle extends Vehicle{

    private float kilowattsPowerConsumed;
    
    public ElectricVehicle(){
        super();
        this.kilowattsPowerConsumed = 0;
    }

    @Override
    public void makeTrip(){
        super.tripCounter = 100f;
        this.kilowattsPowerConsumed = 4.44f;
        //setKilowattsPowerConsumed(4.44f);
    }

    // Encapsulation
    public float getKilowattsPowerConsumed(){
        return this.kilowattsPowerConsumed;
    }
    public void setKilowattsPowerConsumed(float value){
        this.kilowattsPowerConsumed = value;
    }

    public String toString(){
        return super.toString() + "[KwPower Consumed: " + this.kilowattsPowerConsumed + "] ";
    }

    @Override
    public float getMilesPerGallon() {
        return super.tripCounter / this.kilowattsPowerConsumed;
    }
}