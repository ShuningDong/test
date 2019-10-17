package com.example.collegelife.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.collegelife.R;

public class PlayerActivity extends AppCompatActivity {
    private static final String TAG = "Player_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Button test_bottom = findViewById(R.id.test);
        test_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), popup_Passclass.class);
                startActivity(i);
            }
        });

    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop is called");
    }

    @Override
    // Shoulde be called before onPause
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
    }

    @Override
    // Should be called after onStart and onResume
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }
}
