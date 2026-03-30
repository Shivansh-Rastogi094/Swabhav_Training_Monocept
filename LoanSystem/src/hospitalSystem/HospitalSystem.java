package hospitalSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalSystem {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<HospitalService> services = new ArrayList<>();

		int choice = 0;

		do {

			System.out.println("\n===== Hospital Appointment System =====");
			System.out.println("1. General Consultation");
			System.out.println("2. Surgery");
			System.out.println("3. Diagnostic Test");
			System.out.println("4. View Services");
			System.out.println("5. Process Services");
			System.out.println("6. Exit");

			System.out.print("Enter choice: ");

			try {

				choice = sc.nextInt();

				switch (choice) {

				case 1:
				case 2:
				case 3:

					int id = readServiceID();
					String name = readPatientName();
					double fee = readFee();

					HospitalService service = null;

					if (choice == 1)
						service = new GeneralConsultation(id, name, fee);

					else if (choice == 2)
						service = new Surgery(id, name, fee);

					else
						service = new DiagnosticTest(id, name, fee);

					services.add(service);

					System.out.println("Service added successfully!");
					break;

				case 4:

					if (services.isEmpty())
						System.out.println("No services available.");
					else
						for (HospitalService s : services)
							s.displayService();

					break;

				case 5:

					if (services.isEmpty()) {
						System.out.println("No services to process.");
						break;
					}

					for (HospitalService s : services) {

						s.displayService();

						ServiceValidation v = (ServiceValidation) s;

						if (v.validateService())
							s.processService();
						else
							System.out.println("Service validation failed!");

						System.out.println("------------------------");
					}

					break;

				case 6:
					System.out.println("Exiting system...");
					break;

				default:
					System.out.println("Invalid choice.");
				}

			} catch (InputMismatchException e) {

				System.out.println("Invalid input type.");
				sc.nextLine();

			} catch (InvalidServiceException e) {

				System.out.println("Service Error: " + e.getMessage());
			}

		} while (choice != 6);

		sc.close();
	}

	static int readServiceID() {

		while (true) {

			System.out.print("Enter Service ID: ");

			if (!sc.hasNextInt()) {
				System.out.println("Service ID must be numeric.");
				sc.next();
				continue;
			}

			int id = sc.nextInt();

			if (id <= 0) {
				System.out.println("Service ID must be positive.");
				continue;
			}

			return id;
		}
	}

	static String readPatientName() {

		sc.nextLine();

		while (true) {

			System.out.print("Enter Patient Name: ");
			String name = sc.nextLine().trim();

			if (name.isEmpty()) {
				System.out.println("Name cannot be empty.");
				continue;
			}

			if (!name.matches("[a-zA-Z ]+")) {
				System.out.println("Name should contain letters only.");
				continue;
			}

			return name;
		}
	}

	static double readFee() {

		while (true) {

			System.out.print("Enter Consultation Fee: ");

			if (!sc.hasNextDouble()) {
				System.out.println("Invalid fee.");
				sc.next();
				continue;
			}

			double fee = sc.nextDouble();

			if (fee <= 0) {
				System.out.println("Fee must be positive.");
				continue;
			}

			return fee;
		}
	}
}