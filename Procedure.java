import java.text.DecimalFormat;

/*
 * Class: CMSC203 CRN XXXX
 * Program: Assignment 2 - Procedure
 * Instructor: Huseyin Aygun
 * Description: This program asks for the patient's information and prints everything out with the average charges.
 * Due Date: 9/28/2026
 * Platform/Compiler: Eclipse IDE
 * Integrity Pledge: I pledge that I have completed the programming assignment
 *                   independently. I have not copied the code from a student
 *                   or any source.
 * Student: Gabriela Million
 */
public class Procedure {

    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charges;

    // This is the no-arg constructor. The words are empty and the charge is 0.
    public Procedure() {
        procedureName = "";
        procedureDate = "";
        practitionerName = "";
        charges = 0.0;
    }

    // This constructor sets the procedure name and the date.
    // The practitioner is empty and the charge is 0.
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        practitionerName = "";
        charges = 0.0;
    }

    // This constructor sets all four things.
    public Procedure(String procedureName, String procedureDate,
                     String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    // Returns the procedure name.
    public String getProcedureName() {
        return procedureName;
    }

    // Returns the procedure date.
    public String getProcedureDate() {
        return procedureDate;
    }

    // Returns the practitioner's name.
    public String getPractitionerName() {
        return practitionerName;
    }

    // Returns the charge.
    public double getCharges() {
        return charges;
    }

    // Changes the procedure name.
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    // Changes the procedure date.
    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    // Changes the practitioner's name.
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    // Changes the charge.
    public void setCharges(double charges) {
        this.charges = charges;
    }

    // Returns all of the procedure's information.
    public String toString() {
        return "Procedure: " + procedureName + "\n"
                + "Date: " + procedureDate + "\n"
                + "Practitioner: " + practitionerName + "\n"
                + "Charge: " + getFormattedCharge();
    }

    // Returns true if the charge is 1000.00 or more.
    public boolean isExpensiveProcedure() {
        return charges >= 1000.00;
    }

    // Takes a percent off the charge. The percent has to be from 0 to 100.
    // If it is not, nothing changes.
    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100) {
            charges = charges - (charges * percent / 100);
        }
    }

    // Returns "Low" if the charge is under 500, "Medium" if it is 500 up to
    // 1000, and "High" if it is 1000 or more.
    public String getChargeCategory() {
        if (charges < 500) {
            return "Low";
        } else if (charges < 1000) {
            return "Medium";
        } else {
            return "High";
        }
    }

    // Returns true if the given name is the practitioner for this procedure.
    // It does not care about capital letters.
    public boolean isPerformedBy(String practitionerName) {
        return this.practitionerName.equalsIgnoreCase(practitionerName);
    }

    // Returns the charge with a dollar sign, commas, and two decimal places.
    public String getFormattedCharge() {
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        return money.format(charges);
    }
}
