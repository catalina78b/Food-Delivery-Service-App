package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * clasa care defineste interfata pentru Login
 */
public class LoginPage {
    private JFrame frame = new JFrame("Food Delivery Service App");
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Welcome back!");
    private JLabel labelUser = new JLabel("Username:");
    private final JTextField userText = new JTextField();
    private final JPasswordField passwordText = new JPasswordField();
    private final JButton btnConectare = new JButton("Login");
    private final JButton btnCreateAccount = new JButton("Create Account");
    Image img = Toolkit.getDefaultToolkit().getImage("icon.png");


    LoginPage() {


        labelTitle.setBounds(130, 25, 120, 25);
        labelUser.setBounds(20, 80, 80, 25);
        userText.setBounds(110, 80, 200, 25);
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(20, 110, 80, 25);
        passwordText.setBounds(110, 110, 200, 25);
        btnCreateAccount.setBounds(40, 200, 130, 30);
        btnConectare.setBounds(180,200,130,30);


        panel.add(labelTitle);
        panel.add(labelUser);
        panel.add(userText);
        panel.add(labelPassword);
        panel.add(passwordText);
        panel.add(btnConectare);
        panel.add(btnCreateAccount);

        panel.setLayout(null);
        panel.setBackground(new Color(179, 217, 255));
        panel.imageUpdate(img,2,20,30,200,200);
        frame.setIconImage(img);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(370, 300);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(JLabel labelTitle) {
        this.labelTitle = labelTitle;
    }

    public JLabel getLabelUser() {
        return labelUser;
    }

    public void setLabelUser(JLabel labelUser) {
        this.labelUser = labelUser;
    }

    public JTextField getUserText() {
        return userText;
    }

    public JPasswordField getPasswordText() {
        return passwordText;
    }

    public JButton getBtnConectare() {
        return btnConectare;
    }

    public JButton getBtnCreateAccount() {
        return btnCreateAccount;
    }

}
