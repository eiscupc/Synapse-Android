package com.app.mg.connectionlibraryandroid.Implementations;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import com.app.mg.connectionlibraryandroid.Methods.IClientMessageMethods;
import com.google.gson.Gson;

import org.java_websocket.client.WebSocketClient;

/**
 * Class that contains the implementation of the methods related to create and send the message to WebSocket Client and Server
 * @param <T> Generic Class that represent the Class which contains all the properties to send as a message
 * @param <V> Generic Class that inherit WebSocketClient properties and methods
 */
public class ClientMessageMethods<T,V extends WebSocketClient> implements IClientMessageMethods<T,V> {
    /**
     * Returns the body of the Message based on the Generic Class
     * @param myIpAddress Private ip as a string variable
     * @param body Generic Class that represents the body of the message
     * @return Return a MessageBody to send as a Message with a property that contain the Generic Class
     */
    @Override
    public MessageBody ConstructMessageBody(String myIpAddress, T body) {
        ConnectMethods connectMethods = new ConnectMethods();
        return new MessageBody<T>()
                .setBody(body)
                .setSender(myIpAddress);
    }


    /**
     * Function that parse the MessageBody as JSON to send as a message
     * @param myIpAddress Private ip as a string variable
     * @param body Generic Class that represents the body of the message
     * @return Returns a MessageBody as a string (JSON)
     */
    @Override
    public String ConstructMessageBodyJSON(String myIpAddress, T body) {
        Gson gson = new Gson();
        return gson.toJson(ConstructMessageBody(myIpAddress,body));
    }


    /**
     * Function that send the MessageBody to WebSocketClient
     * @param messageBody Class that represent the body of the message
     * @param webSocketClient WebSocketClient class implementation
     */
    @Override
    public void SendMessageBody(MessageBody messageBody, V webSocketClient) {
        Gson gson = new Gson();
        webSocketClient.send(gson.toJson(messageBody));
    }

    /**
     * Function that send the MessageBody to WebSocketClient
     * @param body Class that represent the body of the message
     * @param webSocketClient WebSocketClient class implementation
     * @param myIpAddress Private ip as a string variable
     */
    @Override
    public void SendMessageBody(T body, V webSocketClient,String myIpAddress) {
        MessageBody<T> messageBody = ConstructMessageBody(myIpAddress,body);
        SendMessageBody(messageBody,webSocketClient);
    }

    /**
     * Returns a Message Body from JSON string
     * @param message String variable that contains the message as a JSON
     * @return Message Body Class
     */
    @Override
    public MessageBody<T> ReceiveMessageBody(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message,MessageBody.class);
    }
}
