package com.marcel.controller;

import com.marcel.Main;
import com.marcel.entity.Category;
import com.marcel.entity.Item;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtKode;
    @FXML
    private TableView tableDepartment;
    @FXML
    private TableColumn col01;
    @FXML
    private TableColumn col02;

    private MainFormController mainFormController;

    @FXML
    private void tambahAction(ActionEvent actionEvent) {
    }

    @FXML
    private void tableClick(MouseEvent mouseEvent) {
    }

    @FXML
    private void ShowCategoryManagement(ActionEvent actionEvent) {

        try {
            //Parent root = FXMLLoader.load(com.marcel.Main.class.getResource("view/facultyForm.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/CategoryManagement.fxml"));
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

    private void setMainFormController(CategoryController categoryController) {
        this.mainFormController = mainFormController;
        tableDepartment.setItems(mainFormController.getItems());
        tableDepartment.setItems(mainFormController.getCategories());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        col01.setCellValueFactory(data -> {
            Category C = data.getValue();
            return new SimpleIntegerProperty(C.getId());
        });
        col02.setCellValueFactory(data -> {
            Category C = data.getValue();
            return new SimpleStringProperty(C.getName());
        });
    }

    public void setMainFormController(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
        tableDepartment.setItems(mainFormController.getItems());
        tableDepartment.setItems(mainFormController.getCategories());
    }
}
