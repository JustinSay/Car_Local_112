import java.util.*;
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Car and Parts Marketplace!");

        Scanner input = new Scanner(System.in);

        // Sample data (can be replaced with file I/O or user input later)
        ArrayList<Car> carListings = new ArrayList<>();
        ArrayList<Part> partListings = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();


        //Sample of adding a car - sample add of john doe as user with password for authentication checking
        users.add(new User("john_doe", "password123", "john@example.com",
                "John Doe"));
        User john = users.get(0);
        carListings.add(new Car("Toyota", "Camry", 2010, "FWD",
                false, 120000, 7500, "Sedan", john.getUsername(),
                john.getLocation()));


        partListings.add(new Part("Brake Pads", "Brakes", "New", 120.0,
                "Toyota", "Camry", 2008, 2011,
                "john_doe", true, 100));


        //second sample user jane doe
        User jane = new User("jane_doe", "pass456", "jane@example.com", "Winston Salem");
        users.add(jane);


        john.addCarForSale(carListings.get(0));
        john.addPartForSale(partListings.get(0));


        // Interactive menu loop
        boolean running = true;
        User currentUser = null;
        while (running) {


            System.out.println("\n==== Car Marketplace ====");
            System.out.println("0. Login");
            System.out.println("1. View Cars");
            System.out.println("2. View Parts");
            System.out.println("3. Search Cars");
            System.out.println("4. Exit");
            System.out.println("5. View Cars Near Me");
            System.out.println("6. Bid on Auction Parts");
            System.out.println("7. Add a Car Listing");
            System.out.println("8. Add a Part Listing");


            System.out.print("Select an option: ");

            int choice = input.nextInt();
            input.nextLine(); // clear newline

            switch (choice) {
                case 0:
                    currentUser = login(input, users);
                    break;

                case 1:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    System.out.println("\n-- Car Listings --");
                    for (Car car : carListings) {
                        System.out.println(car);
                    }
                    break;

                case 2:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    System.out.println("\n-- Part Listings --");
                    for (Part part : partListings) {
                        System.out.println(part);
                    }
                    break;

                case 3:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    filterCars(input, carListings);
                    break;

                case 4:
                    running = false;
                    break;

                case 5:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    System.out.print("Enter your location: ");
                    String location = input.nextLine().trim().toLowerCase();
                    for (Car car : carListings) {
                        if (car.getLocation().toLowerCase().contains(location)) {
                            System.out.println(car);
                        }
                    }
                    break;

                case 6:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    placeBid(input, partListings);
                    break;

                case 7:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    addCarListing(input, carListings, currentUser);
                    break;

                case 8:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }
                    addPartListing(input, partListings, currentUser);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        input.close();
    }

    public static void filterCars(Scanner input, ArrayList<Car> carListings) {
        System.out.print("Enter make (or press Enter to skip): ");
        String makeFilter = input.nextLine().trim().toLowerCase();

        System.out.print("Enter category (SUV, Sedan, etc.): ");
        String categoryFilter = input.nextLine().trim().toLowerCase();

        System.out.print("Max mileage (or -1 to skip): ");
        int maxMileage = input.nextInt();
        input.nextLine(); // clear buffer


        System.out.print("Enter location (or press Enter to skip): ");
        String locationFilter = input.nextLine().trim().toLowerCase();


        System.out.println("\n-- Filtered Cars --");
        for (Car car : carListings) {
            boolean matches = true;

            if (!makeFilter.isEmpty() && !car.getMake().toLowerCase().contains(makeFilter)) {
                matches = false;
            }

            if (!categoryFilter.isEmpty() && !car.getCategory().toLowerCase().contains(categoryFilter)) {
                matches = false;
            }

            if (maxMileage != -1 && car.getMileage() > maxMileage) {
                matches = false;
            }
            if (!locationFilter.isEmpty() && !car.getLocation().toLowerCase().contains(locationFilter)) {
                matches = false;
            }

            if (matches) {
                System.out.println(car);
            }

        }
    }
    public static void placeBid(Scanner input, ArrayList<Part> partListings) {
        System.out.println("\n-- Auction Parts --");
        ArrayList<Part> auctionParts = new ArrayList<>();

        for (Part part : partListings) {
            if (part.isForAuction()) {
                auctionParts.add(part);
                System.out.println(auctionParts.size() + ". " + part);
            }
        }

        if (auctionParts.isEmpty()) {
            System.out.println("No parts available for auction.");
            return;
        }

        System.out.print("Select part number to bid on: ");
        int index = input.nextInt() - 1;
        input.nextLine(); // clear buffer

        if (index < 0 || index >= auctionParts.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Part selectedPart = auctionParts.get(index);
        double currentBid = selectedPart.getCurrentBid();
        double minBid = currentBid + currentBid * 0.05;

        System.out.printf("Current bid: $%.2f\n", currentBid);
        System.out.printf("Enter your bid (minimum: $%.2f): ", minBid);
        double bid = input.nextDouble();
        input.nextLine();

        if (bid >= minBid) {
            selectedPart.setCurrentBid(bid);
            System.out.println("Bid placed successfully! New bid: $" + bid);
        } else {
            System.out.println("Bid too low. No changes made.");
        }
    }
    public static void addCarListing(Scanner input, ArrayList<Car> carListings, User currentUser) {
        System.out.println("\n-- Add a Car Listing --");

        System.out.print("Enter make: ");
        String make = input.nextLine();

        System.out.print("Enter model: ");
        String model = input.nextLine();

        System.out.print("Enter year: ");
        int year = input.nextInt();
        input.nextLine();

        System.out.print("Enter drivetrain (FWD, RWD, AWD, etc.): ");
        String drivetrain = input.nextLine();

        System.out.print("Has it been in any accidents? (yes/no): ");
        boolean hasAccidents = input.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Enter mileage: ");
        int mileage = input.nextInt();
        input.nextLine();

        System.out.print("Enter price: ");
        double price = input.nextDouble();
        input.nextLine();

        System.out.print("Enter category (Sedan, SUV, etc.): ");
        String category = input.nextLine();

        // Seller username and location come from the current user
        Car newCar = new Car(make, model, year, drivetrain, hasAccidents, mileage, price,
                category, currentUser.getUsername(), currentUser.getLocation());

        carListings.add(newCar);
        currentUser.addCarForSale(newCar);

        System.out.println("Car listing added successfully!");
    }
    public static void addPartListing(Scanner input, ArrayList<Part> partListings, User currentUser) {
        System.out.println("\n-- Add a Part Listing --");

        System.out.print("Enter part name: ");
        String name = input.nextLine();

        System.out.print("Enter category (e.g., Engine, Brakes, Exhaust): ");
        String category = input.nextLine();

        System.out.print("Enter condition (New, Used, Refurbished): ");
        String condition = input.nextLine();

        System.out.print("Enter price: ");
        double price = input.nextDouble();
        input.nextLine(); // Clear buffer

        System.out.print("Compatible make: ");
        String compatibleMake = input.nextLine();

        System.out.print("Compatible model: ");
        String compatibleModel = input.nextLine();

        System.out.print("Compatible year start: ");
        int yearStart = input.nextInt();
        input.nextLine();

        System.out.print("Compatible year end: ");
        int yearEnd = input.nextInt();
        input.nextLine();

        System.out.print("Is this part for auction? (yes/no): ");
        boolean forAuction = input.nextLine().trim().equalsIgnoreCase("yes");

        double currentBid = 0;
        if (forAuction) {
            System.out.print("Enter starting bid: ");
            currentBid = input.nextDouble();
            input.nextLine(); // clear buffer
        }

        Part newPart = new Part(name, category, condition, price,
                compatibleMake, compatibleModel,
                yearStart, yearEnd,
                currentUser.getUsername(), forAuction, currentBid);

        partListings.add(newPart);
        currentUser.addPartForSale(newPart);

        System.out.println("Part listing added successfully!");
    }

    public static User login(Scanner input, ArrayList<User> users) {
        System.out.println("\n-- User Login --");
        System.out.print("Enter username: ");
        String username = input.nextLine().trim();

        System.out.print("Enter password: ");
        String password = input.nextLine().trim();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + user.getUsername() + ".");
                return user;
            }
        }

        System.out.println("Invalid credentials. Try again.");
        return null;
    }

}


