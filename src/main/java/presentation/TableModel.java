package presentation;

import business.MenuItem;

import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
/**
 * clasa care defineste un TableModel
 */

public class TableModel {
    public TableModel()
    {}
    public DefaultTableModel createModel(HashMap<String, MenuItem> map,DefaultTableModel model) {

        for (HashMap.Entry<String, MenuItem> entry : map.entrySet()) {
            model.addRow(new Object[]{entry.getKey(), entry.getValue().getCalories(),
                    entry.getValue().getProteins(), entry.getValue().getFats(), entry.getValue().getSodium(),
                    entry.getValue().getRating(), entry.getValue().getPrice()});
        }
        return model;
    }
}
