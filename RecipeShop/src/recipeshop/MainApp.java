package recipeshop;



import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import recipeshop.model.Recipe;
import recipeshop.model.ShoppingList;
import recipeshop.view.RootLayoutController;
import recipeshop.view.ShoppingOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<ShoppingList> shoppingLists = FXCollections.observableArrayList();

    public MainApp() {

        ShoppingList list1 = new ShoppingList("Test list A");
        list1.addRecipe(new Recipe("Test recipe A"));
        list1.addRecipe(new Recipe("Test recipe B"));
        list1.addRecipe(new Recipe("Test recipe C"));

        shoppingLists.add(list1);

        ShoppingList list2 = new ShoppingList("Test list B");
        list2.addRecipe(new Recipe("Test recipe D"));

        shoppingLists.add(list2);

        ShoppingList list3 = new ShoppingList("Test list C");
        list3.addRecipe(new Recipe("Test recipe E"));

        shoppingLists.add(list3);

    }

    public ObservableList<ShoppingList> getShoppingListsData() {
        return shoppingLists;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RecipeShop");

        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:resources/images/icon.png"));

        initRootLayout();

        showShoppingLists();

    }

    /**
     * Initializes the root layout and tries to load the last opened person
     * file.
     *
     * @throws java.io.IOException
     */
    public void initRootLayout() throws IOException {

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);

        // Give the controller access to the main app.
        RootLayoutController controller = loader.getController();
        controller.setMainApp(this);

        primaryStage.show();

    }

    public void showShoppingLists() throws IOException {

        // Load shopping list overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/ShoppingOverview.fxml"));
        AnchorPane shoppingOverview = (AnchorPane) loader.load();

        // Set shopping list overview into the center of root layout.
        rootLayout.setCenter(shoppingOverview);

        // Give the controller access to the main app.
        ShoppingOverviewController controller = loader.getController();
        controller.setMainApp(this);

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
