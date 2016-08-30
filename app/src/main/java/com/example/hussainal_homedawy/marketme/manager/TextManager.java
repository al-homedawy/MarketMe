package com.example.hussainal_homedawy.marketme.manager;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import com.example.hussainal_homedawy.marketme.object.Client;
import com.example.hussainal_homedawy.marketme.object.Message;

import java.util.ArrayList;
import java.util.List;

public class TextManager {
    private SmsManager smsManager;
    private Context context;

    private List<Message> sentMsgs;
    private final String TEXT_SENT_ACTION = "SMS_MSG_SENT";
    private final String TEXT_RCVD_ACTION = "SMS_MSG_RCVD";

    public TextManager(Context context) {
        this.context = context;
        this.smsManager = SmsManager.getDefault();

        // Setup our list of messages
        sentMsgs = new ArrayList<>();

        // Register our broadcast receivers
        context.registerReceiver(textMessageSent, new IntentFilter(TEXT_SENT_ACTION));
        context.registerReceiver(textMesageRcvd, new IntentFilter(TEXT_RCVD_ACTION));
        context.registerReceiver(interceptMessage, new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION));
    }

    public void finish() {
        context.unregisterReceiver(textMessageSent);
        context.unregisterReceiver(textMesageRcvd);
        context.unregisterReceiver(interceptMessage);
    }

    private BroadcastReceiver textMessageSent = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("%s", "Text message sent");
        }
    };

    private BroadcastReceiver textMesageRcvd = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("%s", "Text message received");
        }
    };

    private BroadcastReceiver interceptMessage = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Obtain intent information
            Bundle bundle = intent.getExtras();
            Object[] pdus = (Object[]) bundle.get("pdus");

            // Obtain SMS message
            SmsMessage response = SmsMessage.createFromPdu((byte[]) pdus[0]);

            // Extract SMS information
            Log.d("%s\n", "text: " + response.getOriginatingAddress() + " " + response.getDisplayMessageBody());
        }
    };

    public void sendTextMessages(List<Client> clients, List<Message> messages) {
        if (smsManager == null) {
            return;
        }

        // Send message(s) to each client in list
        for (Client client : clients) {
            // Send each message from the list
            for (Message message : messages) {
                // Setup our intents
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, new Intent(TEXT_SENT_ACTION), PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent deliveryIntent = PendingIntent.getBroadcast(context, 0, new Intent(TEXT_RCVD_ACTION), PendingIntent.FLAG_UPDATE_CURRENT);

                // Set our client destination
                message.setDestination(client);

                // Add our message
                sentMsgs.add(message);

                // Send the text message
                smsManager.sendTextMessage(client.getPhoneNumber(), null, message.getMessageBody(), pendingIntent, deliveryIntent);
            }
        }
    }
}
