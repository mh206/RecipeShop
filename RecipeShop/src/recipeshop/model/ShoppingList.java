package recipeshop.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShoppingList {

    private StringProperty title;
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    public ShoppingList(){
        this(null);
    }
    
    public ShoppingList(String title){
        this.title = new SimpleStringProperty(title);
    }
    
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

}
