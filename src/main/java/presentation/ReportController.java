package presentation;

import business.DeliveryService;
import business.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * clasa care defineste controller-ul pentru report
 */


public class ReportController {
    public ReportView reportView;
    public DeliveryService deliveryService;
    public ReportController() throws IOException, ClassNotFoundException {
        this.reportView = new ReportView();
        deliveryService = new DeliveryService();

        reportView.generateReport1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startHour = Integer.parseInt(reportView.startTimeText.getText());
                int endHour = Integer.parseInt(reportView.endTimeText.getText());

                try {
                    deliveryService.reportOne(startHour,endHour);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                System.out.println("BUTON APASAT");
            }
        });

        reportView.generateReport2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int times = Integer.parseInt(reportView.ordersText.getText());
                try {
                    deliveryService.chooseFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                try {
                    deliveryService.reportTwo(times);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        reportView.generateReport3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int minNumber = Integer.parseInt(reportView.minOrdersText.getText());
                int minValue = Integer.parseInt(reportView.minValueText.getText());

                deliveryService.reportThree(minNumber,minValue);
            }
        });

        reportView.generateReport4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt(reportView.years.getSelectedItem().toString());
                int mo = Integer.parseInt(reportView.months.getSelectedItem().toString());
                int day = Integer.parseInt(reportView.days.getSelectedItem().toString());

                deliveryService.reportFour(year,mo,day);
            }
        });
    }
}
