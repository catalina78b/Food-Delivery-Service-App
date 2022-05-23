package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Observable;

/**
 * clasa care defineste o comanda si implementeaza Serializable
 */
public class Order implements Serializable {
    private int orderId;
    private int clientId;
    private LocalDateTime localDateTime;
    private ArrayList<MenuItem> products;

    public Order(int orderId, int clientId, LocalDateTime localDateTime, ArrayList<MenuItem> products) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.localDateTime = localDateTime;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ArrayList<MenuItem> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<MenuItem> products) {
        this.products = products;
    }

    public String getOrderDateToString(){
        int year, month, day, hour,min,sec;
        year = localDateTime.getYear();
        month = localDateTime.getMonthValue();
        day = localDateTime.getDayOfMonth();
        hour = localDateTime.getHour();
        min = localDateTime.getMinute();
        sec = localDateTime.getSecond();
        String s = year + "/"+month+"/"+day+ " at " + hour+":"+min+":"+sec;
        return s;
    }

    public LocalDateTime getOrderDate() {
        return localDateTime;
    }
}
