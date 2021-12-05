package com.example.assignment3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.event.*;

public class Controller {

    public boolean verMail = false;
    public boolean verPass = false;

    @FXML
    private Label verStatus;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private void verifyAction() {
        String userMail = email.getText();
        String userPass = password.getText();

        if(userMail.matches("(.*)@(.*).com") || (userMail.matches("(.*)@(.*).ie"))) {
            verMail = true;
        }

        if(userPass.contains("[abcdefghijklmnopqrstuvwxyz]") && userPass.contains("[0-9]")) {
            verPass = true;
        }

        if (verMail && verPass) {
            verStatus.setText("Verification Succeeded.");
        } else if (verMail) {
            verStatus.setText("Verification Failed: Password too weak.");
        } else if (verPass) {
            verStatus.setText("Verification Failed: Enter a valid email.");
        } else {
            verStatus.setText("Verification Failed: Enter a valid email and password.");
        }
    }
    /*@FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/
}