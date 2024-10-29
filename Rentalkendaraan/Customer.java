import java.util.ArrayList;

public class Customer {
    private String name;
    private String id;
    private ArrayList<Vehicle> rentedVehicles;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.rentedVehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void rentVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
        vehicle.setAvailable(false);
    }
}
