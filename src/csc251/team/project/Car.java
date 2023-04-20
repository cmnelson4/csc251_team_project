package csc251.team.project;

/** Car.java is used by CarLotTest.java for construction of car objects */
// Car Class
// Attributes
public class Car {
	String id;
	int mileage;
	int mpg;
	double cost;
	double askingPrice;
	double salePrice;
	boolean isSold = false;

	// Default constructor
	public Car() {
	}

	// Main constructor
	public Car(String id, int mileage, int mpg, double cost, double askingPrice, double salePrice, boolean isSold) {
		this.id = id;
		this.mileage = mileage;
		this.mpg = mpg;
		this.cost = cost;
		this.askingPrice = askingPrice;
		this.salePrice = salePrice;
		this.isSold = isSold;
	}


	// Setters / Mutators
	public void setId(String id) {
		this.id = id;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public void setIsSold(boolean isSold) {
		this.isSold = isSold;
	}

	// Getters / Accessors
	public String getId() {
		return this.id;
	}

	public int getMileage() {
		return this.mileage;
	}

	public int getMpg() {
		return this.mpg;
	}

	public double getCost() {
		return this.cost;
	}

	public double getAskingPrice() {
		return this.askingPrice;
	}

	public double getSalePrice() {
		return this.salePrice;
	}

	public boolean getIsSold() {
		return this.isSold;
	}
}