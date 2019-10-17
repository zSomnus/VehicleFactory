package bus;

public class ElectricVehicle extends Vehicle implements IMileageEfficiency{

    private float kilowattsPowerConsumed;
    
    public ElectricVehicle(){
        super();
    }

    // Encapsulation
    public float getKilowattsPowerConsumed(){
        return this.kilowattsPowerConsumed;
    }
    public void setKilowattsPowerConsumed(float value){
        this.kilowattsPowerConsumed = value;
    }

    public String toString(){
        return "";
    }

    @Override
    public float getMilesPerGallon() {
        return super.tripCounter / this.kilowattsPowerConsumed;
    }
}