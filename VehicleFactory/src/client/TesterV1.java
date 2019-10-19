package client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import bus.ElectricVehicle;
import bus.GasVehicle;
import bus.SNComparator;
import bus.Validator;
import bus.Vehicle;

public class TesterV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		GasVehicle gasVehicle = new GasVehicle();
		gasVehicle.makeTrip();
		gasVehicle.setSerialNumber("6012345678900");
		gasVehicle.setMade("Chevrolet");
		gasVehicle.setModel("Bumblebee");
		vehicleList.add(gasVehicle);

		ElectricVehicle electricVehicle = new ElectricVehicle();
		electricVehicle.makeTrip();
		electricVehicle.setSerialNumber("5012345678900");
		electricVehicle.setMade("ChevroletEEEE");
		electricVehicle.setModel("BumblebeeEEEEE");
		vehicleList.add(electricVehicle);

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
		int index = Collections.binarySearch(vehicleList, new Vehicle("5012345678900", null, null), SNComp);
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
		int rIndex = Collections.binarySearch(vehicleList, new Vehicle("5012345678900", null, null), SNComp);
		System.out.println("\nThe vehicle you are searching: ");
		System.out.println("Remove: " + vehicleList.get(rIndex));
		vehicleList.remove(index);
		System.out.println();

		

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
