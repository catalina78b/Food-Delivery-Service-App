package presentation;

import javax.swing.*;
import java.awt.*;
/**
 * clasa care defineste interfata pentru rapoarte
 */

public class ReportView {
    public JFrame frame= new JFrame("Reports");
    public JPanel panel=new JPanel();
    public JButton generateReport1,generateReport2,generateReport3,generateReport4;
    public JLabel startHour,endHour, nbProducts,nbTimes,minOrders,minValue,dateOfOrder,title;
    public JComboBox<String> years,days,months;
    public JTextField startTimeText, endTimeText, ordersText, minOrdersText, minValueText;

    public ReportView() {

        title=new JLabel("Reports:");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        generateReport1=new JButton("Generate Report One");
        generateReport2=new JButton("Generate Report Two");
        generateReport3=new JButton("Generate Report Three");
        generateReport4=new JButton("Generate Report Four");
        startHour=new JLabel("Start hour:");
        endHour=new JLabel("End hour:");
        nbProducts =new JLabel("Products ordered more than");
        nbTimes =new JLabel("times");
        minOrders=new JLabel("Min number of orders:");
        minValue=new JLabel("Min value of order:");
        dateOfOrder=new JLabel("Date of Order:");
        startTimeText=new JTextField();
        endTimeText=new JTextField();
        ordersText=new JTextField();
        minOrdersText=new JTextField();
        minValueText=new JTextField();
        String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12",
                "13","14","15","16","17","18","19","20","21","22",
                "23","24","25","26","27","28","29","30","31"};
        String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] year = {"2018","2019","2020","2021","2022"};
        years = new JComboBox<>(year);
        months=new JComboBox<>(month);
        days=new JComboBox<>(day);

        title.setBounds(200,20,200,25);
        startHour.setBounds(20,60,200,25);
        startTimeText.setBounds(100,60,100,25);
        endHour.setBounds(220,60,200,25);
        endTimeText.setBounds(300,60,100,25);

        generateReport1.setBounds(130,100,200,25);
        generateReport1.setForeground(new Color(118, 132, 148));

        nbProducts.setBounds(20,150,300,25);
        ordersText.setBounds(195,150,50,25);
        nbTimes.setBounds(255,150,100,25);

        generateReport2.setBounds(130,200,200,25);
        generateReport2.setForeground(new Color(118, 132, 148));

        minOrders.setBounds(20,250,200,25);
        minOrdersText.setBounds(160,250,80,25);

        minValue.setBounds(250,250,200,25);
        minValueText.setBounds(370,250,80,25);

        generateReport3.setBounds(130,300,200,25);
        generateReport3.setForeground(new Color(118, 132, 148));

        dateOfOrder.setBounds(20,340,100,25);
        days.setBounds(130,340,50,25);
        months.setBounds(230,340,50,25);
        years.setBounds(330,340,60,25);

        generateReport4.setBounds(130,380,200,25);
        generateReport4.setForeground(new Color(118, 132, 148));



        panel.add(nbTimes);
        panel.add(title);
        panel.add(generateReport1);
        panel.add(generateReport2);
        panel.add(generateReport3);
        panel.add(generateReport4);
        panel.add(startHour);
        panel.add(endHour);
        panel.add(endTimeText);
        panel.add(startTimeText);
        panel.add(nbProducts);
        panel.add(minValue);
        panel.add(minOrders);
        panel.add(minOrdersText);
        panel.add(minValueText);
        panel.add(ordersText);
        panel.add(years);
        panel.add(days);
        panel.add(months);
        panel.add(dateOfOrder);

        panel.setLayout(null);
        panel.setBackground(new Color(179, 217, 255));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ReportView reportView = new ReportView();
    }
}

