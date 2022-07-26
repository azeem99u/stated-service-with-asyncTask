package com.azeem99u.startedserviswithasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String AZEEM = "azeem";
    String[] songs = {
            "mere bina tu","Tu chahye","aap ki nazroony samjha","afreee afreee"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] songList = songs;
        findViewById(R.id.button).setOnClickListener(view -> {
            for (String song: songList) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra(AZEEM,song);
                startService(intent);
            }
        });

    }
}