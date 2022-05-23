package presentation;

import business.ROLE;
import business.User;
import data.Serializator;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * clasa care defineste controller-ul pentru Register
 */

public class RegisterViewController {
    RegisterView registerView;
    int userFound=0;
    String username, password,firstName,lastName,address,email,phoneNumber;
    List<User> users=new ArrayList<>();
    Serializator serializator;
    String role;

    public RegisterViewController() throws IOException {
        this.registerView = new RegisterView();
        this.serializator = new Serializator();

    }
    /**
     * metoda care adauga Action Listener pe butonul de Create Account
     */


    public void addActionListener() throws IOException, ClassNotFoundException {

        registerView.getBtnCreateAccount().addActionListener(e -> {
            try {
                serializator.deserializationUsers(users);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            username = registerView.getUsernameTextFiled().getText();
            password = registerView.getPasswordTextField().getText();
            firstName=registerView.getFirstNameTextField().getText();
            lastName=registerView.getLastNameTextField().getText();
            address=registerView.getAddressTextField().getText();
            phoneNumber=registerView.getPhoneNumberTextField().getText();
            email=registerView.getEmailTextField().getText();
            User user = new User(users.size()+1, username, password,firstName,lastName,address,phoneNumber,email);
            switch (role) {
                case "Admin":
                    user.setRole(ROLE.ADMIN);
                    break;
                case "Client":
                    user.setRole(ROLE.CLIENT);
                    break;
                case "Employee":
                    user.setRole(ROLE.EMPLOYEE);
                    break;
            }
            for (User user1 : users) {
                if (user.getName().equals(user1.getName())) {
                    userFound=1;
                    JFrame frame = new JFrame("Error Message");
                    JOptionPane.showMessageDialog(frame, "User already exists!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                }}
            if(userFound==0)
            {users.add(user);
                JFrame frame2 = new JFrame("New User");
                JOptionPane.showMessageDialog(frame2, "New user created succesfully!",
                        "", JOptionPane.PLAIN_MESSAGE);

            try {
                serializator.serUsers(users);
            } catch (IOException ex) {
                ex.printStackTrace();
            }}

            for (User user2:users
            ) {
                System.out.println(user2.getName()+user2.getRole()+user2.getId());

            }
        });}
    /**
     * metoda care adauga Action Listener pe roleList
     */


    public void addActionListenerRole()
        {
            registerView.roleList.addActionListener(e -> {
                role = Objects.requireNonNull(registerView.roleList.getSelectedItem()).toString();
                System.out.println(role);
            });
        }
    /**
     * metoda care adauga Action Listener pe butonul de LogOut
     */

    public void addActionListenerBack()
    {
        registerView.getBtnBack().addActionListener(e -> {
            registerView.getFrame().setVisible(false);
            LoginController loginController= null;
            try {
                loginController = new LoginController();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            Objects.requireNonNull(loginController).actionListenerForButton1();
            loginController.actionListenerForButton2();

        });
    }
    }


