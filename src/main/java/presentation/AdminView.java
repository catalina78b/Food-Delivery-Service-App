package presentation;

import business.MenuItem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

/**
 * clasa care defineste interfata pentru Admin
 */
public class AdminView {
    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    HashMap<String,MenuItem> hashMap;
    private final JFrame frame = new JFrame("Admin Page");
    private final JPanel panel = new JPanel();
    private final JButton addProduct = new JButton("Add product");
    private final JButton editProduct = new JButton("Edit product");
    private final JButton deleteProduct = new JButton("Delete product");
    private final JButton generateRaport = new JButton("Generate Reports");
    private final JButton createCompositeProduct = new JButton("Create Composite Product");
    private final JButton addButton = new JButton("Add Simple Product");


    public JScrollPane pane;
    public DefaultTableModel defaultTableModel;
    private final JTextField jTextFieldTitle = new JTextField();
    private final JTextField jTextFieldRating = new JTextField();
    private final JTextField jTextFieldCalories = new JTextField();
    private final JTextField jTextFieldProteins = new JTextField();

    private final JTextField jTextFieldTitleComp = new JTextField();

    private final JTextField jTextFieldRatingComp = new JTextField();

    public JTable getTable() {
        return table;
    }

    private final JTextField jTextFieldFats = new JTextField();
    private final JTextField jTextFieldSodium = new JTextField();
    private final JTextField jTextFieldPrice = new JTextField();
    private final JTable table;

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    private final JButton jButtonBack=new JButton("LogOut");
    LineBorder border=new LineBorder(new Color(142, 165, 191));

    public JTextField getjTextFieldTitleComp() {
        return jTextFieldTitleComp;
    }

    public JTextField getjTextFieldRatingComp() {
        return jTextFieldRatingComp;
    }

    AdminView(HashMap<String,MenuItem> hashMap) {

        this.hashMap=hashMap;
        addProduct.setBounds(120, 50, 200, 25);
        editProduct.setBounds(120, 75, 200, 25);
        deleteProduct.setBounds(120, 100, 200, 25);
        generateRaport.setBounds(120, 125, 200, 25);
        createCompositeProduct.setBounds(120, 150, 200, 25);
        addButton.setBounds(120, 175, 200, 25);

        JLabel jLabelComp = new JLabel("Composite product details:");
        jLabelComp.setBounds(60, 225, 170, 25);
        JLabel jLabelTitleComp = new JLabel("Title:");
        jLabelTitleComp.setBounds(60, 250, 200, 25);
        jTextFieldTitleComp.setBounds(120, 250, 200, 25);

        JLabel jLabelRatingComp = new JLabel("Rating:");
        jLabelRatingComp.setBounds(60, 275, 200, 25);
        jTextFieldRatingComp.setBounds(120, 275, 200, 25);

        JLabel jLabelTitle = new JLabel("Title:");
        jLabelTitle.setBounds(60, 325, 200, 25);
        jTextFieldTitle.setBounds(120, 325, 200, 25);
        JLabel jLabelCalories = new JLabel("Calories:");
        jLabelCalories.setBounds(60, 350, 200, 25);
        jTextFieldCalories.setBounds(120, 350, 200, 25);
        JLabel jLabelProteins = new JLabel("Proteins:");
        jLabelProteins.setBounds(60, 375, 200, 25);
        jTextFieldProteins.setBounds(120, 375, 200, 25);
        JLabel jLabelFats = new JLabel("Fats:");
        jLabelFats.setBounds(60, 400, 200, 30);
        jTextFieldFats.setBounds(120, 400, 200, 25);

        JLabel jLabelSodium = new JLabel("Sodium:");
        jLabelSodium.setBounds(60, 425, 200, 25);
        jTextFieldSodium.setBounds(120, 425, 200, 25);
        JLabel jLabelRating = new JLabel("Rating:");
        jLabelRating.setBounds(60, 450, 200, 25);
        jTextFieldRating.setBounds(120, 450, 200, 25);
        JLabel jLabelPrice = new JLabel("Price:");
        jLabelPrice.setBounds(60, 475, 200, 25);
        jTextFieldPrice.setBounds(120, 475, 200, 25);

        jTextFieldTitle.setBorder(border);
        jTextFieldRating.setBorder(border);
        jTextFieldSodium.setBorder(border);
        jTextFieldProteins.setBorder(border);
        jTextFieldFats.setBorder(border);
        jTextFieldCalories.setBorder(border);
        jTextFieldPrice.setBorder(border);
        jTextFieldRatingComp.setBorder(border);
        jTextFieldTitleComp.setBorder(border);
        jLabelComp.setBorder(new LineBorder(Color.BLACK,2));

        jButtonBack.setBounds(145, 550, 150, 25);
        jButtonBack.setBorder(border);

        TableModel tableModel=new TableModel();
        defaultTableModel = new DefaultTableModel(
                new Object[]{"Title", "Calories", "Proteins", "Fats", "Sodium", "Rating", "Price"}, 0
        );
        defaultTableModel=tableModel.createModel(hashMap,defaultTableModel);
        table = new JTable(defaultTableModel);

        table.setSize(new Dimension(300, 300));

        table.getTableHeader().setBackground(new Color(118, 132, 148));
        table.setBackground(new Color(197, 204, 212));
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.getTableHeader().setFont(new Font("TimesRoman", Font.BOLD, 12));
        pane = new JScrollPane(table);
        pane.setBackground(new Color(118, 132, 148));
        pane.setBorder(new LineBorder(Color.BLACK, 3));
        table.setSelectionModel(new ForcedListSelectionModel());

        panel.add(jLabelComp);
        panel.add(jLabelTitleComp);
        panel.add(jTextFieldTitleComp);
        panel.add(jLabelRatingComp);
        panel.add(jTextFieldRatingComp);
        panel.add(jButtonBack);
        panel.add(jLabelCalories);
        panel.add(jLabelFats);
        panel.add(jLabelSodium);
        panel.add(jLabelProteins);
        panel.add(jLabelPrice);
        panel.add(jLabelRating);
        panel.add(jTextFieldCalories);
        panel.add(jTextFieldProteins);
        panel.add(jTextFieldPrice);
        panel.add(jTextFieldSodium);
        panel.add(jTextFieldFats);
        panel.add(jTextFieldRating);
        panel.add(jLabelTitle);
        panel.add(jTextFieldTitle);
        panel.add(addProduct);
        panel.add(editProduct);
        panel.add(deleteProduct);
        panel.add(generateRaport);
        panel.add(createCompositeProduct);
        panel.add(addButton);

        panel.setBackground(new Color(142, 165, 191));


        JPanel mainPanel = new JPanel();
        mainPanel.add(panel);
        panel.setLayout(null);
        mainPanel.add(pane);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 700);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public static class ForcedListSelectionModel extends DefaultListSelectionModel {

        public ForcedListSelectionModel () {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }

        @Override
        public void clearSelection() {
        }

        @Override
        public void removeSelectionInterval(int index0, int index1) {
        }

    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getjTextFieldTitle() {
        return jTextFieldTitle;
    }

    public JTextField getjTextFieldRating() {
        return jTextFieldRating;
    }

    public JTextField getjTextFieldCalories() {
        return jTextFieldCalories;
    }

    public JTextField getjTextFieldProteins() {
        return jTextFieldProteins;
    }

    public JTextField getjTextFieldFats() {
        return jTextFieldFats;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getAddProduct() {
        return addProduct;
    }

    public JButton getEditProduct() {
        return editProduct;
    }

    public JButton getDeleteProduct() {
        return deleteProduct;
    }

    public JButton getGenerateRaport() {
        return generateRaport;
    }
    public JButton getCreateCompositeProduct() {
        return createCompositeProduct;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getjTextFieldSodium() {
        return jTextFieldSodium;
    }

    public JTextField getjTextFieldPrice() {
        return jTextFieldPrice;
    }

}
