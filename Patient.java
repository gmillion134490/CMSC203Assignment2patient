/*
 * Class: CMSC203 CRN XXXX
 * Program: Assignment 2 - Patient
 * Instructor: Huseyin Aygun
 * Description: This program asks for the patient's information and prints everything out with the average charges.
 * Due Date: 9/28/2026
 * Platform/Compiler: Eclipse IDE
 * Integrity Pledge: I pledge that I have completed the programming assignment
 *                   independently. I have not copied the code from a student
 *                   or any source.
 * Student: Gabriela Million
 */
public class Patient {

    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String emergencyName;
    private String emergencyPhone;

    // This is the no-arg constructor. It sets everything to an empty string.
    public Patient() {
        firstName = "";
        middleName = "";
        lastName = "";
        streetAddress = "";
        city = "";
        state = "";
        zip = "";
        phone = "";
        emergencyName = "";
        emergencyPhone = "";
    }

    // This constructor sets the first, middle, and last name.
    // Everything else is set to an empty string.
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        streetAddress = "";
        city = "";
        state = "";
        zip = "";
        phone = "";
        emergencyName = "";
        emergencyPhone = "";
    }

    // This constructor sets all of the patient's information.
    public Patient(String firstName, String middleName, String lastName,
                   String streetAddress, String city, String state, String zip,
                   String phone, String emergencyName, String emergencyPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.emergencyName = emergencyName;
        this.emergencyPhone = emergencyPhone;
    }

    // Returns the first name.
    public String getFirstName() {
        return firstName;
    }

    // Returns the middle name.
    public String getMiddleName() {
        return middleName;
    }

    // Returns the last name.
    public String getLastName() {
        return lastName;
    }

    // Returns the street address.
    public String getStreetAddress() {
        return streetAddress;
    }

    // Returns the city.
    public String getCity() {
        return city;
    }

    // Returns the state.
    public String getState() {
        return state;
    }

    // Returns the zip code.
    public String getZip() {
        return zip;
    }

    // Returns the phone number.
    public String getPhone() {
        return phone;
    }

    // Returns the emergency contact's name.
    public String getEmergencyName() {
        return emergencyName;
    }

    // Returns the emergency contact's phone number.
    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    // Changes the first name.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Changes the middle name.
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Changes the last name.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Changes the street address.
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    // Changes the city.
    public void setCity(String city) {
        this.city = city;
    }

    // Changes the state.
    public void setState(String state) {
        this.state = state;
    }

    // Changes the zip code.
    public void setZip(String zip) {
        this.zip = zip;
    }

    // Changes the phone number.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Changes the emergency contact's name.
    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    // Changes the emergency contact's phone number.
    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    // Puts the first, middle, and last name together and returns it.
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Puts the street, city, state, and zip together and returns it.
    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zip;
    }

    // Puts the emergency contact's name and phone together and returns it.
    public String buildEmergencyContact() {
        return emergencyName + " " + emergencyPhone;
    }

    // Returns all of the patient's information using the build methods.
    public String toString() {
        return "Name: " + buildFullName() + "\n"
                + "Address: " + buildAddress() + "\n"
                + "Phone Number: " + phone + "\n"
                + "Emergency Contact: " + buildEmergencyContact();
    }

    // Returns true if the phone number looks like ###-###-####.
    public boolean isValidPhoneNumber() {
        return checkPhone(phone);
    }

    // Returns true if the emergency phone number looks like ###-###-####.
    public boolean isValidEmergencyPhoneNumber() {
        return checkPhone(emergencyPhone);
    }

    // This helper method checks one phone number. The number must be 12
    // characters long, with dashes in spots 3 and 7 and digits everywhere else.
    private boolean checkPhone(String number) {
        if (number.length() != 12) {
            return false;
        }
        for (int i = 0; i < 12; i++) {
            char c = number.charAt(i);
            if (i == 3 || i == 7) {
                if (c != '-') {
                    return false;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Returns the name like this: Last, First Middle
    public String getLastFirstMiddle() {
        return lastName + ", " + firstName + " " + middleName;
    }

    // Returns true if the patient lives in the same city and state.
    // It does not care about capital letters.
    public boolean hasSameCityState(String city, String state) {
        return this.city.equalsIgnoreCase(city)
                && this.state.equalsIgnoreCase(state);
    }

    // Changes the whole address at once.
    public void updateAddress(String street, String city, String state,
                              String zip) {
        this.streetAddress = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Returns the patient's contact information and emergency contact
    // information on separate lines.
    public String getContactSummary() {
        return "Patient: " + getLastFirstMiddle() + "\n"
                + "Phone: " + phone + "\n"
                + "Emergency Contact: " + emergencyName + "\n"
                + "Emergency Phone: " + emergencyPhone;
    }
}
