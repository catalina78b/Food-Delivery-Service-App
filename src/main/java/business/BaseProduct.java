package business;

import java.io.Serializable;

/**
 * clasa BaseProduct care mosteneste proprietatile clasei MenuItem si ii suprascrie metodele
 */
public class BaseProduct extends MenuItem {

    public BaseProduct(String title, float rating, float calories, float proteins, float fats, float sodium, float price) {
        this.title = title;
        this.calories = calories;
        this.rating = rating;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }
    /**
     * metode suprascrise
     */

    @Override
    public float getCalories() {
        return this.calories;
    }

    @Override
    public float getProteins() {
        return this.proteins;
    }

    @Override
    public float getFats() {
        return this.fats;
    }

    @Override
    public float getSodium() {
        return this.sodium;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

}
