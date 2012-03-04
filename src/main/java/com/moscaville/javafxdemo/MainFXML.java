/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.javafxdemo;

import com.moscaville.javafxdemo.model.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author moscac
 */
public class MainFXML implements Initializable {

    private final ObservableList<Person> users = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com"));
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfEmail;

    @FXML
    private void btnAddAction(ActionEvent event) {
        if (tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty()
                || tfEmail.getText().isEmpty()) {
            MessageDialog.show("All fields are required");
        } else {
            users.add(new Person(
                    tfFirstName.getText(),
                    tfLastName.getText(),
                    tfEmail.getText()));
            tfFirstName.setText("");
            tfLastName.setText("");
            tfEmail.setText("");
        }
    }
    @FXML
    private TableView<Person> userstable;
    @FXML
    private TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
    @FXML
    private TableColumn colFirstName;
    @FXML
    private TableColumn colLastName;
    @FXML
    private TableColumn colEmail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        userstable.setItems(users);

    }
}
