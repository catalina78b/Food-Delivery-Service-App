package presentation;

import business.DeliveryService;
import business.MenuItem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * clasa pentru a defini interfata pentru client
 */
public class ClientView {
    public JScrollPane pane;
    public DefaultTableModel defaultTableModel;
    public JTable table;

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    HashMap<String, MenuItem> hashMap;
    public JList cart;
    public DefaultListModel defaultListModel;
    public ArrayList<String> productsFromCart;
    public int i = 0;
    public JFrame frame = new JFrame("Client Page");
    public JPanel panel = new JPanel();
    public JButton addToCart = new JButton("Add product to cart");
    public JButton deleteFromCart = new JButton("Delete product from cart");
    public JButton deleteCart = new JButton("Empty cart");
    public JButton clearFilters = new JButton("Clear filters");
    public JButton searchProducts = new JButton("Search Products");
    public JButton createOrder = new JButton("Create Order");
    public JButton logOut = new JButton("LogOut");
    JScrollPane scrollPane = new JScrollPane();

    public JLabel searchFilters = new JLabel("Search product by:");
    public JLabel searchByKeyword = new JLabel("Keyword:");
    public JLabel searchMinRating = new JLabel("Min Rating:");
    public JLabel searchMaxRating = new JLabel("Max Rating:");
    public JLabel searchMinCalories = new JLabel("Min Calories:");
    public JLabel searchMaxCalories = new JLabel("Max Calories:");
    public JLabel searchMinFats = new JLabel("Min Fats:");
    public JLabel searchMaxFats = new JLabel("Max Fats:");
    public JLabel searchMinProteins = new JLabel("Min Proteins:");
    public JLabel searchMaxProteins = new JLabel("Max Proteins:");
    public JLabel searchMinSodium = new JLabel("Min Sodium:");
    public JLabel searchMaxSodium = new JLabel("Max Sodium:");
    public JLabel searchMinPrice = new JLabel("Min Price:");
    public JLabel searchMaxPrice = new JLabel("Max Price:");

    public JTextField jTextFieldKeyword = new JTextField();
    public JTextField jTextFieldMinRating = new JTextField("0");
    public JTextField jTextFieldMaxRating = new JTextField("5");
    public JTextField jTextFieldMinCalories = new JTextField("0");
    public JTextField jTextFieldMaxCalories = new JTextField("10000");
    public JTextField jTextFieldMinFats = new JTextField("0");
    public JTextField jTextFieldMaxFats = new JTextField("10000");
    public JTextField jTextFieldMinProteins = new JTextField("0");
    public JTextField jTextFieldMaxProteins = new JTextField("10000");
    public JTextField jTextFieldMinSodium = new JTextField("0");
    public JTextField jTextFieldMaxSodium = new JTextField("10000");
    public JTextField jTextFieldMinPrice = new JTextField("0");
    public JTextField jTextFieldMaxPrice = new JTextField("10000");
    public JLabel jLabelCart = new JLabel("Cart:");

    ClientView(HashMap<String, MenuItem> hashMap) {

        defaultListModel = new DefaultListModel();
        productsFromCart = new ArrayList<>();
        cart = new JList(defaultListModel);
        this.hashMap = hashMap;

        jLabelCart.setBounds(200, 470, 160, 25);
        cart.setBounds(200, 500, 400, 100);

        scrollPane.setBounds(200, 500, 400, 100);

        addToCart.setBounds(60, 20, 160, 25);
        deleteCart.setBounds(220, 20, 140, 25);
        createOrder.setBounds(360, 20, 140, 25);
        deleteFromCart.setBounds(500, 20, 200, 25);

        searchFilters.setBounds(310, 75, 200, 25);
        searchByKeyword.setBounds(260, 125, 200, 25);
        jTextFieldKeyword.setBounds(320, 125, 140, 25);

        searchMinRating.setBounds(120, 160, 140, 25);
        jTextFieldMinRating.setBounds(200, 160, 140, 25);

        searchMaxRating.setBounds(370, 160, 140, 25);
        jTextFieldMaxRating.setBounds(460, 160, 140, 25);

        searchMinCalories.setBounds(120, 195, 140, 25);
        jTextFieldMinCalories.setBounds(200, 195, 140, 25);

        searchMaxCalories.setBounds(370, 195, 140, 25);
        jTextFieldMaxCalories.setBounds(460, 195, 140, 25);

        searchMinFats.setBounds(120, 230, 140, 25);
        jTextFieldMinFats.setBounds(200, 230, 140, 25);

        searchMaxFats.setBounds(370, 230, 140, 25);
        jTextFieldMaxFats.setBounds(460, 230, 140, 25);

        searchMinProteins.setBounds(120, 265, 140, 25);
        jTextFieldMinProteins.setBounds(200, 265, 140, 25);

        searchMaxProteins.setBounds(370, 265, 140, 25);
        jTextFieldMaxProteins.setBounds(460, 265, 140, 25);

        searchMinSodium.setBounds(120, 300, 140, 25);
        jTextFieldMinSodium.setBounds(200, 300, 140, 25);

        searchMaxSodium.setBounds(370, 300, 140, 25);
        jTextFieldMaxSodium.setBounds(460, 300, 140, 25);

        searchMinPrice.setBounds(120, 335, 140, 25);
        jTextFieldMinPrice.setBounds(200, 335, 140, 25);

        searchMaxPrice.setBounds(370, 335, 140, 25);
        jTextFieldMaxPrice.setBounds(460, 335, 140, 25);

        clearFilters.setBounds(260, 390, 160, 25);
        logOut.setBounds(60, 390, 160, 25);
        searchProducts.setBounds(460, 390, 160, 25);

        panel.add(jLabelCart);
        panel.add(logOut);
        panel.add(clearFilters);
        panel.add(searchProducts);
        panel.add(searchMinPrice);
        panel.add(searchMaxPrice);
        panel.add(jTextFieldMaxPrice);
        panel.add(jTextFieldMinPrice);
        panel.add(searchMinSodium);
        panel.add(searchMaxSodium);
        panel.add(jTextFieldMaxSodium);
        panel.add(jTextFieldMinSodium);
        panel.add(searchMinProteins);
        panel.add(searchMaxProteins);
        panel.add(jTextFieldMaxProteins);
        panel.add(jTextFieldMinProteins);
        panel.add(searchMinFats);
        panel.add(searchMaxFats);
        panel.add(jTextFieldMaxFats);
        panel.add(jTextFieldMinFats);
        panel.add(searchMinCalories);
        panel.add(searchMaxCalories);
        panel.add(jTextFieldMaxCalories);
        panel.add(jTextFieldMinCalories);
        scrollPane.setViewportView(cart);
        cart.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);
        panel.add(addToCart);
        panel.add(searchProducts);
        panel.add(createOrder);
        panel.add(deleteCart);
        panel.add(searchFilters);
        panel.add(searchByKeyword);
        panel.add(jTextFieldKeyword);
        panel.add(searchMinRating);
        panel.add(searchMaxRating);
        panel.add(jTextFieldMaxRating);
        panel.add(jTextFieldMinRating);
        panel.add(deleteFromCart);

        createTable();

        table.getColumnModel().getColumn(1).setPreferredWidth(5);
        table.getColumnModel().getColumn(2).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(5);
        table.getColumnModel().getColumn(6).setPreferredWidth(5);
        pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(200, 200));
        pane.setBackground(new Color(118, 132, 148));
        pane.setBorder(new LineBorder(Color.BLACK, 3));

        panel.setPreferredSize(new Dimension(400, 300));
        panel.setBackground(new Color(179, 217, 255));
        JPanel mainPanel = new JPanel();
        mainPanel.add(panel);
        panel.setLayout(null);
        mainPanel.add(pane);
        mainPanel.setPreferredSize(new Dimension(700, 400));

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(2000, 700);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);


    }

    void createTable() {
        TableModel tableModel = new TableModel();
        defaultTableModel = new DefaultTableModel(
                new Object[]{"Title", "Calories", "Proteins", "Fats", "Sodium", "Rating", "Price"}, 0
        );
        defaultTableModel = tableModel.createModel(hashMap, defaultTableModel);
        table = new JTable(defaultTableModel);

        table.getColumnModel().getColumn(1).setPreferredWidth(5);
        table.getColumnModel().getColumn(2).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(5);
        table.getColumnModel().getColumn(6).setPreferredWidth(5);


        table.getTableHeader().setBackground(new Color(118, 132, 148));
        table.setBackground(new Color(197, 204, 212));
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.getTableHeader().setFont(new Font("TimesRoman", Font.BOLD, 12));

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.chooseFile();
        ClientView clientView = new ClientView(deliveryService.getHashMap());
    }

}
