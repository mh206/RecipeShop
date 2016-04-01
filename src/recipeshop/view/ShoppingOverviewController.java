package recipeshop.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import recipeshop.MainApp;
import recipeshop.model.Recipe;
import recipeshop.model.ShoppingList;

public class ShoppingOverviewController {

    private ObservableList<Recipe> recipeList = FXCollections.observableArrayList();
    
    @FXML
    private TableView<ShoppingList> shoppingTable;
    @FXML
    private TableColumn<ShoppingList, String> shoppingTitleColumn;
    @FXML
    private TableView<Recipe> recipeTable;
    @FXML
    private TableColumn<Recipe, String> recipeTitleColumn;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        // Initialize the shopping list table
        shoppingTitleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

        // Clear shopping list details
        showShoppingDetails(null);

        // Listen for selection changes and show the shopping list details when changed
        shoppingTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showShoppingDetails(newValue));

        // Initialize the recipe list table
        recipeTitleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;

        // Add observable list data to the table
        shoppingTable.setItems(mainApp.getShoppingListsData());
        
        // Add observable list data to the table
        recipeTable.setItems(recipeList);

    }

    /**
     * Fills all text fields to show details about the person. If the specified
     * person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showShoppingDetails(ShoppingList shoppingList) {

        recipeList.clear();
        
        if (shoppingList != null) {

            recipeList.addAll(shoppingList.getRecipes());
                    
        }

    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteShoppingList() {

        int selectedIndex = shoppingTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {

            shoppingTable.getItems().remove(selectedIndex);

        } else {

            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Shopping List Selected");
            alert.setContentText("Please select a shopping list in the table.");

            alert.showAndWait();

        }

    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new shopping list.
     */
    @FXML
    private void handleNewShoppingList() {

        ShoppingList tempShoppingList = new ShoppingList();

//        if (mainApp.showPersonEditDialog(tempShoppingList)) {
//            mainApp.getShoppingListsData().add(tempShoppingList);
//        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected shopping list.
     */
    @FXML
    private void handleEditShoppingList() {

        ShoppingList selectedShoppingList = shoppingTable.getSelectionModel().getSelectedItem();

        if (selectedShoppingList != null) {

//        if (mainApp.showPersonEditDialog(tempShoppingList)) {
//            mainApp.getShoppingListsData().add(tempShoppingList);
//        }
        } else {

            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Shopping List Selected");
            alert.setContentText("Please select a shopping list in the table.");

            alert.showAndWait();

        }

    }
}
