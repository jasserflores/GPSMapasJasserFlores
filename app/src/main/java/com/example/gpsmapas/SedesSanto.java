package com.example.gpsmapas;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class SedesSanto extends AppCompatActivity {
    private VideoView video;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedes_santo);
        video = findViewById(R.id.videoView);
        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.introsantotomas));
        MediaController media = new MediaController(this);
        video.setMediaController(media);
        media.setAnchorView(video);
        video.start();
    }
}