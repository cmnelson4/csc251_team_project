package csc251.team.project;

import java.util.ArrayList;
import java.util.ListIterator;

public class CarLot {
	// Inventory attribute
	private ArrayList<Car> inventory = new ArrayList<>();

	// Inventory accessor
	public ArrayList<Car> getInventory() {
		return this.inventory;
	}

	// Inventory mutator
	public void setInventory(ArrayList<Car> inventory) {
		this.inventory = inventory;
	}

	// Find the car with the specified identifier in the inventory.

	// Return an ArrayList of all Cars in the inventory.
	// Find the car with the specified identifier in the inventory.
	public Car findCarByIdentifier(String identifier) {
		Car foundCar = null;
		Car c = null;
		ListIterator it = this.inventory.listIterator();
		while (it.hasNext()) {
			c = (Car) it.next();
			if (identifier.equalsIgnoreCase(c.getId())) {
				foundCar = c;
				break;
			}
		}
		return c;
	}
	// Return an ArrayList of all Cars in the inventory.
	public ArrayList<Car> getAllCars() {
		ArrayList<Car> inventoryCopy = this.inventory;
		return inventoryCopy;
	}

	// Return the Car in the inventory with the best MPG
	public Car getCarWithBestMpg () {
		int bestMpg = 0;
		int indexOfBestMpg = 0;
		for (int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getMpg() > bestMpg) {
				bestMpg = this.inventory.get(i).getMpg();
				indexOfBestMpg = i;
			}
		}
		return this.inventory.get(indexOfBestMpg);
	}

	// Return the Car in the inventory with the highest mileage
	public Car getCarWithHighestMileage () {
		int highestMileage = 0;
		int indexOfHighestMileage = 0;
		for (int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getMileage() > highestMileage) {
				highestMileage = this.inventory.get(i).getMileage();
				indexOfHighestMileage = i;
			}
		}
		return this.inventory.get(indexOfHighestMileage);
	}

	// Return the average MPG of all Cars in the inventory
	public double getAverageMpg() {
		double average = 0.0;
		int sum = 0;
		int size = this.inventory.size();

		for (Car car : this.inventory) {
			sum += car.getMpg();
		}

		average = sum / (double) size;
		return average;
	}

	// Return the total profit of all cars in the inventory that have been sold
	public double getTotalProfit() {
		double totalProfit = 0.0;

		for (Car car : this.inventory) {
			if (car.getIsSold()) {
				double profit = (car.getSalePrice()) - (car.getCost());
				totalProfit += profit;
			}
		}
		return totalProfit;
	}

	// Add a new car with specified data
	public void addCar(String id, int mileage, int mpg, double cost, double askingPrice) {
		Car car = new Car(id, mileage, mpg, cost, askingPrice, 0.0, false);
		this.inventory.add(car);
	}

	// Sell car, throw error if specified car doesn't exist
	public void sellCar(String identifier, double salePrice) throws IllegalArgumentException {
		for (int i = 0; i < this.inventory.size(); i++) {
			if (identifier.equals(this.inventory.get(i).getId())) {
				this.inventory.get(i).setIsSold(true);
				this.inventory.get(i).setSalePrice(salePrice);
				return;
			}
		}
		throw new IllegalArgumentException("Car does not exist");
	}
}