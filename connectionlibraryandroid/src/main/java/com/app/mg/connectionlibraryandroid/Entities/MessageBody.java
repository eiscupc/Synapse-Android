package com.app.mg.connectionlibraryandroid.Entities;

/**
 * Class that contains the body of the message to send
 * @param <T> Generic class that represents the body of the message
 */
public class MessageBody<T> {

    private String sender;
    private T body;

    /**
     * Empty constructor of the class
     */
    public MessageBody() {
    }

    /**
     * Constructor of the class with parameters
     * @param sender Sender id of the message
     * @param body Body of the message
     */
    public MessageBody(String sender, T body) {
        this.sender = sender;
        this.body = body;
    }

    /**
     * @return return the Sender of the Class
     */
    public String getSender() {
        return sender;
    }

    /**
     * Set the sender to the class
     * @param sender Sender ID as string
     */
    public MessageBody<T> setSender(String sender) {
        this.sender = sender;
        return this;
    }

    /**
     * @return Return the body of the Class
     */
    public T getBody() {
        return body;
    }

    /**
     * Set the body of the message
     * @param body Body of the class
     */
    public MessageBody<T> setBody(T body) {
        this.body = body;
        return this;
    }
}
