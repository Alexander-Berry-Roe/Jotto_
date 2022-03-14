package com.berryroe.jotto_;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import java.util.Locale;
import javafx.stage.Popup;

public class Controller {
    public final String  Red = "#eb0c0c";
    public final String Yellow = "#dbd52c";
    public final String Green = "#15ff00";

    private int row = 0;

    private int score = 0;

    @FXML
    private Label scoreLabel;
    @FXML
    private Label errorBox;

    @FXML
    private Button reset;

    private Popup endMsg = new Popup();
    private Label endMsgLabel = new Label();

    @FXML
    private Label C0R0, C0R1, C0R2, C0R3, C0R4, C1R0, C1R1, C1R2, C1R3, C1R4, C2R0, C2R1, C2R2, C2R3, C2R4, C3R0, C3R1, C3R2, C3R3, C3R4, C4R0, C4R1, C4R2, C4R3, C4R4;
    @FXML
    private TextField textField;

    public Label[][] jottoGrid;

    public Word word = new Word();

    @FXML
    private void initialize() {
        jottoGrid = new Label[][] {
                {C0R0, C1R0, C2R0, C3R0, C4R0},
                {C0R1, C1R1, C2R1, C3R1, C4R1},
                {C0R2, C1R2, C2R2, C3R2, C4R2},
                {C0R3, C1R3, C2R3, C3R3, C4R3},
                {C0R4, C1R4, C2R4, C3R4, C4R4}
        };


    }



    public boolean setRow(int row, String word) {
        if (word.length() != 5) {
            return false;
        } else {
            for (int i = 0; i < 5; i++) {
                jottoGrid[row][i].setText(word.substring(i, i + 1));

            }
        }
        return true;
    }

    public void setColour(int row, String colour) {
        for (int i = 0; i < 5; i++) {
            switch (colour.substring(i, i + 1)){
                case "R":
                    jottoGrid[row][i].setTextFill(Color.web(Red));
                    break;
                case "Y":
                    jottoGrid[row][i].setTextFill(Color.web(Yellow));
                    break;
                case "G":
                    jottoGrid[row][i].setTextFill(Color.web(Green));
                    break;
            }
        }
    }

    public void onEnter() {
        errorBox.setText("");
        String word = textField.getText();
        textField.setText("");
        word = word.toUpperCase(Locale.ROOT);
        if(row>=5) {
            reset.setText("Continue");
            errorBox.setText("You failed to guess the word");

        }
        else if(word.length() == 5 && row <= 5 && !this.word.solved && this.word.isInWordList(word)) {
            setRow(this.row, word);
            setColour(this.row, this.word.checkWord(word));
            row++;
            if(this.word.solved){

                score+= 500 - row * 100;

                scoreLabel.setText("Score: " + Integer.toString(score));

                reset.setText("Continue");


            }

        }
        else {
            errorBox.setText("Invalid 5 letter word!");
        }
    }

    public void onResetButton(ActionEvent actionEvent) {
        reset.setText("Skip");
        nextWord();
    }

    public void nextWord(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                jottoGrid[i][j].setText("");
            }

        }
        row = 0;
        word = new Word();
    }

    @FXML
    private void txtFieldKeyPressed(KeyEvent event) {
        if(event.getCode() == event.getCode().ENTER){
            onEnter();
        }
    }

    @FXML
    private void onButtonPress(ActionEvent actionEvent){
        onEnter();
    }

}