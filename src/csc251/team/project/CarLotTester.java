package csc251.team.project;

import java.sql.SQLException;

public class CarLotTester {
	public static void main(String[] args) {
		CarLot lot = new CarLot();
		lot.addCar("1", 10000, 30, 12500, 17500);
		lot.addCar("2", 10000, 10, 10000, 10000);
		lot.addCar("3", 12000, 20, 12000, 12000);
		lot.addCar("4", 165000, 20, 8000, 9500);
		lot.addCar("5", 80000, 26, 14000, 18000);
		lot.addCar("6", 5000, 32, 30000, 33000);

		//
		String separator1 = "----------------------------------------------------------------------";
		String separator2 = "------------------------------------------------------------------------------------------";
		System.out.println("Inventory: ");
		System.out.println(separator1);
		System.out.println("ID    Mileage     MPG     Is Sold?    Cost          Sale Price");
		System.out.println(separator1);
		for (Car car : lot.getInventory()) {
			System.out.println(car);
		}


		// Print identifier and MPG of car with the best MPG
		System.out.println("\nThe car on the lot with the best MPG is car #" + lot.getCarWithBestMPG().getId() + " with " + lot.getCarWithBestMPG().getMpg() + " miles per gallon.");


		// Print identifier and mileage of car with the highest mileage
		System.out.println("The car on the lot with the highest mileage is car #" + lot.getCarWithHighestMileage().getId() + " with " + lot.getCarWithHighestMileage().getMileage() + " miles.");


		// Print average MPG of all the cars in CarLot
		System.out.println("The average MPG of all the cars in the lot is " + lot.getAverageMpg() + " miles per gallon.");

		// Sell cars
		lot.sellCar("1", 17500);
		System.out.print("Sold car #" + lot.findCarByIdentifier("1").getId() + "\n");
		lot.sellCar("4", 9500);
		System.out.print("Sold car #" + lot.findCarByIdentifier("4").getId() + "\n");

		// Print total profit from sales
		System.out.print("The total profit from all the cars that have been sold is $");
		System.out.printf("%.2f", lot.getTotalProfit());
		System.out.println(".");

		System.out.println("\nUpdated Inventory: ");
		System.out.println(separator2);
		System.out.println("ID    Mileage     MPG     Is Sold?    Cost           Sale Price     Sold for      Profit");
		System.out.println(separator2);
		for (Car car : lot.getInventory()) {
			System.out.println(car);
		}

		System.out.print("\n");

		try {
			lot.saveInventory(lot.getInventory());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
