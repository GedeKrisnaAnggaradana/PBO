import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeVehicles();
        System.out.println("Nama  : Gede Krisna Anggaradana");
        System.out.println("NIM   : 23151010122");
        System.out.println("Kelas : A\n");
        System.out.println("Selamat datang di Rental Kendaraan Pak Sadikin");

        while (true) {
            System.out.println("1. Tambah Pelanggan Baru");
            System.out.println("2. Sewa Kendaraan");
            System.out.println("3. Tampilkan Data Pelanggan");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    rentVehicle();
                    break;
                case 3:
                    displayCustomers();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan Rental Kendaraan Pak Sadikin!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void initializeVehicles() {
        vehicles.add(new Car("B1234ABC", "Toyota"));
        vehicles.add(new Car("B5678DEF", "Honda"));
        vehicles.add(new Car("B4321GHI", "BMW"));
        vehicles.add(new Motorcycle("B9876XYZ", "Yamaha"));
        vehicles.add(new Motorcycle("B5432LMN", "Suzuki"));
        vehicles.add(new Motorcycle("B4321OPQ", "Harley"));
    }

    private static void addCustomer() {
        System.out.print("Masukkan Nama Pelanggan: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan ID Pelanggan: ");
        String id = scanner.nextLine();
        customers.add(new Customer(name, id));
        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    private static void rentVehicle() {
        System.out.print("Masukkan ID Pelanggan: ");
        String id = scanner.nextLine();
        Customer customer = findCustomerById(id);
        
        if (customer == null) {
            System.out.println("Pelanggan tidak ditemukan.");
            return;
        }

        // Tampilkan daftar kendaraan beserta ketersediaannya
        System.out.println("Daftar Kendaraan:");
        for (Vehicle vehicle : vehicles) {
            String availability = vehicle.isAvailable() ? "Tersedia" : "Tidak Tersedia";
            System.out.println("- " + vehicle.getVehicleType() + " " + vehicle.getBrand() + " (No. Polisi: " + vehicle.getLicensePlate() + ") - " + availability);
        }

        System.out.print("Masukkan Nomor Polisi Kendaraan yang ingin disewa: ");
        String licensePlate = scanner.nextLine();
        Vehicle vehicle = checkAvailability(licensePlate);

        if (vehicle != null) {
            customer.rentVehicle(vehicle);
            System.out.println("Kendaraan berhasil disewa.");
        } else {
            System.out.println("Kendaraan tidak tersedia atau nomor polisi tidak valid.");
        }
    }

    private static Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
    }

    private static Vehicle checkAvailability(String licensePlate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equalsIgnoreCase(licensePlate) && vehicle.isAvailable()) {
                return vehicle;
            }
        }
        return null;
    }

    private static void displayCustomers() {
        System.out.println("Data Pelanggan:");
        for (Customer customer : customers) {
            System.out.println("Nama: " + customer.getName());
            System.out.println("ID: " + customer.getId());
            System.out.println("Kendaraan yang Disewa:");
            for (Vehicle vehicle : customer.getRentedVehicles()) {
                System.out.println("- " + vehicle.getVehicleType() + " " + vehicle.getBrand() + " (No. Polisi: " + vehicle.getLicensePlate() + ")");
            }
            System.out.println();
        }
    }
}
