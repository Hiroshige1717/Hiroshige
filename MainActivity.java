package com.hiroshige.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private static final long START_TIME = 10000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button getButtonReset;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning; //タイマーを押してから値が進む真偽値

    private long mTimeLeftInMillis = START_TIME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        getButtonReset = findViewById(R.id.buttonreset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }

        });

        getButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("START");
                getButtonReset.setVisibility(View.INVISIBLE);

            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("PAUSE");
        getButtonReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("START");
        getButtonReset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        mTimeLeftInMillis = START_TIME;
        updateCountDownText();
        mButtonStartPause.setVisibility(View.VISIBLE);
        getButtonReset.setVisibility(View.INVISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int)(mTimeLeftInMillis/1000)/60;
        int seconds = (int)(mTimeLeftInMillis/1000)%60;
        String timerLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes,seconds);
        mTextViewCountDown.setText(timerLeftFormatted);


    }
}
