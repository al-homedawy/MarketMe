package com.example.hussainal_homedawy.marketme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.hussainal_homedawy.marketme.object.Message;

public class AddMessageFragment extends Fragment {

    private Delegate delegate;

    // Message Information
    private EditText messageTitle;
    private EditText messageBody;
    private CheckBox responseRqrd;

    // Controls
    private Button saveMessage;
    private Button cancelMessage;

    public AddMessageFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedState) {
        // Create our view
        View view = inflater.inflate(R.layout.fragment_addmessage, container, false);

        // Locate all controls
        messageTitle = (EditText) view.findViewById(R.id.message_title);
        messageBody = (EditText) view.findViewById(R.id.message_body);
        responseRqrd = (CheckBox) view.findViewById(R.id.response_required);
        saveMessage = (Button) view.findViewById(R.id.save_message);
        cancelMessage = (Button) view.findViewById(R.id.cancel_message);

        // Setup all functionality
        saveMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = messageTitle.getText().toString();
                String body = messageBody.getText().toString();
                boolean responseRequired = responseRqrd.isChecked();

                delegate.addMessageToList(new Message(title, body, responseRequired));
                delegate.returnToOrigin();
            }
        });

        cancelMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delegate.returnToOrigin();
            }
        });

        // Return our view
        return view;
    }

    public interface Delegate {
        void addMessageToList(Message message);

        void returnToOrigin();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }
}
