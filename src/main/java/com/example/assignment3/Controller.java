package com.example.assignment3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import java.util.Arrays;

public class Controller {

    public boolean verMail = false;
    public boolean verPass = false;
    public Integer passStrength = 0;

    @FXML
    private Label verStatus;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private void verifyAction() {
        String[] digitList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] charList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] specList = {"!", "@", "?", "%", "&", "*"};
        int isDigit = 0;
        int isChara = 0;
        int isSpec = 0;
        int isLong = 0;
        String userMail = email.getText();
        String userPass = password.getText();

        if (userMail.matches("(.*)@(.*).com") || (userMail.matches("(.*)@(.*).ie"))) {
            verMail = true;
        }

        for (int i = 0; i < digitList.length; i++) {
            String var = digitList[i];
            if (userPass.contains(var)) {
                isDigit = 1;
            }
        }
            for (int k = 0; k < charList.length; k++) {
                String vark = charList[k];
                if (userPass.contains(vark)) {
                    isChara = 1;
                }
            }
            for (int j = 0; j < specList.length; j++) {
                String varj = specList[j];
                if (userPass.contains(varj)) {
                    isSpec = 1;
                }
            }

                int length = userPass.length();
                if (length > 7) {
                    isLong = 1;
                }

                passStrength = isChara + isLong + isDigit + isSpec;
                if (passStrength == 4) {
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