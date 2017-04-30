package com.example.anirudh.moovengroove.PlayMusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.anirudh.moovengroove.Login.LoginActivity;
import com.example.anirudh.moovengroove.MenuPopDown.SettingsActivity;
import com.example.anirudh.moovengroove.R;
import com.google.firebase.auth.FirebaseAuth;

public class PlayMusic extends AppCompatActivity {
    ImageView albumCover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        albumCover=(ImageView)findViewById(R.id.albumCover);
        albumCover.setImageResource(R.drawable.cover);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settingsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.usersettings:
                Intent settingsIntent=new Intent(PlayMusic.this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            case R.id.help:

                return true;
            case R.id.signout:
                FirebaseAuth.getInstance().signOut();
                Intent loginIntent=new Intent(PlayMusic.this,LoginActivity.class);
                startActivity(loginIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
