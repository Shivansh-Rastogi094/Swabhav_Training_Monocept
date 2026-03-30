package q2;

import java.util.Comparator;

public class FlightComparator implements Comparator<Flight> {

    public int compare(Flight f1, Flight f2) {

        return Double.compare(f2.fare, f1.fare);
    }
}