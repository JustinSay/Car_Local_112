import java.util.*;
public class User {
    private String username;
    private String email;
    private String password;
    private String location;
    private List<Car> carsForSale;
    private List<Part> partsForSale;
    private List<Car> watchlistCars;
    private List<Part> watchlistParts;

    public User(String username, String email, String password, String location) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
        this.carsForSale = new ArrayList<>();
        this.partsForSale = new ArrayList<>();
        this.watchlistCars = new ArrayList<>();
        this.watchlistParts = new ArrayList<>();
    }

    public User(User other) {
        this.username = other.username;
        this.email = other.email;
        this.password = other.password;
        this.location = other.location;
        this.carsForSale = new ArrayList<>(other.carsForSale);
        this.partsForSale = new ArrayList<>(other.partsForSale);
        this.watchlistCars = new ArrayList<>(other.watchlistCars);
        this.watchlistParts = new ArrayList<>(other.watchlistParts);
    }

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Car> getCarsForSale() {
        return carsForSale;
    }

    public List<Part> getPartsForSale() {
        return partsForSale;
    }

    public List<Car> getWatchlistCars() {
        return watchlistCars;
    }

    public List<Part> getWatchlistParts() {
        return watchlistParts;
    }

    // Methods to add listings or to watchlists

    public void addCarForSale(Car car) {
        carsForSale.add(car);
    }

    public void addPartForSale(Part part) {
        partsForSale.add(part);
    }

    public void addToWatchlist(Car car) {
        watchlistCars.add(car);
    }

    public void addToWatchlist(Part part) {
        watchlistParts.add(part);
    }

    @Override
    public String toString() {
        return "User: " + username +
                " | Email: " + email +
                " | Location: " + location +
                " | Cars listed: " + carsForSale.size() +
                " | Parts listed: " + partsForSale.size();
    }
}
