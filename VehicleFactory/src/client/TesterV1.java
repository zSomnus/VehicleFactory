package client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import bus.ColorEnum;
import bus.ElectricVehicle;
import bus.GasVehicle;
import bus.SNComparator;
import bus.Validator;
import bus.Vehicle;

public class TesterV1 {

	public static void main(String[] args) {
		// Initial vehicle list
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		GasVehicle gasVehicle = new GasVehicle();
		gasVehicle.makeTrip();
		gasVehicle.setSerialNumber("1J8HH58276C369338");
		gasVehicle.setMade("Chevrolet");
		gasVehicle.setModel("Bumblebee");
		gasVehicle.setColor(ColorEnum.Black);
		vehicleList.add(gasVehicle);

		ElectricVehicle electricVehicle = new ElectricVehicle();
		electricVehicle.makeTrip();
		electricVehicle.setSerialNumber("2CNFLEE5XB6348347");
		electricVehicle.setMade("Model S");
		electricVehicle.setModel("Tesla");
		electricVehicle.setColor(ColorEnum.White);
		vehicleList.add(electricVehicle);

		System.out.println("List:");
		for(Vehicle element : vehicleList){
			if(element instanceof GasVehicle){
				System.out.println(element + "[Fuel Consumption: " + ((GasVehicle)element).getMilesPerGallon() + "]");
			}else if(element instanceof ElectricVehicle){
				System.out.println(element + "[Fuel Consumption: " + ((ElectricVehicle)element).getMilesPerGallon() + "]");
			}
		}

		// Add vehicle
		Scanner inputScanner = new Scanner(System.in);
		String userInput = "";
		System.out.println("\nSearch by S/N");

		while(true){
			System.out.println("Input your S/N");
			userInput = inputScanner.nextLine();
			Validator validator = new Validator();
			if(validator.stringValidate(userInput, vehicleList)){
				break;
			}else{
				System.out.println("Input not valid");
			}
		}
		
		SNComparator SNComp = new SNComparator();
		Collections.sort(vehicleList, SNComp);
		int index = Collections.binarySearch(vehicleList, new Vehicle(userInput, null, null, null), SNComp);
		System.out.println("\nThe vehicle you are searching: ");
		System.out.println(vehicleList.get(index));
		System.out.println();

		System.out.println("\nRemove");
		while(true){
			System.out.println("Input your S/N:");
			userInput = inputScanner.nextLine();
			Validator validator = new Validator();
			if(validator.stringValidate(userInput, vehicleList)){
				break;
			}else{
				System.out.println("Input not valid");
			}
		}
		int rIndex = Collections.binarySearch(vehicleList, new Vehicle(userInput, null, null, null), SNComp);
		System.out.println("\nThe vehicle you are searching: ");
		System.out.println("Remove: " + vehicleList.get(rIndex));
		vehicleList.remove(index);
		System.out.println();

		
		System.out.println("List:");
		for(Vehicle element : vehicleList){
			if(element instanceof GasVehicle){
				System.out.println(element + "[Fuel Consumption: " + ((GasVehicle)element).getMilesPerGallon() + "]");
			}else if(element instanceof ElectricVehicle){
				System.out.println(element + "[Fuel Consumption: " + ((ElectricVehicle)element).getMilesPerGallon() + "]");
			}
		}

		inputScanner.close();
	}
}
