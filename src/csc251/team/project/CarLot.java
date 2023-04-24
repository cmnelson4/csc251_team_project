package csc251.team.project;

import java.util.ArrayList;
import java.util.Collections;
import java.sql.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CarLot {
	private ArrayList<Car> inventory = new ArrayList<>();

	public ArrayList<Car> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Car> inventory) {
		this.inventory = inventory;
	}

	public Car findCarByIdentifier(String identifer) {

		for (int i = inventory.size() - 1; i >= 0; i--) {
			if (((inventory.get(i)).getId()).equalsIgnoreCase(identifer))
				return inventory.get(i);
		}
		return null;

	}

	public ArrayList<Car> getCarsInOrderOfEntry() {
		ArrayList<Car> inventoryCopy = new ArrayList<Car>();
		inventoryCopy.addAll(this.inventory);
		return inventoryCopy;
	}

	// Return an ArrayList of all Cars in the inventory, sorted by MPG.
	// This method should not sort the inventory, but should instead make
	// a copy of the inventory and sort the copy
	public ArrayList<Car> getCarsSortedByMPG() {
		ArrayList<Car> inventoryCopy = new ArrayList<Car>();
		inventoryCopy.addAll(this.inventory);
		Collections.sort(inventoryCopy, new Comparator<Car>() {
			@Override
			public int compare(Car car1, Car car2) {
				return Integer.valueOf(car2.getMpg()).compareTo(car1.getMpg());
			}
		});
		return inventoryCopy;
	}

	// Return the Car in the inventory with the highest MPG
	public Car getCarWithBestMPG() {
		Car carMaxMpg = inventory.get(0);
		for (int i = inventory.size() - 1; i > 0; i--) {
			if (carMaxMpg.getMpg() < inventory.get(i).getMpg()) {
				carMaxMpg = inventory.get(i);
			}
		}
		return carMaxMpg;
	}

	// Return the Car in the inventory with the highest mileage
	public Car getCarWithHighestMileage() {
		Car carHighestMil = inventory.get(0);
		for (int i = inventory.size() - 1; i > 0; i--) {
			if (carHighestMil.getMileage() < inventory.get(i).getMileage()) {
				carHighestMil = inventory.get(i);
			}
		}
		return carHighestMil;
	}

	// Return the average MPG of all Cars in the inventory
	public double getAverageMpg() {
		double sum = 0;
		for (int i = inventory.size() - 1; i >= 0; i--) {
			sum += inventory.get(i).getMpg();
		}
		return sum / inventory.size();
	}

	// Return the total profit of all cars in the inventory that have been sold
	public double getTotalProfit() {
		double totalProfit = 0;
		for (int i = inventory.size() - 1; i >= 0; i--) {
			if (inventory.get(i).isSold()) {
				totalProfit += inventory.get(i).getProfit();
			}
		}
		return totalProfit;
	}

	// This is method to show all cars that has been sold.
	public ArrayList<Car> showSoldCars() {
		ArrayList<Car> soldCars = new ArrayList<Car>();
		for (int i = inventory.size() - 1; i >= 0; i--) {
			if (inventory.get(i).isSold()) {
				soldCars.add(inventory.get(i));
			}
		}
		return soldCars;
	}

	// mutators
	public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
		inventory.add(new Car(id, mileage, mpg, cost, salesPrice));
	}

	public void sellCar(String identifier, double priceSold) throws IllegalArgumentException, NullPointerException {
		this.findCarByIdentifier(identifier).sellCar(priceSold);

	}

	// saveToDisk() method
	public void saveToDisk() throws IOException {
		FileWriter writer = new FileWriter("carlot.txt");
		String str = "";
		for (int i = 0; i < inventory.size(); i++) {
			str += (inventory.get(i).getId() + ":" + inventory.get(i).getMileage() + ":" + inventory.get(i).getMpg()
					+ ":"
					+ inventory.get(i).getCost() + ":" + inventory.get(i).getSalesPrice() + "\n");
		}
		writer.write(str);
		writer.close();
	}

	// loadFromDisk() method
	public void loadFromDisk() throws FileNotFoundException {
		File file = new File("carlot.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			String[] array = str.split(":");
			this.addCar(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]), Double.parseDouble(array[3]),
					Double.parseDouble(array[4]));
		}
		scan.close();
	}

	public void establishConnection() throws SQLException {
		new CarLotDatabase("jdbc:mysql://localhost:3306/csc251_project");
	}

	public void saveInventory(ArrayList<Car> arrayList) throws SQLException {
		establishConnection();
		for (Car car : inventory) {
			System.out.printf("Saving %s%n", car.getId());
			try {
				CarLotDatabase.addInventory(car);
			} catch (SQLIntegrityConstraintViolationException e) {
				CarLotDatabase.updateInventory(car);
			}

		}

	}

}
