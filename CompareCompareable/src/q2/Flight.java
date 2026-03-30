package q2;

public class Flight {

    String airline;
    double fare;

    public Flight(String airline, double fare) {
        this.airline = airline;
        this.fare = fare;
    }

    public String toString() {
        return airline + " - " + fare;
    }
}