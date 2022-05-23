package start;

import business.DeliveryService;
import presentation.LoginController;

import java.io.IOException;

/**
 * clasa Main pentru rularea aplicatiei
 */
public class Main {

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LoginController loginController=new LoginController();
        loginController.actionListenerForButton1();
        loginController.actionListenerForButton2();

}}

