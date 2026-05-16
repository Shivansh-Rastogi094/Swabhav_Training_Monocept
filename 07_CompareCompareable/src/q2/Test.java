package q2;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Flight> list = new ArrayList<>();

        System.out.print("Enter number of flights: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= n; i++) {

            System.out.println("Enter details for flight " + i);

            System.out.print("Airline: ");
            String airline = sc.nextLine();

            System.out.print("Fare: ");
            double fare = sc.nextDouble();
            sc.nextLine();

            list.add(new Flight(airline, fare));
        }

        Collections.sort(list, new FlightComparator());

        System.out.println("\nFlights sorted by highest fare:");

        for(Flight f : list) {
            System.out.println(f);
        }

        sc.close();
    }
}