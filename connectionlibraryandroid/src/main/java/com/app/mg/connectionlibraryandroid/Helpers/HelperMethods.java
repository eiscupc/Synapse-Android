package com.app.mg.connectionlibraryandroid.Helpers;

import android.widget.Toast;

import com.app.mg.connectionlibraryandroid.Entities.PossibleServerEntity;
import com.app.mg.connectionlibraryandroid.Entities.WebSocketClientImplementation;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public final class HelperMethods {

    /**
     * Function to Connect to possible WebSocketServer
     * @param wSCImplementation WebSocketClient Implementation
     * @param ipList List of ip's
     * @param ipToFind Address of ip to find WebSocketServer
     * @param port Port as a string variable
     */
    public static void ConnectToPossibleWebSocket(List<WebSocketClientImplementation> wSCImplementation, final List<PossibleServerEntity<String,Boolean>> ipList, final String ipToFind, String port) {
        URI uri;
        try {
            uri = new URI("ws://" + ipToFind+":" +port);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        WebSocketClientImplementation webSocketClient = new WebSocketClientImplementation(uri,ipList,ipToFind);
        wSCImplementation.add(webSocketClient);
        wSCImplementation.get(wSCImplementation.size()-1).connect();
    }
}
