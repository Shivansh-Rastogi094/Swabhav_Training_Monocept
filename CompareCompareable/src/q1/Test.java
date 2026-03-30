package q1;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Candidate> list = new ArrayList<>();

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= n; i++) {

            System.out.println("Enter details for candidate " + i);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            list.add(new Candidate(name, age));
        }

        Collections.sort(list, new CandidateComparator());

        System.out.println("\nSorted Candidate List:");

        for(Candidate c : list) {
            System.out.println(c);
        }

        sc.close();
    }
}