package business;

import data.FileWriter;
import data.Serializator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * clasa care implementeaza interfata Serializable, IDeliveryProcessingService si ii implementeaza metodele, extinde clasa Observable care arata ca un obiect este observabil
 */

public class DeliveryService extends Observable implements Serializable, IDeliveryProcessingService {
    Serializator serializator;
    FileWriter fileWriter;
    List<Observer> observers = new ArrayList<>();
    HashMap<String, MenuItem> hashMap;
    List<User> users = new ArrayList<>();

    /**
     * @return
     */
    protected boolean invariant(){ return hashMap != null; }

    public HashMap<Order, ArrayList<MenuItem>> getOrders() throws IOException, ClassNotFoundException {
        orders = serializator.deserializationOrders();
        return orders;
    }

    HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<>();

    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public DeliveryService() throws IOException, ClassNotFoundException {
        serializator = new Serializator();
        fileWriter = new FileWriter();
        serializator.deserializationUsers(users);
        chooseFile();
    }

    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void chooseFile() throws IOException, ClassNotFoundException {
        String filePath = "MenuItems.bin";
        File file = new File(filePath);

        if (!file.exists()) {
            fileWriter.putInList();
            hashMap = fileWriter.getItemHashMap();
        } else {
            hashMap = serializator.deserialization();
        }
    }

    /**
     * @param baseProduct
     * @throws IOException
     */
    @Override
    public void addProduct(BaseProduct baseProduct) throws IOException {
        assert (baseProduct != null);
        assert (baseProduct.getTitle() != null);
        assert (baseProduct.getCalories() != 0);
        assert (baseProduct.getFats() != 0);
        assert (baseProduct.getProteins() != 0);
        assert (baseProduct.getSodium() != 0);
        assert (baseProduct.getRating() != 0);
        assert (baseProduct.getPrice() != 0);
        hashMap.put(baseProduct.getTitle(), baseProduct);
        System.out.println(baseProduct.getTitle());
        serializator.ser(hashMap);
        assert invariant();


    }

    /**
     * @param baseProduct
     * @throws IOException
     */
    @Override
    public void removeProduct(BaseProduct baseProduct) throws IOException {
        assert (hashMap.get(baseProduct) != null);
        hashMap.remove(baseProduct.getTitle(), baseProduct);
        serializator.ser(hashMap);
        assert (hashMap.get(baseProduct) == null);
        assert invariant();
    }

    /**
     * @param baseProduct
     * @param newTitle
     * @param newPrice
     * @param newCalories
     * @param newProteins
     * @param newSodium
     * @param newFats
     * @param newRating
     * @throws IOException
     */
    @Override
    public void modifyProduct(BaseProduct baseProduct, String newTitle, float newPrice, float newCalories, float newProteins, float newSodium, float newFats, float newRating) throws IOException {

        assert (baseProduct != null);
        baseProduct.setTitle(newTitle);
        baseProduct.setPrice(newPrice);
        baseProduct.setCalories(newCalories);
        baseProduct.setProteins(newProteins);
        baseProduct.setSodium(newSodium);
        baseProduct.setFats(newFats);
        baseProduct.setRating(newRating);
        serializator.ser(hashMap);
        assert invariant();
    }


    /**
     * @param titles
     * @param newTitle
     * @param newRating
     * @throws IOException
     */
    @Override
    public void addCompositeProduct(List<String> titles, String newTitle, float newRating) throws IOException {
        assert (titles != null);
        assert (newTitle!=null);
        assert (newRating!=0);
        List<MenuItem> menuItems = new ArrayList<>();
        for (String title : titles) menuItems.add(hashMap.get(title));

        CompositeProduct compositeProduct = new CompositeProduct(menuItems, newTitle, newRating);
        hashMap.put(compositeProduct.getTitle(), compositeProduct);
        System.out.println(compositeProduct.getTitle());
        serializator.ser(hashMap);
        assert invariant();
    }

    /**
     * @param keyword
     * @param minPrice
     * @param maxPrice
     * @param minRating
     * @param maxRating
     * @param minCalories
     * @param maxCalories
     * @param minFat
     * @param maxFat
     * @param minSodium
     * @param maxSodium
     * @param minProtein
     * @param maxProtein
     * @return
     */
    @Override
    public HashMap<String, MenuItem> filterProducts(String keyword, float minPrice, float maxPrice, float minRating, float maxRating, float minCalories, float maxCalories, float minFat, float maxFat, float minSodium, float maxSodium, float minProtein, float maxProtein) {

        assert (keyword != null);
        assert (minPrice<=maxPrice && minPrice>0 && maxPrice>0);
        assert (minCalories<=maxPrice && minCalories>0 && maxCalories>0);
        assert (minFat<=maxFat && minFat>0 && maxFat>0);
        assert (minProtein<=maxProtein && minProtein>0 && maxProtein>0);
        assert (minSodium<=maxSodium && minSodium>0 && maxSodium>0);
        assert (minRating<=maxRating && minRating>0 && maxRating>0);
        Map<String, MenuItem> result = null;
        try {
            result = hashMap.entrySet()
                    .stream()
                    .filter(map -> map.getValue().getTitle().toLowerCase().contains(keyword.toLowerCase()) &&
                            map.getValue().getPrice() >= minPrice && map.getValue().getPrice() <= maxPrice &&
                            map.getValue().getRating() >= minRating && map.getValue().getRating() <= maxRating &&
                            map.getValue().getProteins() >= minProtein && map.getValue().getProteins() <= maxProtein &&
                            map.getValue().getSodium() >= minSodium && map.getValue().getSodium() <= maxSodium &&
                            map.getValue().getCalories() >= minCalories && map.getValue().getCalories() <= maxCalories &&
                            map.getValue().getFats() >= minFat && map.getValue().getFats() <= maxFat
                    )
                    .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
        }

        assert invariant();
        return new HashMap<>(Objects.requireNonNull(result));
    }

    /**
     * @param order
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void createOrder(Order order) throws IOException, ClassNotFoundException {
        assert (order != null);
        assert (order.getOrderId() != 0);
        assert (order.getClientId() != 0);
        orders.put(order, order.getProducts());
        serializator.serOrders(orders);
        Bill bill = new Bill(order);
        bill.generateBill();

        setChanged();
        notifyObservers(order);
        clearChanged();
    }

    /**
     * @param startHour
     * @param endHour
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void reportOne(int startHour, int endHour) throws IOException, ClassNotFoundException {
        assert(startHour>=0 && endHour>=0);
        orders = getOrders();
        List<Order> ord = orders.keySet().stream().filter(o -> o.getOrderDate().getHour() >= startHour && o.getOrderDate().getHour() <= endHour).collect(Collectors.toList());
        for (Order o : ord) {
            System.out.println(o.getOrderId());
        }
        File f = new File("Report1.txt");
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(f, false);
            fileWriter.write("Report 1: time interval of the orders:[" + startHour + "," + endHour + "]" + "\n\n");
            for (Order o : ord) {

                fileWriter.write("OrderID: " + o.getOrderId() + "\n");
                fileWriter.write("ClientID: " + o.getClientId() + "\n");
                fileWriter.write("Products: ");
                for (int i = 0; i < o.getProducts().size(); i++) {
                    fileWriter.write(o.getProducts().get(i).getTitle() + ", ");
                }
                fileWriter.write("Date: " + o.getOrderDate() + "\n\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param times
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void reportTwo(int times) throws IOException, ClassNotFoundException {
        chooseFile();
        HashMap<String, Integer> products = new HashMap<String, Integer>();
        for (MenuItem m : hashMap.values()) {
            products.put(m.getTitle(), 0);
            System.out.println(m.getTitle());
        }
        orders.entrySet().stream().forEach(o -> {
            ArrayList<MenuItem> items = o.getValue();
            for (MenuItem m : items) {
                int currentCount = products.get(m.getTitle());
                products.put(m.getTitle(), currentCount + 1);
            }
        });
        List<String> list = products.entrySet().stream().filter(p -> p.getValue() > times).map(c -> c.getKey()).collect(Collectors.toList());
        File f = new File("Report2.txt");
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(f, false);
            fileWriter.write("Report 2: the products ordered more than " + times + " times\n\n");
            fileWriter.write("Products: ");
            for (String m : list) {
                fileWriter.write(m + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param minNumber
     * @param minValue
     */
    public void reportThree(int minNumber, int minValue) {
        HashMap<Integer, Integer> clientOrderCount = new HashMap<>();
        for (Order order : orders.keySet()) {
            clientOrderCount.put(order.getClientId(), 0);
        }
        orders.keySet().stream().forEach(o -> {
            int sum = 0;
            for (MenuItem i : orders.get(o)) {
                sum += i.getPrice();
            }
            if (sum > minValue) {
                clientOrderCount.put(o.getClientId(), clientOrderCount.get(o.getClientId()) + 1);
            }
        });

        List<Integer> clientsIDs = clientOrderCount.entrySet().stream().filter(o -> o.getValue() > minNumber).map(o -> o.getKey()).collect(Collectors.toList());
        File f = new File("Report3.txt");
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(f, false);
            fileWriter.write("Report 3: the clients that have ordered more than " + minNumber + " times so far and the value of the order was higher than " + minValue + "\n\n");
            fileWriter.write("Clients: ");

            for (Integer id : clientsIDs) {
                for (User user : users
                ) {
                    if (user.getId() == id) {
                        fileWriter.write("Id: " + user.getId() + "\n");
                        fileWriter.write("Name: " + user.getFirstName() + " " + user.getLastName() + "\n\n");
                    }
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param year
     * @param month
     * @param day
     */
    public void reportFour(int year, int month, int day) {
        assert(year>0 && month>0 && day>0);
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Order order : orders.keySet()) {
            for (MenuItem m : order.getProducts()) {
                hashMap.put(m.getTitle(), 0);
            }
        }


        orders.entrySet().stream().filter(o -> o.getKey().getOrderDate().getDayOfMonth() == day && o.getKey().getOrderDate().getMonthValue() == month && o.getKey().getOrderDate().getYear() == year).forEach(o -> {
            ArrayList<MenuItem> items = o.getValue();
            for (MenuItem m : items) {
                int currentCount = hashMap.get(m.getTitle());
                hashMap.put(m.getTitle(), currentCount + 1);
            }
        });
        File f = new File("Report4.txt");
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(f, false);
            fileWriter.write("Report 4: the products ordered in " + year + "-" + month + "-" + day + " with the number of times they have been ordered.\n\n");
            for (Map.Entry<String, Integer> id : hashMap.entrySet()) {
                if (id.getValue() > 0) {
                    fileWriter.write("Product: " + id.getKey() + "\n");
                    fileWriter.write("Number: " + id.getValue() + "\n\n");
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public HashMap<String, MenuItem> getHashMap() {
        return hashMap;
    }

}
