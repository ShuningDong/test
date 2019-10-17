package com.example.collegelife.ui.main;


import android.os.Bundle;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;

import com.example.collegelife.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "Menu_Fragment";

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        Button start_button = v.findViewById(R.id.start_button);
        start_button.setOnClickListener(this);
        Button settings_button = v.findViewById(R.id.settings_button);
        settings_button.setOnClickListener(this);

        return v;
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart is called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume is called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause is called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop is called");
    }


    public void onClick(View v) {

        Activity activity =  getActivity();
        if (activity != null) {
            switch (v.getId()) {

                case R.id.start_button:
                    //move to player page after click the start button
                    startActivity(new Intent(activity.getApplicationContext(), PlayerActivity.class));
                    break;

                case R.id.settings_button:
                    //move to settings menu after clicking gear icon
                    //startActivity(new Intent(activity.getApplicationContext(), PlayerActivity.class));
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    DocumentReference docRef = db.collection("Test").document("IqRoZmat383tkUD4G88U");
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                } else {
                                    Log.d(TAG, "No such document");
                                }
                            } else {
                                Log.d(TAG, "get failed with ", task.getException());
                            }
                        }
                    });
                    Log.d(TAG, "settings menu coming soon");
                    break;
            }
        }
    }


}
