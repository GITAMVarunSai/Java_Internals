// Base class: Vehicle
abstract class Vehicle {
    protected String ID;
    protected String model;
    protected double rentalRate;

    // Constructor
    public Vehicle(String ID, String model, double rentalRate) {
        this.ID = ID;
        this.model = model;
        this.rentalRate = rentalRate;
    }

    // Abstract method for rental cost calculation (Polymorphism)
    public abstract double calculateRentalCost(int days);

    // Display vehicle details
    public void displayInfo() {
        System.out.println("ID: " + ID + ", Model: " + model + ", Rental Rate: " + rentalRate);
    }
}

// Car class (subclass of Vehicle)
class Car extends Vehicle {
    private String carType; // Example: Sedan, SUV

    public Car(String ID, String model, double rentalRate, String carType) {
        super(ID, model, rentalRate);
        this.carType = carType;
    }

    @Override
    public double calculateRentalCost(int days) {
        double discount = (days > 5) ? 0.1 : 0.0; // 10% discount if rented for more than 5 days
        return days * rentalRate * (1 - discount);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Car Type: " + carType);
    }
}

// Bike class (subclass of Vehicle)
class Bike extends Vehicle {
    public Bike(String ID, String model, double rentalRate) {
        super(ID, model, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }
}

// Truck class (subclass of Vehicle)
class Truck extends Vehicle {
    private double loadCapacity; // Load capacity in tons

    public Truck(String ID, String model, double rentalRate, double loadCapacity) {
        super(ID, model, rentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate + (loadCapacity * 50); // Additional cost based on load capacity
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Main class to test the Vehicle hierarchy
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("C101", "Toyota Corolla", 100, "Sedan");
        Vehicle bike = new Bike("B202", "Yamaha R15", 50);
        Vehicle truck = new Truck("T303", "Volvo Truck", 200, 5);

        System.out.println("Rental Costs:");
        car.displayInfo();
        System.out.println("Rental Cost for 6 days: $" + car.calculateRentalCost(6) + "\n");

        bike.displayInfo();
        System.out.println("Rental Cost for 3 days: $" + bike.calculateRentalCost(3) + "\n");

        truck.displayInfo();
        System.out.println("Rental Cost for 4 days: $" + truck.calculateRentalCost(4));
    }
}





//output

Rental Costs:
ID: C101, Model: Toyota Corolla, Rental Rate: 100.0
Car Type: Sedan
Rental Cost for 6 days: $540.0

ID: B202, Model: Yamaha R15, Rental Rate: 50.0
Rental Cost for 3 days: $150.0

ID: T303, Model: Volvo Truck, Rental Rate: 200.0
Load Capacity: 5.0 tons
Rental Cost for 4 days: $1200.0
