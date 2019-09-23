package com.marcel.controller;

import com.marcel.Main;
import com.marcel.entity.Category;
import com.marcel.entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainFormController implements Initializable {
    @FXML
    private void closeonaction(ActionEvent actionEvent) {
    }

    @FXML
    private void aboutonaction(ActionEvent actionEvent) {
    }

    private ObservableList<Category> categories;
    private ObservableList<Item> items;

    public ObservableList<Category> getCategories() {
        if (categories == null){
            categories= FXCollections.observableArrayList();
        }
        return categories;
    }

    public ObservableList<Item> getItems() {
        if (items == null) {
            items = FXCollections.observableArrayList();
        }
        return items;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void ShowCategory(ActionEvent actionEvent) {
        try {
            //Parent root = FXMLLoader.load(com.marcel.Main.class.getResource("view/facultyForm.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Category.fxml"));
            VBox root = loader.load();
            CategoryController controller = loader.getController();
            controller.setMainFormController(this);

            Stage mainStage = new Stage();
            mainStage.setTitle("com.marcel.Main form");
            mainStage.setScene(new Scene(root));
            mainStage.show();
            //((Stage) Root.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
