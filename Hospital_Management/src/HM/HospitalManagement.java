package HM;
import java.util.Scanner;

public class HospitalManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Staff[] staff = new Staff[10];   // store up to 10 staff
        int count = 0;

        int choice;

        do {

            System.out.println("\n===== Hospital Staff Menu =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Nurse");
            System.out.println("3. Display All Staff");
            System.out.println("4. Update Department");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    if (count >= staff.length) {
                        System.out.println("Staff storage full.");
                        break;
                    }

                    System.out.print("Enter Doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String ddept = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();

                    staff[count] = new Doctor(did, dname, ddept, spec);
                    count++;

                    System.out.println("Doctor added successfully.");
                    break;

                case 2:

                    if (count >= staff.length) {
                        System.out.println("Staff storage full.");
                        break;
                    }

                    System.out.print("Enter Nurse ID: ");
                    int nid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Nurse Name: ");
                    String nname = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String ndept = sc.nextLine();

                    System.out.print("Enter Shift: ");
                    String shift = sc.nextLine();

                    staff[count] = new Nurse(nid, nname, ndept, shift);
                    count++;

                    System.out.println("Nurse added successfully.");
                    break;

                case 3:

                    if (count == 0) {
                        System.out.println("No staff records available.");
                    } else {

                        System.out.println("\n===== Staff Records =====");

                        for (int i = 0; i < count; i++) {
                            staff[i].displayInfo();
                        }
                    }

                    break;

                case 4:

                    System.out.print("Enter staff index to update department (0-" + (count - 1) + "): ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index >= 0 && index < count) {

                        System.out.print("Enter new Department: ");
                        String newDept = sc.nextLine();

                        staff[index].setDepartment(newDept);

                        System.out.println("Department updated.");

                    } else {
                        System.out.println("Invalid staff index.");
                    }

                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 5);

        sc.close();
    }
}