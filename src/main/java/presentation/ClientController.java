package presentation;

import business.DeliveryService;
import business.MenuItem;
import business.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * clasa pentru a defini controller-ul pentru client
 */
public class ClientController {
    HashMap<String, MenuItem> hashMap;
    ClientView clientView;
    DeliveryService deliveryService;
    ArrayList<String> titles;
    ArrayList<MenuItem> menuItems;
    int idUser;
    HashMap<Order, ArrayList<MenuItem>> orders;
    DefaultListModel defaultListModel;


    public ClientController(int idUser) throws IOException, ClassNotFoundException {
        deliveryService = new DeliveryService();
        deliveryService.chooseFile();
        hashMap = deliveryService.getHashMap();
        clientView = new ClientView(hashMap);
        defaultListModel= clientView.defaultListModel;
        this.idUser=idUser;

    }
    /**
     * metoda pentru a adauga Action Listener pe butoane
     */

    public void functionalities() {
        clientView.logOut.addActionListener(e -> {
            clientView.frame.setVisible(false);
            try {
                LoginController loginController = new LoginController();
                loginController.actionListenerForButton1();
                loginController.actionListenerForButton2();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        clientView.searchProducts.addActionListener(e -> {
            String keyword = clientView.jTextFieldKeyword.getText();
            float minRating = Float.parseFloat(clientView.jTextFieldMinRating.getText());
            float maxRating = Float.parseFloat(clientView.jTextFieldMaxRating.getText());
            float minProteins = Float.parseFloat(clientView.jTextFieldMinProteins.getText());
            float maxProteins = Float.parseFloat(clientView.jTextFieldMaxProteins.getText());
            float minFats = Float.parseFloat(clientView.jTextFieldMinFats.getText());
            float maxFats = Float.parseFloat(clientView.jTextFieldMaxFats.getText());
            float minSodium = Float.parseFloat(clientView.jTextFieldMinSodium.getText());
            float maxSodium = Float.parseFloat(clientView.jTextFieldMaxSodium.getText());
            float minCalories = Float.parseFloat(clientView.jTextFieldMinCalories.getText());
            float maxCalories = Float.parseFloat(clientView.jTextFieldMaxCalories.getText());
            float minPrice = Float.parseFloat(clientView.jTextFieldMinPrice.getText());
            float maxPrice = Float.parseFloat(clientView.jTextFieldMaxPrice.getText());

            HashMap<String, MenuItem> hashMap2 = deliveryService.filterProducts(keyword, minPrice, maxPrice, minRating, maxRating, minCalories, maxCalories, minFats, maxFats, minSodium, maxSodium, minProteins, maxProteins);
            refreshTable(hashMap2);

        });

        clientView.clearFilters.addActionListener(e -> {
            clientView.jTextFieldKeyword.setText("");
            clientView.jTextFieldMinCalories.setText("0");
            clientView.jTextFieldMaxCalories.setText("10000");
            clientView.jTextFieldMinProteins.setText("0");
            clientView.jTextFieldMaxProteins.setText("10000");
            clientView.jTextFieldMinFats.setText("0");
            clientView.jTextFieldMaxFats.setText("10000");
            clientView.jTextFieldMinSodium.setText("0");
            clientView.jTextFieldMaxSodium.setText("10000");
            clientView.jTextFieldMinRating.setText("0");
            clientView.jTextFieldMaxRating.setText("5");
            clientView.jTextFieldMinPrice.setText("0");
            clientView.jTextFieldMaxPrice.setText("10000");
            refreshTable(hashMap);
        });
        clientView.createOrder.addActionListener(e -> {


            titles = new ArrayList<>();
            menuItems = new ArrayList<>();
            for (int i = 0; i < clientView.defaultListModel.size(); i++)
                titles.add(clientView.defaultListModel.get(i).toString());
            for (String title : titles
            ) {
                menuItems.add(hashMap.get(title));
                //System.out.println(hashMap.get(title));

            }
            int idOrder=0;
            try {
                orders=deliveryService.getOrders();
            } catch (IOException | ClassNotFoundException ex) {
                idOrder=1;
            }
            if(idOrder!=1)
            idOrder = orders.size()+1;
            Order order=new Order(idOrder,idUser, LocalDateTime.now(),menuItems);
            //System.out.println(order.getOrderId() + "  " + order.getClientId() + "  " + order.getLocalDateTime().toString()+"  "+ order.getProducts());
            try {
                deliveryService.createOrder(order);

                JOptionPane.showMessageDialog(clientView.frame, "Thank you for your order!"+
                        "Order number is "+idOrder,
                        "Order Status",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        });
        clientView.addToCart.addActionListener(e -> {
            int row = clientView.table.getSelectedRow();
            TableModel model = clientView.table.getModel();
            String name = model.getValueAt(row, 0).toString();
            clientView.defaultListModel.add(clientView.i, name);
            clientView.i++;
            JOptionPane.showMessageDialog(clientView.frame,
                    name + "added to cart!",
                    "Cart Status",
                    JOptionPane.PLAIN_MESSAGE);
        });

        clientView.deleteCart.addActionListener(e -> {
            clientView.defaultListModel.clear();
            clientView.i = 0;
        });

        clientView.deleteFromCart.addActionListener(e -> {
            int index = clientView.cart.getSelectedIndex();
            if (index >= 0) {
                clientView.defaultListModel.remove(index);
                clientView.i--;
            }
        });
    }

    /**
     * metoda pentru a actualiza tabelul
     */

    public void refreshTable(HashMap<String, MenuItem> hashMap2) {
        DefaultTableModel tableModel = (DefaultTableModel) clientView.table.getModel();
        tableModel.setRowCount(0);
        tableModel.fireTableStructureChanged();
        for (HashMap.Entry<String, MenuItem> entry : hashMap2.entrySet()) {
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().getCalories(),
                    entry.getValue().getProteins(), entry.getValue().getFats(), entry.getValue().getSodium(),
                    entry.getValue().getRating(), entry.getValue().getPrice()});
        }
        clientView.setDefaultTableModel(tableModel);

    }
}

