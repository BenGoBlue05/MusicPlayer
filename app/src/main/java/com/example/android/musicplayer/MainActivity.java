package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.play_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);

        mMediaPlayer = MediaPlayer.create(getApplicationContext(),
                R.raw.color_brown);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(getApplicationContext(), "I\'m done!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();
            }
        });
    }
}
