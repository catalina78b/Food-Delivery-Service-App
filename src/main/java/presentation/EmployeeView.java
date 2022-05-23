package presentation;

import data.Serializator;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * clasa pentru a defini interfata pentru angajat
 */
public class EmployeeView {
    public JLabel orderLabel=new JLabel();
    public JTextField orderIDField=new JTextField();
    public JTextField clientIDField=new JTextField();
    public JList orderedProductsList;
    public DefaultListModel<String> orderedProductsListModel;
    public JPanel employeePanel=new JPanel();

    public EmployeeView() {
        orderedProductsListModel = new DefaultListModel<>();
        orderedProductsList = new JList(orderedProductsListModel);
        employeePanel.add(orderLabel);
        employeePanel.add(clientIDField);
        employeePanel.add(orderIDField);
        employeePanel.add(orderedProductsList);

    }
}
