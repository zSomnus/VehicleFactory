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

import java.io.FileInputStream; import java.io.FileOutputStream; import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; import java.io.IOException;

public class TesterV1 {
	@SuppressWarnings("unchecked")

	public static void main(String[] args) throws IOException, ClassNotFoundException {
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
		
		Scanner inputScanner = new Scanner(System.in);
		String userInput = "";
		// Add vehicle
		System.out.println("Choose vehicle type");
		System.out.println(" 1. Gas vehicle");
		System.out.println(" 2. Electric vehicle");
		userInput = inputScanner.nextLine();
		while(true){
			if(userInput.equals("1")){
				GasVehicle gasVehicle2 = new GasVehicle();
				System.out.println("Input S/N:");
				userInput = inputScanner.nextLine();
				gasVehicle2.setSerialNumber(userInput);

				System.out.println("Input Made:");
				userInput = inputScanner.nextLine();
				gasVehicle2.setMade(userInput);

				
				
				System.out.println("Input ");

				break;
			}else if(userInput.equals("2")){
				break;
			}else{
				System.out.println("Input invalid, please try again.");
			}
		}



		// Search vehicle
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

		// Remove vehicle
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

		ArrayList<Vehicle> listFromConsole = vehicleList;
		ArrayList<Vehicle> listFromFile = vehicleList;

		FileOutputStream fos = new FileOutputStream("vehicles.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		oos.writeObject(listFromConsole);
		
		//Read from Serialized file(persons.ser)
		FileInputStream fis = new FileInputStream("vehicles.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		listFromFile =    (ArrayList<Vehicle>) ois.readObject();
		
		System.out.println(listFromFile);
		System.out.println("\n .....Data from File....");
		for(Vehicle record : listFromFile)
		{
			System.out.println(record);			
		}

		inputScanner.close();
		oos.close();
		ois.close();
	}
}
