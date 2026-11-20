import java.util.ArrayList;
import java.util.Scanner;

class House {
    int id;
    String location;
    double rent;
    boolean isAvailable;

    House(int id, String location, double rent) {
        this.id = id;
        this.location = location;
        this.rent = rent;
        this.isAvailable = true;
    }

    void displayHouse() {
        System.out.println("House ID: " + id);
        System.out.println("Location: " + location);
        System.out.println("Monthly Rent: Rs." + rent);
        System.out.println("Status: " +
                (isAvailable ? "Available" : "Rented"));
        System.out.println("----------------------");
    }
}

public class HouseRentalSystem {

    static ArrayList<House> houses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addHouse() {
        System.out.print("Enter House ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Monthly Rent: ");
        double rent = sc.nextDouble();

        houses.add(new House(id, location, rent));

        System.out.println("House added successfully!");
    }

    static void viewHouses() {
        if (houses.isEmpty()) {
            System.out.println("No houses available.");
            return;
        }

        for (House h : houses) {
            h.displayHouse();
        }
    }

    static void searchHouse() {
        System.out.print("Enter location to search: ");
        sc.nextLine();
        String location = sc.nextLine();

        boolean found = false;

        for (House h : houses) {
            if (h.location.equalsIgnoreCase(location)
                    && h.isAvailable) {
                h.displayHouse();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available house found.");
        }
    }

    static void rentHouse() {
        System.out.print("Enter House ID to rent: ");
        int id = sc.nextInt();

        for (House h : houses) {
            if (h.id == id && h.isAvailable) {
                h.isAvailable = false;
                System.out.println("House rented successfully!");
                return;
            }
        }

        System.out.println("House not available or invalid ID.");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== HOUSE RENTAL SYSTEM =====");
            System.out.println("1. Add House");
            System.out.println("2. View Houses");
            System.out.println("3. Search House");
            System.out.println("4. Rent House");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addHouse();
                    break;

                case 2:
                    viewHouses();
                    break;

                case 3:
                    searchHouse();
                    break;

                case 4:
                    rentHouse();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
