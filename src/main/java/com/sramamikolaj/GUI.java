package com.sramamikolaj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.pcap4j.core.PcapNetworkInterface;

import java.io.IOException;
import java.util.Map;

public class GUI {
    //GUI variables
    Text interfaceInfo;
    int i = 0;
    Button button;
    //Other variables
    private BorderPane mainPane;

    Interfaces referenceIfs;


    public GUI(Stage stage, Interfaces ref) throws IOException {

        setIfReference(ref);

        mainPane = FXMLLoader.load(getClass().getResource("/MainView.fxml"));

        button = new Button("i++");

        mainPane.setTop(button);
        createButtons();
        interfaceInfo = new Text();
        interfaceInfo.setFont(new Font(20));
        interfaceInfo.setText("No interface selected");
        mainPane.setCenter(interfaceInfo);

        Scene scene = new Scene(mainPane);


        stage.setScene(scene);



        stage.show();

    }


    private void createButtons(){
        Map<Integer, PcapNetworkInterface> availableInterfaces = referenceIfs.getInterfaces();
        ObservableList<String> items = FXCollections.observableArrayList ();

        availableInterfaces.entrySet().forEach(currInt->{
            items.add(currInt.getKey(), currInt.getValue().getDescription());
        });

        ListView<String> list = new ListView<>();
        list.setOnMouseClicked(e -> selectionChanged(list.getSelectionModel().getSelectedIndex()));
        list.setItems(items);

        mainPane.setLeft(list);
    }
    public void setIfReference(Interfaces ref){
        referenceIfs = ref;
    }

    private void selectionChanged(int selected){
        System.out.println(selected);
        referenceIfs.setCurrentInterface(selected);
        updateInfo();
        }

    private void updateInfo() {
        PcapNetworkInterface currentInterface = referenceIfs.getCurrentInterfaceObject();
        interfaceInfo.setText(currentInterface.getDescription()+ "\n" + currentInterface.getLinkLayerAddresses());
    }

}
