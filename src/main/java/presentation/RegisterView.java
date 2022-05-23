package presentation;

import javax.swing.*;
import java.awt.*;
/**
 * clasa care defineste interfata pentru register
 */
public class RegisterView {
    private final JFrame frame = new JFrame("Register");
    private JTextField firstNameTextField = new JTextField();
    private JTextField lastNameTextField = new JTextField();
    private JTextField addressTextField = new JTextField();
    private JTextField usernameTextFiled = new JTextField();
    private JTextField passwordTextField = new JTextField();
    private JTextField phoneNumberTextField = new JTextField();

    public JTextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public void setPhoneNumberTextField(JTextField phoneNumberTextField) {
        this.phoneNumberTextField = phoneNumberTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    private JTextField emailTextField = new JTextField();
    private JButton btnCreateAccount = new JButton("Create Account");
    private final JButton btnBack = new JButton("Back");
    private final String[] roles = { "Admin", "Employee", "Client"};
    JComboBox roleList = new JComboBox(roles);


    RegisterView() {

        JLabel labelTitle = new JLabel("New User:");
        labelTitle.setBounds(200, 15, 120, 25);

        JLabel labelFirstName = new JLabel("First Name:");
        labelFirstName.setBounds(20, 70, 80, 25);
        firstNameTextField.setBounds(110, 70, 150, 25);

        JLabel labelLastName = new JLabel("Last Name:");
        labelLastName.setBounds(20, 100, 80, 25);
        lastNameTextField.setBounds(110, 100, 150, 25);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setBounds(20, 130, 80, 25);
        addressTextField.setBounds(110,130,150,25);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(20, 160, 80, 25);
        emailTextField.setBounds(110,160,150,25);

        JLabel labelPhoneNumber = new JLabel("PhoneNumber:");
        labelPhoneNumber.setBounds(20, 190, 80, 25);
        phoneNumberTextField.setBounds(110,190,150,25);

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(20, 220, 80, 25);
        usernameTextFiled.setBounds(110,220,150,25);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(20, 250, 80, 25);
        passwordTextField.setBounds(110,250,150,25);

        JLabel labelRole = new JLabel("Role:");
        labelRole.setBounds(20,280,150,25);
        roleList.setBounds(110,280,150,25);

        btnBack.setBounds(20,320,150,30);
        btnCreateAccount.setBounds(170,320,150,30);


        JPanel panel = new JPanel();
        panel.add(emailTextField);
        panel.add(labelEmail);
        panel.add(phoneNumberTextField);
        panel.add(labelPhoneNumber);
        panel.add(btnBack);
        panel.add(labelRole);
        panel.add(roleList);
        panel.add(labelTitle);
        panel.add(labelFirstName);
        panel.add(labelLastName);
        panel.add(labelAddress);
        panel.add(labelUsername);
        panel.add(labelPassword);
        panel.add(btnCreateAccount);
        panel.add(firstNameTextField);
        panel.add(lastNameTextField);
        panel.add(addressTextField);
        panel.add(usernameTextFiled);
        panel.add(passwordTextField);


        panel.setLayout(null);
        panel.setBackground(new Color(179, 217, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public void setFirstNameTextField(JTextField firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    public void setAddressTextField(JTextField addressTextField) {
        this.addressTextField = addressTextField;
    }

    public JTextField getUsernameTextFiled() {
        return usernameTextFiled;
    }

    public void setUsernameTextFiled(JTextField usernameTextFiled) {
        this.usernameTextFiled = usernameTextFiled;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public JButton getBtnCreateAccount() {
        return btnCreateAccount;
    }

    public void setBtnCreateAccount(JButton btnCreateAccount) {
        this.btnCreateAccount = btnCreateAccount;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JFrame getFrame() {
        return frame;
    }
}
