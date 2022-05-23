package business;

import data.Serializator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * clasa pentru a defini o chitanta pentru o comanda data
 */
public class Bill {
    Serializator serializator = new Serializator();
    List<User> users=new ArrayList<>();
    User user;
    Order order;
    ArrayList<MenuItem> baseProduct;
    float totalPrice=0;


    public Bill(Order order) throws IOException, ClassNotFoundException {
        this.order = order;
        serializator.deserializationUsers(users);
        baseProduct = order.getProducts();
    }

    /**
     * metoda pentru generarea chitantei
     */

    public void generateBill() {
        for (User user2:users
             ) {
            if(user2.getId()== order.getClientId())
            {
                user=user2;
                break;
            }


        }
        System.out.println(user.getName()+user.getId()+order.getClientId());
        System.out.println(user.getFirstName());
        try {
            FileWriter myWriter = new FileWriter("Bill" + order.getOrderId() + ".txt",false);
            myWriter.write("Order nb." + order.getOrderId()+"\n\n");
            myWriter.write("First Name: " + user.getFirstName()+"\n");
            myWriter.write("Last Name: " + user.getLastName()+"\n");
            myWriter.write("Address: " + user.getAddress()+"\n");
            myWriter.write("Email: " + user.getEmail() + "\n");
            myWriter.write("Phone number: " + user.getPhoneNumber() + "\n\n");
            myWriter.write("Products: "+"\n");
            for(MenuItem b: baseProduct) {
                myWriter.write(b.getTitle() + "   Price: " + b.getPrice() + "\n");
                totalPrice = totalPrice + b.getPrice();
            }
            myWriter.write("Total price: "+ totalPrice +"\n");
            myWriter.write("Date: " + order.getLocalDateTime());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

