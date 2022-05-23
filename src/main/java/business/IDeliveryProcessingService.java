package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * interfata cu metodele abstracte care definesc diferite functionalitati care sunt implementate in clasa DeliveryService
 */
public interface IDeliveryProcessingService {
    void addCompositeProduct(List<String> titles, String newTitle, float newRating) throws IOException;

    void addProduct(BaseProduct baseProduct) throws IOException;

    void removeProduct(BaseProduct baseProduct) throws IOException;

    void modifyProduct(BaseProduct baseProduct, String newTitle, float newPrice, float newCalories, float newProteins, float newSodium, float newFats, float newRating) throws IOException;

    HashMap<String, MenuItem> filterProducts(String title, float minPrice, float maxPrice, float minRating, float maxRating, float minCalories, float maxCalories, float minFat, float maxFat, float minSodium, float maxSodium, float minProtein, float maxProtein);

    void createOrder(Order order) throws IOException, ClassNotFoundException;

    void reportOne(int startHour, int endHour) throws IOException, ClassNotFoundException;

    void reportTwo(int times) throws IOException, ClassNotFoundException;

    void reportThree(int minNumber, int minValue);

    void reportFour(int year, int month, int day);
}
