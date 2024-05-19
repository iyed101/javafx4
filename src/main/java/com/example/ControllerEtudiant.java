package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerEtudiant {

    @FXML
    private TextField nomTextField;
    @FXML
    private TextField prenomTextField;
    @FXML
    private RadioButton sexeRadioButtonM;
    @FXML
    private RadioButton sexeRadioButtonF;
    @FXML
    private ChoiceBox<String> filiereChoiceBox;
    @FXML
    private TableView<Etudiant> etudiantTableView;
    @FXML
    private TableColumn<Etudiant, String> nomColumn;
    @FXML
    private TableColumn<Etudiant, String> prenomColumn;
    @FXML
    private TableColumn<Etudiant, String> sexeColumn;
    @FXML
    private TableColumn<Etudiant, String> filiereColumn;

    private EtudiantM etudiantManager = new EtudiantM();
    private ObservableList<Etudiant> etudiantList;

    @FXML
    public void initialize() {
        // Initialiser la ChoiceBox avec les filières
        filiereChoiceBox.getItems().addAll("DSI", "RSI", "SEM", "MDW");

        // Configurer les colonnes du TableView
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        sexeColumn.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        filiereColumn.setCellValueFactory(new PropertyValueFactory<>("filiere"));

        // Charger les étudiants dans le TableView
        etudiantList = FXCollections.observableArrayList(etudiantManager.findAll());
        etudiantTableView.setItems(etudiantList);

        // Grouper les RadioButton pour le sexe
        ToggleGroup sexeGroup = new ToggleGroup();
        sexeRadioButtonM.setToggleGroup(sexeGroup);
        sexeRadioButtonF.setToggleGroup(sexeGroup);
    }

    @FXML
    private void ajouterEtudiant() {
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String sexe = sexeRadioButtonM.isSelected() ? "M" : "F";
        String filiere = filiereChoiceBox.getValue();

        Etudiant etudiant = new Etudiant(nom, prenom, sexe, filiere);
        if (etudiantManager.create(etudiant)) {
            etudiantList.add(etudiant);
        } else {
            // Afficher un message d'erreur
            showAlert("Erreur", "Impossible d'ajouter l'étudiant", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void supprimerEtudiant() {
        Etudiant selectedEtudiant = etudiantTableView.getSelectionModel().getSelectedItem();
        if (selectedEtudiant != null && etudiantManager.delete(selectedEtudiant)) {
            etudiantList.remove(selectedEtudiant);
        } else {
            // Afficher un message d'erreur
            showAlert("Erreur", "Impossible de supprimer l'étudiant", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void modifierEtudiant() {
        Etudiant selectedEtudiant = etudiantTableView.getSelectionModel().getSelectedItem();
        if (selectedEtudiant != null) {
            selectedEtudiant.setNom(nomTextField.getText());
            selectedEtudiant.setPrenom(prenomTextField.getText());
            selectedEtudiant.setSexe(sexeRadioButtonM.isSelected() ? "M" : "F");
            selectedEtudiant.setFiliere(filiereChoiceBox.getValue());

            if (etudiantManager.update(selectedEtudiant)) {
                etudiantTableView.refresh();
            } else {
                // Afficher un message d'erreur
                showAlert("Erreur", "Impossible de modifier l'étudiant", Alert.AlertType.ERROR);
            }
        } else {
            // Afficher un message d'erreur
            showAlert("Erreur", "Veuillez sélectionner un étudiant", Alert.AlertType.WARNING);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
