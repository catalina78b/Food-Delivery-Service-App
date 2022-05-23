package presentation;

import business.DeliveryService;
import business.User;
import data.Serializator;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * clasa pentru a defini controller-ul pentru Login
 */
public class LoginController {

    LoginPage loginPage;
    String name, password,role;
    Serializator serializator;
    List<User> list=new ArrayList<>();
    AdminController adminController;
    EmployeeController employeeController;
    ClientController clientController;
    int idUser;

    public LoginController() throws IOException, ClassNotFoundException {
        loginPage = new LoginPage();
    }
    /**
     * metoda pentru a defini Action Listener pentru butonul de Create Account
     */
    public void actionListenerForButton1() {
        loginPage.getBtnCreateAccount().addActionListener(e -> {
            try {
                loginPage.getFrame().setVisible(false);
                RegisterViewController registerViewController = new RegisterViewController();
                registerViewController.addActionListenerRole();
                registerViewController.addActionListener();
                registerViewController.addActionListenerBack();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

    }
    /**
     * metoda pentru a defini Action Listener pentru butonul de Conectare
     */

    public void actionListenerForButton2() {
        loginPage.getBtnConectare().addActionListener(e -> {
            int foundUser=0;
            int wrongPass=0;
            name = loginPage.getUserText().getText();
            password = loginPage.getPasswordText().getText();
            System.out.println(name);
            System.out.println(password);
            try {
                serializator=new Serializator();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                serializator.deserializationUsers(list);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }


        for (User user:list
             ) {
            if(user.getName().equals(name) && user.getPassword().equals(password)) {
                foundUser=1;
                System.out.println(user.getId());
                role=user.getRole().toString();
                idUser=user.getId();
                break;
            }
            if(user.getName().equals(name) && !(user.getPassword().equals(password))) {
                foundUser=1;
                wrongPass=1;
                JFrame frame = new JFrame("Error Message");
                JOptionPane.showMessageDialog(frame, "Wrong password!Try again!",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        if(foundUser == 0)
        {
            JFrame frame = new JFrame("Error Message");
            JOptionPane.showMessageDialog(frame, "Inexistent user! Try creating a new account!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
        if(wrongPass == 0)
        {
            switch (role) {
                case "ADMIN":
                    loginPage.getFrame().setVisible(false);
                    try {
                        adminController = new AdminController();
                        adminController.functionalities();
                    } catch (IOException | ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "EMPLOYEE":
                    loginPage.getFrame().setVisible(true);
                    loginPage.getUserText().setText("");
                    loginPage.getPasswordText().setText("");
                    employeeController = new EmployeeController();
                    if(clientController!=null)
                    clientController.deliveryService.addObserver(employeeController);

                    break;
                case "CLIENT":
                    loginPage.getFrame().setVisible(true);
                    loginPage.getUserText().setText("");
                    loginPage.getPasswordText().setText("");
                    try {
                        clientController = new ClientController(idUser);
                        if(employeeController!=null)
                            clientController.deliveryService.addObserver(employeeController);


                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    clientController.functionalities();
                    break;
            }

        }

    });

}}
