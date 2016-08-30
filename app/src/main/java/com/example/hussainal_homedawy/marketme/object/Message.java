package com.example.hussainal_homedawy.marketme.object;


import java.util.Date;

public class Message {
    private Client destination;

    // Title of message
    private String messageTitle;

    // Message content
    private String messageBody;

    // Message response
    private String responseBody;
    private boolean responseRqrd;

    // Message DOC
    private Date dateOfCreation;

    public Message(String messageTitle, String messageBody, boolean responseRqrd) {
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
        this.responseRqrd = responseRqrd;
        dateOfCreation = new Date();
    }

    public Message(String messageTitle, String messageBody, boolean responseRqrd, Client destination) {
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
        this.responseRqrd = responseRqrd;
        this.destination = destination;
        dateOfCreation = new Date();
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public boolean getResponseRqrd() {
        return responseRqrd;
    }

    public void setDestination(Client destination) {
        this.destination = destination;
    }

    public Client getDestination() {
        return destination;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }
}
