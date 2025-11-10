package models;

public class User {
    private String firstName, lastName, address, city, state, zip, phone, ssn, username, password;

    public User(String firstName, String lastName, String address, String city,
                String state, String zip, String phone, String ssn,
                String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.ssn = ssn;
        this.username = username;
        this.password = password;
    }

    // getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getPhone() { return phone; }
    public String getSsn() { return ssn; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
