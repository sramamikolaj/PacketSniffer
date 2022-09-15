module PacketSniffer {
    requires javafx.graphics;
    requires javafx.fxml;
    requires  javafx.controls;
    requires org.pcap4j.core;

    exports com.sramamikolaj to javafx.graphics;
}