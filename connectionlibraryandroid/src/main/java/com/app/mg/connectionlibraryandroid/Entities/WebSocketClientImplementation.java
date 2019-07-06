package com.app.mg.connectionlibraryandroid.Entities;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * WebSocket Client Implementation to find WebSocket Server
 */
public class WebSocketClientImplementation extends WebSocketClient {

    private final List<PossibleServerEntity<String,Boolean>> possibleServers;
    private String ipToFind;

    public WebSocketClientImplementation(URI serverUri,List<PossibleServerEntity<String,Boolean>> possibleServers,String ipToFind ) {
        super(serverUri);
        this.possibleServers = possibleServers;
        this.ipToFind = ipToFind;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        possibleServers.add(new PossibleServerEntity<>(ipToFind, true));
        this.close();
    }

    @Override
    public void onMessage(String message) {

    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }

    @Override
    public void onError(Exception ex) {
        possibleServers.add(new PossibleServerEntity<>(ipToFind, false));
    }
}
