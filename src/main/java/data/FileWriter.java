package data;

import business.BaseProduct;
import business.MenuItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Float.parseFloat;

/**
 * clasa pentru citirea produselor din csv file
 */
public class FileWriter {
    List<MenuItem> products = new ArrayList<>();
    HashMap<String, MenuItem> itemHashMap = new HashMap<>();
    String line;
    String[] data;
    String splitter = ",";
    /**
     * metoda pentru crearea unei liste de produse
     */

    public void putInList() throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("products.csv"));
        line = buff.readLine();
        while ((line = buff.readLine()) != null) {
            int ok = 0;
            data = line.split(splitter);
            MenuItem menuItem = new BaseProduct(data[0], parseFloat(data[1]), parseFloat(data[2]), parseFloat(data[3]), parseFloat(data[4]), parseFloat(data[5]), parseFloat(data[6]));
            for (MenuItem menuItem1 : products)
                if (menuItem1.getTitle().equals(menuItem.getTitle())) {
                    ok = 1;
                    break;
                }

            if (ok != 1) {
                products.add(menuItem);
            }
        }
    }

    public List<MenuItem> getProducts() {
        return products;
    }

    /**
     * metoda pentru crearea unui hashmap de produse
     */
    public HashMap<String, MenuItem> getItemHashMap() {
        for (MenuItem menuItem : products
        ) {
            itemHashMap.put(menuItem.getTitle(), menuItem);
            //System.out.println(menuItem.getTitle());

        }

        return itemHashMap;

    }

}
