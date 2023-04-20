package csc251.team.project;

import java.util.ArrayList;

// CarLotTest class
public class CarLotTester {
	public static void main(String[] args){
		CarLot myLot = new CarLot();
		// Add 5 different cars for test, with respective identifiers, mileage, mpg, cost, and asking price.
		myLot.addCar("1", 100000, 24, 16000.00, 18500.00);
		myLot.addCar("2", 24000, 30, 20000.00, 24000.00);
		myLot.addCar("3", 165000, 20, 8000.00, 9500.00);
		myLot.addCar("4", 80000, 26, 14000.00, 18000.00);
		myLot.addCar("5", 5000, 32, 30000.00, 33000.00);

		try {
			// Sell two selected cars and print the total profit of the two sold cars
			myLot.sellCar("2", 23000.00);
			myLot.sellCar("4", 16500.00);
		}
		catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}

		// Display table of cars in inventory
		System.out.println("\nCars for Sale");
		System.out.println("-------------------------------------------------------------------------");
		ArrayList<Car> inventory1 = myLot.getInventory();
		System.out.println("ID    Mileage   MPG    Cost        Asking Price    Sale Price   Is Sold?");
		System.out.println("-------------------------------------------------------------------------");
		for (int i = 0; i < inventory1.size(); i++) {
			System.out.printf("%-6s", inventory1.get(i).getId());
			System.out.printf("%-10d", inventory1.get(i).getMileage());
			System.out.printf("%-7d", inventory1.get(i).getMpg());
			System.out.printf("%-12s", inventory1.get(i).getCost());
			System.out.printf("%-16s", inventory1.get(i).getAskingPrice());
			System.out.printf("%-13s", inventory1.get(i).getSalePrice());
			System.out.printf("%-8b", inventory1.get(i).getIsSold());
			System.out.println("");
		}

		// Print identifier and MPG of car with the best MPG
		System.out.println("\nThe car on the lot with the best MPG is car #" + myLot.getCarWithBestMpg().getId() + " with " + myLot.getCarWithBestMpg().getMpg() + " miles per gallon.");


		// Print identifier and mileage of car with the highest mileage
		System.out.println("The car on the lot with the highest mileage is car #" + myLot.getCarWithHighestMileage().getId() + " with " + myLot.getCarWithHighestMileage().getMileage() + " miles.");


		// Print avg MPG of all the cars in CarLot
		System.out.println("The average MPG of all the cars in the lot is " + myLot.getAverageMpg() + " miles per gallon.");

		// Print total profit from sales
		System.out.println("The total profit from all the cars that have been sold is $" + myLot.getTotalProfit() + ".");
	}
}
