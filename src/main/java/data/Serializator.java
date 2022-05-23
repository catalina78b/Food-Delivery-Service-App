package data;

import business.MenuItem;
import business.Order;
import business.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * clasa care serializeaza si deserializeaza produse,clienti si comenzi
 */
public class Serializator{


    public Serializator() throws IOException {
    }
    /**
     * metoda pentru serializarea clientilor
     */
    public void serUsers(List<User> list) throws IOException {
        FileOutputStream file = new FileOutputStream("Users.bin");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(list);
        out.flush();
        out.close();
        file.close();
    }
    /**
     * metoda pentru deserializarea clientilor
     */
    public void deserializationUsers(List<User> list) throws IOException, ClassNotFoundException {
        FileInputStream file;
        try{
            file = new FileInputStream("Users.bin");}
        catch(FileNotFoundException fileNotFoundException)
        {
            return;
        }
        ObjectInputStream in = new ObjectInputStream(file);
        list.addAll((ArrayList<User>) in.readObject());
        in.close();
        file.close();
    }
    /**
     * metoda pentru serializarea produselor
     */
    public void ser(HashMap<String,MenuItem> hashmap) throws IOException {
        FileOutputStream file = new FileOutputStream("MenuItems.bin");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(hashmap);
        out.close();
        file.close();


    }
    /**
     * metoda pentru deserializarea produselor
     */
    public HashMap<String,MenuItem> deserialization() throws IOException, ClassNotFoundException {
        HashMap<String,MenuItem> hashmap;
        FileInputStream file = new FileInputStream("MenuItems.bin");
        ObjectInputStream in = new ObjectInputStream(file);
        hashmap = (HashMap<String,MenuItem>) in.readObject();
        in.close();
        file.close();
        return hashmap;
    }
    /**
     * metoda pentru serializarea comenzilor
     */

    public void serOrders(HashMap<Order,ArrayList<MenuItem>> hashMap) throws IOException {
        FileOutputStream file = new FileOutputStream("Orders.bin");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(hashMap);
        out.close();
        file.close();


    }
    /**
     * metoda pentru deserializarea comenzilor
     */
    public HashMap<Order, ArrayList<MenuItem>> deserializationOrders() throws IOException, ClassNotFoundException {
        HashMap<Order, ArrayList<MenuItem>> hashMap;
        FileInputStream file = new FileInputStream("Orders.bin");
        ObjectInputStream in = new ObjectInputStream(file);
        hashMap = (HashMap<Order, ArrayList<MenuItem>>) in.readObject();
        in.close();
        file.close();
        return hashMap;
    }
}
