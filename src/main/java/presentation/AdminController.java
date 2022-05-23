package presentation;

import business.BaseProduct;
import business.DeliveryService;
import business.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * clasa care defineste controller-ul pentru admin
 */
public class AdminController {
    DeliveryService deliveryService;
    AdminView adminView;
    HashMap<String, MenuItem> hashMap;
    ArrayList<String> titles = new ArrayList<>();
    int nr = 0;

    public AdminController() throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        deliveryService = new DeliveryService();
        deliveryService.chooseFile();
        hashMap = deliveryService.getHashMap();
        adminView = new AdminView(hashMap);

    }
    /**
     * metoda pentru a adauga Action Listener pe butoane
     */
    public void functionalities() {

        adminView.getjButtonBack().addActionListener(e -> {
            adminView.getFrame().setVisible(false);
            try {
                LoginController loginController = new LoginController();
                loginController.actionListenerForButton1();
                loginController.actionListenerForButton2();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        adminView.getAddProduct().addActionListener(e -> {
            String title = adminView.getjTextFieldTitle().getText();
            float proteins = Float.parseFloat(adminView.getjTextFieldProteins().getText());
            float fats = Float.parseFloat(adminView.getjTextFieldFats().getText());
            float calories = Float.parseFloat(adminView.getjTextFieldCalories().getText());
            float sodium = Float.parseFloat(adminView.getjTextFieldSodium().getText());
            float rating = Float.parseFloat(adminView.getjTextFieldRating().getText());
            float price = Float.parseFloat(adminView.getjTextFieldPrice().getText());
            BaseProduct baseProduct = new BaseProduct(title, rating, calories, proteins, fats, sodium, price);
            try {
                deliveryService.addProduct(baseProduct);
                refreshTable();
                clearTextFields();
                JOptionPane.showMessageDialog(adminView.getFrame(),
                        "New product added succesfully!",
                        "Product Status",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        adminView.getDeleteProduct().addActionListener(e -> {
            String title = adminView.getjTextFieldTitle().getText();
            BaseProduct baseProduct = (BaseProduct) hashMap.get(title);
            try {
                deliveryService.removeProduct(baseProduct);

                JOptionPane.showMessageDialog(adminView.getFrame(),
                        "Selected product was deleted succesfully!",
                        "Product Status",
                        JOptionPane.PLAIN_MESSAGE);
                refreshTable();
                clearTextFields();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        adminView.getEditProduct().addActionListener(e -> {
            String title = adminView.getjTextFieldTitle().getText();
            float proteins = Float.parseFloat(adminView.getjTextFieldProteins().getText());
            float fats = Float.parseFloat(adminView.getjTextFieldFats().getText());
            float calories = Float.parseFloat(adminView.getjTextFieldCalories().getText());
            float sodium = Float.parseFloat(adminView.getjTextFieldSodium().getText());
            float rating = Float.parseFloat(adminView.getjTextFieldRating().getText());
            float price = Float.parseFloat(adminView.getjTextFieldPrice().getText());
            BaseProduct bp = (BaseProduct) hashMap.get(title);
            try {
                deliveryService.modifyProduct(bp, title, price, calories, proteins, sodium, fats, rating);
                refreshTable();
                clearTextFields();
                JOptionPane.showMessageDialog(adminView.getFrame(),
                        "Selected product was modified succesfully!",
                        "Product Status",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        adminView.getTable().getSelectionModel().addListSelectionListener(event -> {
            if (adminView.getTable().getSelectedRow() > -1) {
                adminView.getjTextFieldTitle().setText(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 0).toString());
                adminView.getjTextFieldCalories().setText(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 1).toString());
                adminView.getjTextFieldProteins().setText(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 2).toString());
                adminView.getjTextFieldFats().setText(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 3).toString());
                adminView.getjTextFieldSodium().setText(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 4).toString());
                adminView.getjTextFieldRating().setText(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 5).toString());
                adminView.getjTextFieldPrice().setText(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 6).toString());

            }
        });
        adminView.getAddButton().addActionListener(event -> {
            String title = adminView.getjTextFieldTitle().getText();
            titles.add(title);
            nr++;
            JOptionPane.showMessageDialog(adminView.getFrame(),
                    nr + " products were added to composite product!",
                    "Composite Product Status",
                    JOptionPane.PLAIN_MESSAGE);
        });
        adminView.getCreateCompositeProduct().addActionListener(event -> {
            String title = adminView.getjTextFieldTitleComp().getText();
            System.out.println(title);
            float rating = Float.parseFloat(adminView.getjTextFieldRatingComp().getText());
            try {
                deliveryService.addCompositeProduct(titles, title, rating);
                refreshTable();
            } catch (IOException e) {
                e.printStackTrace();
            }
            nr = 0;
            titles.clear();
            clearTextFields();
            JOptionPane.showMessageDialog(adminView.getFrame(),
                    "Composite Product was created!",
                    "Composite Product Status",
                    JOptionPane.PLAIN_MESSAGE);
        });
        adminView.getGenerateRaport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReportController reportController = new ReportController();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    /**
     * metoda pentru a seta textul din textFields
     */

    public void clearTextFields() {
        adminView.getjTextFieldRatingComp().setText("");
        adminView.getjTextFieldTitleComp().setText("");
        adminView.getjTextFieldRating().setText("");
        adminView.getjTextFieldPrice().setText("");
        adminView.getjTextFieldCalories().setText("");
        adminView.getjTextFieldFats().setText("");
        adminView.getjTextFieldProteins().setText("");
        adminView.getjTextFieldTitle().setText("");
        adminView.getjTextFieldSodium().setText("");
    }
    /**
     * metoda pentru a actualiza tabelul
     */
    public void refreshTable() {
        DefaultTableModel tableModel = (DefaultTableModel) adminView.getTable().getModel();
        tableModel.setRowCount(0);
        tableModel.fireTableStructureChanged();
        for (HashMap.Entry<String, MenuItem> entry : hashMap.entrySet()) {
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().getCalories(),
                    entry.getValue().getProteins(), entry.getValue().getFats(), entry.getValue().getSodium(),
                    entry.getValue().getRating(), entry.getValue().getPrice()});
        }
        adminView.setDefaultTableModel(tableModel);

    }
}


