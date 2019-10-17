package client;

import java.util.ArrayList;

import bus.ElectricVehicle;
import bus.GasVehicle;
import bus.Vehicle;

public class TesterV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		GasVehicle gasVehicle = new GasVehicle();
		gasVehicle.makeTrip();
		gasVehicle.setSerialNumber("5012345678900");
		gasVehicle.setMade("Chevrolet");
		gasVehicle.setModel("Bumblebee");
		vehicleList.add(gasVehicle);

		ElectricVehicle electricVehicle = new ElectricVehicle();
		electricVehicle.makeTrip();
		electricVehicle.setSerialNumber("5012345678900");
		electricVehicle.setMade("Chevrolet");
		electricVehicle.setModel("Bumblebee");
		vehicleList.add(electricVehicle);

		for(Vehicle element : vehicleList){
			if(element instanceof GasVehicle){
				System.out.println(element + "[Fuel Consumption: " + ((GasVehicle)element).getMilesPerGallon() + "]");
			}else if(element instanceof ElectricVehicle){
				System.out.println(element + "[Fuel Consumption: " + ((ElectricVehicle)element).getMilesPerGallon() + "]");
			}
		}
	}

}
