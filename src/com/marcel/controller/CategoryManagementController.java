package com.marcel.controller;

import com.marcel.entity.Category;
import com.marcel.entity.Item;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CategoryManagementController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtKode;
    @FXML
    private ComboBox combofakultas;
    @FXML
    private TableView tableDepartment;
    @FXML
    private TableColumn col01;
    @FXML
    private TableColumn col02;
    @FXML
    private TableColumn col03;
    private MainFormController mainFormController;

    public void setMainFormController(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
        tableDepartment.setItems(mainFormController.getCategories());
        combofakultas.setItems(mainFormController.getCategories());

    }

    @FXML
    private void tambahAction(ActionEvent actionEvent) {
        Item I= new Item();
        I.setName(txtName.getText().trim());
        I.setId(txtKode.getText().trim());

    }

    @FXML
    private void tableClick(MouseEvent mouseEvent) {
        Item I= (Item) tableDepartment.getSelectionModel().getSelectedItem();
        txtName.setText(I.getName());
        txtKode.setText(I.getId());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        col01.setCellValueFactory(data -> {
            Item I = data.getValue();
            return new SimpleStringProperty(I.getName());
        });
        col02.setCellValueFactory(data -> {
            Item I = data.getValue();
            return new SimpleIntegerProperty(I.getId());
        });
        col03.setCellValueFactory(data -> {
            Item I = data.getValue();
            return new SimpleObjectProperty<Date>(I.getExpiredDate());
    })}
}
