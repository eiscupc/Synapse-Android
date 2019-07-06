package com.app.mg.connectionlibraryandroid.Methods;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import org.java_websocket.client.WebSocketClient;

/**
 * Interface that contains the methods related to create and send the message to WebSocket Client and Server
 * @param <T> Generic Class that represent the Class which contains all the properties to send as a message
 * @param <V> Generic Class that inherit WebSocketClient properties and methods
 */
public interface IClientMessageMethods<T,V extends WebSocketClient> {
    /**
     * Returns the body of the Message based on the Generic Class
     * @param myIpAddress Private ip as a string variable
     * @param body Generic Class that represents the body of the message
     * @return Return a MessageBody to send as a Message with a property that contain the Generic Class
     */
    MessageBody ConstructMessageBody(String myIpAddress, T body);


    /**
     * Function that parse the MessageBody as JSON to send as a message
     * @param myIpAddress Private ip as a string variable
     * @param body Generic Class that represents the body of the message
     * @return Returns a MessageBody as a string (JSON)
     */
    String ConstructMessageBodyJSON(String myIpAddress, T body);

    /**
     * Function that send the MessageBody to WebSocketClient
     * @param messageBody Class that represent the body of the message
     * @param webSocketClient WebSocketClient class implementation
     */
    void SendMessageBody(MessageBody messageBody,  V webSocketClient);

    /**
     * Function that send the MessageBody to WebSocketClient
     * @param body Class that represent the body of the message
     * @param webSocketClient WebSocketClient class implementation
     * @param myIpAddress Private ip as a string variable
     */
    void SendMessageBody(T body,  V webSocketClient,String myIpAddress);

    /**
     * Returns a Message Body from JSON string
     * @param message String variable that contains the message as a JSON
     * @return Message Body Class
     */
    MessageBody<T> ReceiveMessageBody(String message);
}


