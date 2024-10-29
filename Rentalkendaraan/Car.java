public class Car extends Vehicle {
    public Car(String licensePlate, String brand) {
        super(licensePlate, brand);
    }

    
    public String getVehicleType() {
        return "Car";
    }
}
