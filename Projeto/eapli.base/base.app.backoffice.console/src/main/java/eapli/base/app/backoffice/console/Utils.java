package eapli.base.app.backoffice.console;

import eapli.base.Application;

import java.net.InetAddress;

public class Utils {
    public void checkServer(String ipAddress,String name){
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);
            System.out.println("Testing  " + name + " on " + ipAddress);
            if (inet.isReachable(1500)) {
                System.out.println("\u001B[32m" + name + " server is online. \u001B[0m");
            } else {
                System.out.println("\u001B[31m" + name + " server is offline. \u001B[0m");
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
    }
    public void checkServers(){
        System.out.println("+= Testing Servers ======================================================================+\n");
        /*checkServer(Application.settings().getDatabaseIp(),"DATABASE");
        checkServer(Application.settings().getImageServerIp(),"IMAGE SERVER");
        checkServer(Application.settings().getWorkflowServer(),"WORKFLOW ENGINE");*/
        checkServer("10.9.20.221","DATABASE");
        checkServer("10.9.21.17","IMAGE SERVER");
        checkServer("10.9.21.27","WORKFLOW ENGINE");
    }
}
