package com.example.hussainal_homedawy.marketme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hussainal_homedawy.marketme.R;
import com.example.hussainal_homedawy.marketme.object.Message;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {
    private Context context;

    private TextView broadcastTitle;
    private TextView broadcastDate;

    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Create our view
        View view = LayoutInflater.from(context).inflate(R.layout.listview_messages, null);

        // Obtain our resource
        Message broadcast = getItem(position);

        // Obtain our controls
        broadcastTitle = (TextView) view.findViewById(R.id.broadcast_title);
        broadcastDate = (TextView) view.findViewById(R.id.broadcast_doc);

        // Setup our controls
        broadcastTitle.setText(broadcast.getMessageTitle());
        broadcastDate.setText(broadcast.getDateOfCreation().toString());

        // Return our view
        return view;
    }
}
