package com.sramamikolaj;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI {
    //GUI variables
    Text t;
    int i = 0;
    Button button;
    //Other variables




    public GUI(Stage stage) throws IOException {

        BorderPane mainPane = FXMLLoader.load(getClass().getResource("/MainView.fxml"));

        button = new Button("i++");
        button.setOnAction(e -> updateInterfaces());
        mainPane.setTop(button);

        t = new Text();
        t.setFont(new Font(20));
        t.setText("First row\nSecond row");

        mainPane.setCenter(t);

        Scene scene = new Scene(mainPane);


        stage.setScene(scene);



        stage.show();

    }


    public void updateInterfaces(){
        t.setText(String.valueOf(i));
        i++;
    }


}
