package com.sramamikolaj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pcap4j.core.*;

public class Interfaces {
    private Map<Integer, PcapNetworkInterface> availableInterfaces;
    private Integer currentInterface = null;

    public Interfaces(){
        availableInterfaces = new HashMap<>();

        List<PcapNetworkInterface> interfaces = findInterfaces();
        for(int i = 0; i < interfaces.size(); i++){
            availableInterfaces.put(i, interfaces.get(i));
        }
    }
    private List<PcapNetworkInterface> findInterfaces(){
        List<PcapNetworkInterface> interfaces = null;
        try {
            interfaces = Pcaps.findAllDevs();
        } catch (PcapNativeException e) {
            throw new RuntimeException(e);
        }

        return interfaces;
    }

    public void listen(int ifNumber) throws PcapNativeException, NotOpenException {
        PcapNetworkInterface selectedDevice = availableInterfaces.get(ifNumber);

    }

    public Map<Integer, PcapNetworkInterface> getInterfaces(){ return availableInterfaces; }
    public void setCurrentInterface(int selection) {currentInterface = selection; }
    public int getCurrentInterface() {return currentInterface;}
    public PcapNetworkInterface getCurrentInterfaceObject(){
        return availableInterfaces.get(currentInterface);
    }

}
