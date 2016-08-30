package com.example.hussainal_homedawy.marketme;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.hussainal_homedawy.marketme.adapter.MessageAdapter;
import com.example.hussainal_homedawy.marketme.manager.MarketMe;
import com.example.hussainal_homedawy.marketme.manager.TextManager;
import com.example.hussainal_homedawy.marketme.object.Client;
import com.example.hussainal_homedawy.marketme.object.Message;

import java.util.ArrayList;
import java.util.List;

public class BroadcastFragment extends Fragment implements AddMessageFragment.Delegate {
    private Context context;

    private TextManager textManager;
    private ListView messageView;

    private static List<Client> clientList;
    private static List<Message> listOfMessages;

    private Button addBroadcast;
    private Button beginBroadcast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedState) {
        // Create our view
        View view = inflater.inflate(R.layout.fragment_broadcast, container, false);

        // Obtain our current context
        context = getActivity().getApplicationContext();

        // Setup all parameters
        textManager = new TextManager(context);

        if (clientList == null) {
            // Setup our test parameters
            clientList = new ArrayList<>();
            clientList.add(new Client("John", "Doe", "9058682834", 20, false));
        }

        if (listOfMessages == null) {
            listOfMessages = new ArrayList<>();

            listOfMessages.add(new Message("Broadcast #1", "This is the first broadcast", false));
            listOfMessages.add(new Message("Broadcast #2", "This is the second broadcast", false));
        }

        // Locate all controls
        messageView = (ListView) view.findViewById(R.id.list_of_messages);
        addBroadcast = (Button) view.findViewById(R.id.add_broadcast);
        beginBroadcast = (Button) view.findViewById(R.id.broadcast);

        // Setup message view
        messageView.setAdapter(new MessageAdapter(context, R.layout.listview_messages, listOfMessages));

        // Setup buttons
        addBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAddMessage();
            }
        });

        beginBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textManager.sendTextMessages(clientList, listOfMessages);
            }
        });

        // Return our view
        return view;
    }

    private void doAddMessage() {
        try {
            // Setup the fragment
            AddMessageFragment addMessageFragment = new AddMessageFragment();
            addMessageFragment.setDelegate(this);

            // Switch current fragment
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, addMessageFragment, AddMessageFragment.class.getName());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } catch (Exception ex) {
            Log.d("doAddMessage %s", ex.getMessage());
        }
    }

    @Override
    public void addMessageToList(Message message) {
        if (listOfMessages == null) {
            listOfMessages = new ArrayList<>();
        }

        listOfMessages.add(message);
    }

    @Override
    public void returnToOrigin() {
        MarketMe.switchToFragment(getFragmentManager(), BroadcastFragment.class);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Close remaining resources
        if (textManager != null) {
            textManager.finish();
        }
    }
}
