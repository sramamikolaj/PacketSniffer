package com.sramamikolaj;

import javafx.application.Application;
import javafx.stage.Stage;
import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;

import java.util.Map;
import java.util.Scanner;

public class Main extends Application {
    GUI userGUI;
    static Interfaces interfaces;

    public static void main(String[] args) {
        interfaces = new Interfaces();
        Map<Integer, PcapNetworkInterface> interfacesMap = interfaces.getInterfaces();

        interfacesMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " = " + entry.getValue());
        });

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        try {
            interfaces.listen(Integer.parseInt(s));
        } catch (PcapNativeException e) {
            throw new RuntimeException(e);
        } catch (NotOpenException e) {
            throw new RuntimeException(e);
        }

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        userGUI = new GUI(stage);
        interfaces.setReferenceGUI(userGUI);
    }

}