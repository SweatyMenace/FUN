
public class Offer {
    private String carType;
    private int numberOfSeats;
    private double farePerMeter;
    private String location;
    private String mobileNumber;

    public Offer(String carType, int numberOfSeats, double farePerMeter, String location, String mobileNumber) {
        this.carType = carType;
        this.numberOfSeats = numberOfSeats;
        this.farePerMeter = farePerMeter;
        this.location = location;
        this.mobileNumber = mobileNumber;
    }

    public String getCarType() {
        return carType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getFarePerMeter() {
        return farePerMeter;
    }

    public String getLocation() {
        return location;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }
}
