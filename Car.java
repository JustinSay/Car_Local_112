public class Car {
    private String make;
    private String model;
    private int year;
    private String drivetrain;
    private boolean hasAccidents;
    private int mileage;
    private double price;
    private String category;
    private String sellerUsername;
    private String location;



    public Car(String make, String model, int year, String drivetrain, boolean hasAccidents,
               int mileage, double price, String category, String sellerUsername, String location) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.drivetrain = drivetrain;
        this.hasAccidents = hasAccidents;
        this.mileage = mileage;
        this.price = price;
        this.category = category;
        this.sellerUsername = sellerUsername;
        this.location = location;
    }


    public Car(Car other) {
        this.make = other.make;
        this.model = other.model;
        this.year = other.year;
        this.drivetrain = other.drivetrain;
        this.hasAccidents = other.hasAccidents;
        this.mileage = other.mileage;
        this.price = other.price;
        this.category = other.category;
        this.sellerUsername = other.sellerUsername;
        this.location = other.location;

    }
    //getter and setter


    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setHasAccidents(boolean hasAccidents) {
        this.hasAccidents = hasAccidents;
    }

    public boolean getHasAccidents() {
        return hasAccidents;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " | $" + price + " | Mileage: " + mileage + " | " +
                "Accidents: " + (hasAccidents ? "Yes" : "No") + " | Drive: " + drivetrain +
                " | Category: " + category + " | Seller: " + sellerUsername;

    }
}