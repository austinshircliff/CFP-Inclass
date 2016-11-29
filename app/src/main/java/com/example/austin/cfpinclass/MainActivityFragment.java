package com.example.austin.cfpinclass;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mRef = firebaseDatabase.getReference().child("teams");

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        ListView listViewTeams = (ListView) view.findViewById(R.id.ListViewTeams);
        ListAdapter listAdapter = new FirebaseListAdapter<Team>(getActivity(),Team.class,R.layout.team_item_layout,mRef) {
            @Override
            protected void populateView(View v, Team model, int position) {
                TextView textView = (TextView) v.findViewById(R.id.textViewTeamName);
                textView.setText(model.getName());

            }
        };

        return view;

    }
}
