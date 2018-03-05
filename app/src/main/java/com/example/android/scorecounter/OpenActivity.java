package com.example.android.scorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OpenActivity extends AppCompatActivity {

    EditText playerOne;
    EditText playerTwo;
    TextView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);


        /**
         * Creates intent to MainAcitivity when Play is clicked. Takes EditText views and sends as extras.
         */

        playerOne = (EditText) findViewById(R.id.nameOne);
        playerTwo = (EditText) findViewById(R.id.nameTwo);
        play = (TextView) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(OpenActivity.this, MainActivity.class);
                    playIntent.putExtra("first_name",playerOne.getText().toString());
                    playIntent.putExtra("second_name",playerTwo.getText().toString());
                startActivity(playIntent);
            }
        });
    }

}
