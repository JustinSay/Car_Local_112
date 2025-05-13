public class Part {
    private String name;
    private String category;
    private String condition;
    private double price;
    private String compatibleMake;
    private String compatibleModel;
    private int compatibleYearStart;
    private int compatibleYearEnd;
    private String sellerUsername;
    private boolean forAuction;
    private double currentBid;


    //if part is defined and we need to make an object for the new part
    public Part(String name, String category, String condition, double price,
                String compatibleMake, String compatibleModel, int compatibleYearStart,
                int compatibleYearEnd, String sellerUsername, boolean forAuction, double currentBid) {
        this.name = name;
        this.category = category;
        this.condition = condition;
        this.price = price;
        this.compatibleMake = compatibleMake;
        this.compatibleModel = compatibleModel;
        this.compatibleYearStart = compatibleYearStart;
        this.compatibleYearEnd = compatibleYearEnd;
        this.sellerUsername = sellerUsername;
        this.forAuction = forAuction;
        this.currentBid = currentBid;
    }


    //if a part exists called other and we want to make it identifiable:
    public Part(Part other) {
        this.name = other.name;
        this.category = other.category;
        this.condition = other.condition;
        this.price = other.price;
        this.compatibleMake = other.compatibleMake;
        this.compatibleModel = other.compatibleModel;
        this.compatibleYearStart = other.compatibleYearStart;
        this.compatibleYearEnd = other.compatibleYearEnd;
        this.sellerUsername = other.sellerUsername;
        this.forAuction = other.forAuction;
        this.currentBid = other.currentBid;
    }

    //getter and setter methods:

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompatibleMake() {
        return compatibleMake;
    }

    public void setCompatibleMake(String compatibleMake) {
        this.compatibleMake = compatibleMake;
    }

    public String getCompatibleModel() {
        return compatibleModel;
    }

    public void setCompatibleModel(String compatibleModel) {
        this.compatibleModel = compatibleModel;
    }

    public int getCompatibleYearStart() {
        return compatibleYearStart;
    }

    public void setCompatibleYearStart(int compatibleYearStart) {
        this.compatibleYearStart = compatibleYearStart;
    }

    public int getCompatibleYearEnd() {
        return compatibleYearEnd;
    }

    public void setCompatibleYearEnd(int compatibleYearEnd) {
        this.compatibleYearEnd = compatibleYearEnd;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public boolean isForAuction() {
        return forAuction;
    }

    public void setForAuction(boolean forAuction) {
        this.forAuction = forAuction;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }
    @Override
    public String toString() {
        return name + " | Category: " + category + " | Condition: " + condition +
                " | $" + price + " | Fits: " + compatibleMake + " " + compatibleModel +
                " (" + compatibleYearStart + "-" + compatibleYearEnd + ")" +
                " | Seller: " + sellerUsername +
                (forAuction ? " | Current Bid: $" + currentBid + " (Auction)" : " (Fixed Price)");
    }
}
