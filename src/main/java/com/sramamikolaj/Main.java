package com.sramamikolaj;

import javafx.application.Application;
import javafx.stage.Stage;
import org.pcap4j.core.PcapNetworkInterface;

import java.util.Map;

public class Main extends Application {
    GUI userGUI;
    static Interfaces interfaces;

    public static void main(String[] args) {
        interfaces = new Interfaces();
        Map<Integer, PcapNetworkInterface> interfacesMap = interfaces.getInterfaces();

        interfacesMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " = " + entry.getValue());
        });

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        userGUI = new GUI(stage, interfaces);
    }

}