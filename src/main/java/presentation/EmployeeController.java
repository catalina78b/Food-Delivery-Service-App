package presentation;

import business.MenuItem;
import business.Order;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * clasa pentru a defini contoller-ul pentru employee, implementeaza clasa Observer si suprascrie metoda de update
 */
public class EmployeeController implements Observer{
    EmployeeView employeeView;
    public EmployeeController() {
        employeeView = new EmployeeView();
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("EMPLOYEE");
        mainFrame.setContentPane(employeeView.employeePanel);
        mainFrame.setPreferredSize(new Dimension(300, 300));
        mainFrame.setSize(500, 300);
        employeeView.employeePanel.setBackground(new Color(179, 217, 255));
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Notified");
        if (arg instanceof Order) {
            employeeView.orderLabel.setText("New order added");
            Order order = (Order) arg;
            employeeView.orderIDField.setText("Order id:"+String.valueOf(order.getOrderId()));
            employeeView.clientIDField.setText("Client id:"+String.valueOf(order.getClientId()));
            employeeView.orderedProductsListModel.removeAllElements();
            for (MenuItem m : order.getProducts()) {
                employeeView.orderedProductsListModel.addElement(m.getTitle());
            }

        }
    }
}

