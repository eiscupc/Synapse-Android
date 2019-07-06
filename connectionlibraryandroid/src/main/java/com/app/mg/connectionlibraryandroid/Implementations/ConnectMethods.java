package com.app.mg.connectionlibraryandroid.Implementations;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import com.app.mg.connectionlibraryandroid.Entities.PossibleServerEntity;
import com.app.mg.connectionlibraryandroid.Entities.WebSocketClientImplementation;
import com.app.mg.connectionlibraryandroid.Methods.IConnectMethods;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.Context.WIFI_SERVICE;
import static com.app.mg.connectionlibraryandroid.Helpers.HelperMethods.ConnectToPossibleWebSocket;

/**
 * Class that contains the implementation of the methods related to the connection and search
 */
public final class ConnectMethods implements IConnectMethods {
    /**
     * Returns a list of strings with all the available servers
     * @param myIpAddress Private ip as a string variable
     * @param port Server port as a string variable
     * @return List of available servers (List<string>)
     */
    @Override
    public List<String> FindServers(String myIpAddress, String port) {
        List<String> ipServers = new ArrayList<>();
        List<PossibleServerEntity<String,Boolean>> possiblesServer = new ArrayList<>();
        List<WebSocketClientImplementation> wSCImplementation = new ArrayList<>();

        String[] ipArray = myIpAddress.split("\\.");
        List<String> ipArray2 = new ArrayList<>();
        Collections.addAll(ipArray2, ipArray);
        String newIpAddress = ipArray2.get(0) + "." + ipArray2.get(1) + "." + ipArray2.get(2) + ".";

        for(int i = 1; i<256;i++){
            String ipToFind = newIpAddress+i;
            ConnectToPossibleWebSocket(wSCImplementation,possiblesServer,ipToFind,port);
        }
        while(possiblesServer.size() < 255){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (PossibleServerEntity<String,Boolean> possibleServer: possiblesServer) {
            if(possibleServer.y) ipServers.add(possibleServer.x);
        }
        return ipServers;
    }

    /**
     * Returns Socket address to pass to WebSocket Server
     * @param context Context of Application
     * @param port Server port as a string variable
     * @return Socket Address to WebSocket
     */
    @Override
    public InetSocketAddress GetISocketAddres(Context context, String port) {
        return new InetSocketAddress(FindMyIpAddress(context), 8080);
    }

    /**
     * Returns url to WebSocket parsed as URI
     * @param ipAddress Private ip as a string variable
     * @param port Server port as a string variable
     * @return Url parsed as URI
     */
    @Override
    public URI GetUriServer(String ipAddress, String port) {
            try {
                return new URI("ws://" + ipAddress +":"+ port);
            } catch (URISyntaxException e) {
                e.printStackTrace();
                return null;
            }

    }


    /**
     * Function that return the private Ip of the phone
     * @param context Context of the Application
     * @return return private Ip
     */
    @SuppressLint("WifiManagerPotentialLeak")
    @Override
    public String FindMyIpAddress(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(WIFI_SERVICE);
        return Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }


}
