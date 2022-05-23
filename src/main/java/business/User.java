package business;

import java.io.Serializable;

/**
 * clasa User cu atributele care definesc un utilizator oarecare, implementeaza Serializable
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private ROLE role;
    public User()
    {

    }
    public User(int id, String name, String password,String firstName,String lastName,String address,String phoneNumber,String email)
    {
        this.id=id;
        this.name=name;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
}
