package business;

import java.io.Serializable;

/**
 * clasa abstracta care implementeaza interfata Serializable
 */
public abstract class MenuItem implements Serializable {
    public String title;
    public float rating, calories, proteins, fats, sodium, price;

    public MenuItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public abstract float getCalories();

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public abstract float getProteins();

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public abstract float getFats();

    public void setFats(float fats) {
        this.fats = fats;
    }

    public abstract float getSodium();

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public abstract float getPrice();

    public void setPrice(float price) {
        this.price = price;
    }

}
