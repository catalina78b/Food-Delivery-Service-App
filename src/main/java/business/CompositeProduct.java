package business;

import java.util.List;

/**
 * clasa care mosteneste atributele clasei MenuItem dar mai are si o lista de MenuItems si suprascrie titlul si rating-ul
 */
public class CompositeProduct extends MenuItem{
    List<MenuItem> compositeProd;

    public CompositeProduct(List<MenuItem> compositeProd, String title, float rating) {

        this.compositeProd= compositeProd;
        this.title=title;
        this.rating=rating;

    }
    /**
     * metode suprascrise
     */
    @Override
    public float getCalories() {
        float finalCalories=0;
        for (MenuItem product:compositeProd
        ) {
            finalCalories+=product.getCalories();

        }
        return finalCalories;
    }

    @Override
    public float getProteins() {
        float finalProteins=0;
        for (MenuItem product:compositeProd
        ) {
            finalProteins+=product.getProteins();

        }
        return finalProteins;
    }

    @Override
    public float getFats() {
        float finalFats=0;
        for (MenuItem product:compositeProd
        ) {
            finalFats+=product.getFats();

        }
        return finalFats;
    }

    @Override
    public float getSodium() {
        float finalSodium=0;
        for (MenuItem product:compositeProd
        ) {
            finalSodium+=product.getSodium();

        }
        return finalSodium;
    }

    @Override
    public float getPrice() {
        float finalPrice=0;
        for (MenuItem product:compositeProd
        ) {
            finalPrice+=product.getPrice();

        }
        return finalPrice;
    }
}
