package com.example.android.scorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORE_1 = "pointsPlayer1";
    static final String STATE_SCORE_2 = "pointsPlayer2";
    static final String STATE_SCORE_3 = "totalPlayer1";
    static final String STATE_SCORE_4 = "totalPlayer2";
    static final String NAME_1 = "first";
    static final String NAME_2 = "second";

    int pointsPlayer1 = 0;
    int pointsPlayer2 = 0;
    int totalPlayer1 = 0;
    int totalPlayer2 = 0;
    String first;
    String second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Takes user input from first activity and displays player names
         */

        Intent intent2 = getIntent();

        Bundle bundle = intent2.getExtras();
        first = bundle.getString("first_name");
        second = bundle.getString("second_name");
        displayPlayer1Name(first);
        displayPlayer2Name(second);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        savedInstanceState.putInt(STATE_SCORE_1, pointsPlayer1);
        savedInstanceState.putInt(STATE_SCORE_2, pointsPlayer2);
        savedInstanceState.putInt(STATE_SCORE_3, totalPlayer1);
        savedInstanceState.putInt(STATE_SCORE_4, totalPlayer2);
        savedInstanceState.putString(NAME_1, first);
        savedInstanceState.putString(NAME_2, second);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        pointsPlayer1 = savedInstanceState.getInt(STATE_SCORE_1);
        pointsPlayer2 = savedInstanceState.getInt(STATE_SCORE_2);
        totalPlayer1 = savedInstanceState.getInt(STATE_SCORE_3);
        totalPlayer2 = savedInstanceState.getInt(STATE_SCORE_4);
        first = savedInstanceState.getString(NAME_1);
        second = savedInstanceState.getString(NAME_2);
        displayForPlayer1(pointsPlayer1);
        displayForPlayer2(pointsPlayer2);
        displayTotalForPlayer1(totalPlayer1);
        displayTotalForPlayer2(totalPlayer2);
        displayPlayer1Name(first);
        displayPlayer2Name(second);

    }

    public void displayPlayer1Name (String first){
        TextView newNameOne = (TextView) findViewById(R.id.playerOne);
        newNameOne.setText(String.valueOf(first));
    }

    public void displayPlayer2Name (String second){
        TextView newNameTwo = (TextView) findViewById(R.id.playerTwo);
        newNameTwo.setText(String.valueOf(second));

    }

    public void displayForPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    public void strikeFor1 (View view) {
        pointsPlayer1 ++;
        displayForPlayer1(pointsPlayer1);
    }

    public void displayForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void strikeFor2 (View view) {
        pointsPlayer2 ++;
        displayForPlayer2(pointsPlayer2);
    }

    public void displayTotalForPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_total);
        scoreView.setText(String.valueOf(score));
    }

    public void addTo1 (View view) {
        totalPlayer1 = totalPlayer1 + pointsPlayer1;
        displayTotalForPlayer1(totalPlayer1);
    }

    public void displayTotalForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_total);
        scoreView.setText(String.valueOf(score));
    }

    public void addTo2 (View view) {
        totalPlayer2 = totalPlayer2 + pointsPlayer2;
        displayTotalForPlayer2(totalPlayer2);
    }

    public void displayResetHole1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset1 (View view) {
        pointsPlayer1 = 0;
        displayResetHole1(pointsPlayer1);
    }

    public void displayResetHole2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset2 (View view) {
        pointsPlayer2 = 0;
        displayResetHole2(pointsPlayer2);
    }

    public void resetAll (View view) {
        totalPlayer1 = 0;
        totalPlayer2 = 0;
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
        displayTotalForPlayer1(totalPlayer1);
        displayTotalForPlayer2(totalPlayer2);
        displayForPlayer1(pointsPlayer1);
        displayForPlayer2(pointsPlayer2);
    }

}
