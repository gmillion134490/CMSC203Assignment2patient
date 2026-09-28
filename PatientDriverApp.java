import java.util.Scanner;

/*
 * Class: CMSC203 CRN XXXX
 * Program: Assignment 2 - PatientDriverApp
 * Instructor: Huseyin Aygun
 * Description: This program asks for the patient's information and prints everything out with the average charges.
 * Due Date: 9/28/2026
 * Platform/Compiler: Eclipse IDE
 * Integrity Pledge: I pledge that I have completed the programming assignment
 *                   independently. I have not copied the code from a student
 *                   or any source.
 * Student: Gabriela Million
 */
public class PatientDriverApp {

    // This is where the program starts. It gets the patient, makes the three
    // procedures, and prints everything.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Patient patient = inputPatient(input);
        Procedure p1 = createProcedure1();
        Procedure p2 = createProcedure2();
        Procedure p3 = createProcedure3();

        displayPatient(patient);
        System.out.println();
        displayProcedureTable(p1, p2, p3);
        System.out.println();
        displaySummary(p1, p2, p3);
        System.out.println();

        System.out.println("The program was developed by a Student: Gabriela Million 09/28/26");

        input.close();
    }

    // Asks the user for the patient's information, then makes a Patient
    // object with it and returns it.
    public static Patient inputPatient(Scanner input) {
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter middle name: ");
        String middleName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter street address: ");
        String street = input.nextLine();
        System.out.print("Enter city: ");
        String city = input.nextLine();
        System.out.print("Enter state: ");
        String state = input.nextLine();
        System.out.print("Enter zip: ");
        String zip = input.nextLine();
        System.out.print("Enter phone number (###-###-####): ");
        String phone = input.nextLine();
        System.out.print("Enter emergency contact name: ");
        String emergencyName = input.nextLine();
        System.out.print("Enter emergency contact phone (###-###-####): ");
        String emergencyPhone = input.nextLine();

        Patient patient = new Patient(firstName, middleName, lastName, street,
                city, state, zip, phone, emergencyName, emergencyPhone);
        return patient;
    }

    // Makes the first procedure using the constructor with all four things.
    public static Procedure createProcedure1() {
        Procedure p = new Procedure("Annual Checkup", "03/15/2026",
                "Dr. Alvarez", 250.00);
        return p;
    }

    // Makes the second procedure using the constructor with the name and date.
    // Then the setters are used to add the practitioner and the charge.
    public static Procedure createProcedure2() {
        Procedure p = new Procedure("MRI Scan", "03/15/2026");
        p.setPractitionerName("Dr. Chen");
        p.setCharges(550.43);
        return p;
    }

    // Makes the third procedure using the no-arg constructor.
    // Then the setters are used to fill in all four things.
    public static Procedure createProcedure3() {
        Procedure p = new Procedure();
        p.setProcedureName("Blood Panel");
        p.setProcedureDate("03/15/2026");
        p.setPractitionerName("Dr. Whitfield");
        p.setCharges(1400.75);
        return p;
    }

    // Prints the patient's information and whether the phone numbers are valid.
    public static void displayPatient(Patient patient) {
        System.out.println();
        System.out.println("Patient Information");
        System.out.println("-------------------");
        System.out.println(patient.toString());
        System.out.println("Phone Valid: " + patient.isValidPhoneNumber());
        System.out.println("Emergency Phone Valid: "
                + patient.isValidEmergencyPhoneNumber());
    }

    // Prints the information for one procedure.
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }

    // Prints the three procedures in a table with the columns lined up.
    public static void displayProcedureTable(Procedure p1, Procedure p2,
                                             Procedure p3) {
        System.out.printf("%-20s%-13s%-20s%-16s%s\n", "Procedure", "Date",
                "Practitioner", "Charge", "Category");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-13s%-20s%-16s%s\n", p1.getProcedureName(),
                p1.getProcedureDate(), p1.getPractitionerName(),
                p1.getFormattedCharge(), p1.getChargeCategory());
        System.out.printf("%-20s%-13s%-20s%-16s%s\n", p2.getProcedureName(),
                p2.getProcedureDate(), p2.getPractitionerName(),
                p2.getFormattedCharge(), p2.getChargeCategory());
        System.out.printf("%-20s%-13s%-20s%-16s%s\n", p3.getProcedureName(),
                p3.getProcedureDate(), p3.getPractitionerName(),
                p3.getFormattedCharge(), p3.getChargeCategory());
    }

    // Adds up the charges of the three procedures and returns the total.
    public static double calculateTotalCharges(Procedure p1, Procedure p2,
                                               Procedure p3) {
        double total = p1.getCharges() + p2.getCharges() + p3.getCharges();
        return total;
    }

    // Finds the average of the three charges and returns it.
    public static double calculateAverageCharge(Procedure p1, Procedure p2,
                                                Procedure p3) {
        double average = calculateTotalCharges(p1, p2, p3) / 3;
        return average;
    }

    // Looks at the three charges and returns the procedure with the biggest one.
    public static Procedure findHighestChargeProcedure(Procedure p1,
                                                       Procedure p2,
                                                       Procedure p3) {
        Procedure highest = p1;
        if (p2.getCharges() > highest.getCharges()) {
            highest = p2;
        }
        if (p3.getCharges() > highest.getCharges()) {
            highest = p3;
        }
        return highest;
    }

    // Counts how many of the three procedures are expensive and returns the count.
    public static int countExpensiveProcedures(Procedure p1, Procedure p2,
                                               Procedure p3) {
        int count = 0;
        if (p1.isExpensiveProcedure()) {
            count++;
        }
        if (p2.isExpensiveProcedure()) {
            count++;
        }
        if (p3.isExpensiveProcedure()) {
            count++;
        }
        return count;
    }

    // Prints the total charges, the average charge, the highest charge
    // procedure, and how many procedures are expensive.
    public static void displaySummary(Procedure p1, Procedure p2, Procedure p3) {
        double total = calculateTotalCharges(p1, p2, p3);
        double average = calculateAverageCharge(p1, p2, p3);
        Procedure highest = findHighestChargeProcedure(p1, p2, p3);
        int expensive = countExpensiveProcedures(p1, p2, p3);

        System.out.printf("Total Charges: $%,.2f\n", total);
        System.out.printf("Average Charge: $%,.2f\n", average);
        System.out.println("Highest Charge Procedure: "
                + highest.getProcedureName());
        System.out.println("Number of Expensive Procedures: " + expensive);
    }
}
