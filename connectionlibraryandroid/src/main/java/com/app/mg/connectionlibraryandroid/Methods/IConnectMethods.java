package com.app.mg.connectionlibraryandroid.Methods;

import android.content.Context;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

/**
 * Interface that contains the methods related to the connection and search
 */
public interface IConnectMethods {

    /**
     * Function that return the private Ip of the phone
     * @param context Context of the Application
     * @return return private Ip
     */
    String FindMyIpAddress(Context context);

    /**
     * Returns a list of strings with all the available servers
     * @param myIpAddress Private ip as a string variable
     * @param port Server port as a string variable
     * @return List of available servers (List<string>)
     */
    List<String> FindServers(String myIpAddress, String port);

    /**
     * Returns Socket address to pass to WebSocket Server
     * @param context Context of Application
     * @param port Server port as a string variable
     * @return Socket Address to WebSocket
     */
    InetSocketAddress GetISocketAddres(Context context, String port);

    /**
     * Returns url to WebSocket parsed as URI
     * @param ipAddress Private ip as a string variable
     * @param port Server port as a string variable
     * @return Url parsed as URI
     */
    URI GetUriServer(String ipAddress,  String port);
}
