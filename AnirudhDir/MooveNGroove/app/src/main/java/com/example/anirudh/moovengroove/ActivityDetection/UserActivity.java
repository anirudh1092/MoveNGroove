package com.example.anirudh.moovengroove.ActivityDetection;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anirudh.moovengroove.Login.LoginActivity;
import com.example.anirudh.moovengroove.MenuPopDown.SettingsActivity;
import com.example.anirudh.moovengroove.PlayMusic.PlayMusic;
import com.example.anirudh.moovengroove.R;
import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    ImageView activityImage;
    public TextView mActivityView;
    FloatingActionButton playButton;
    ListView songs;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initViewGroup();
        onClick();
        getSongList();
    }
    public void initViewGroup(){
        playButton=(FloatingActionButton) findViewById(R.id.playUser);
        activityImage=(ImageView)findViewById(R.id.actionimageView);
    }
    public void getSongList(){
        ArrayAdapter adapter = new ArrayAdapter<String>(UserActivity.this,
                R.layout.songlist, mobileArray);
        songs=(ListView)findViewById(R.id.listView);
        songs.setAdapter(adapter);
    }
    public void getUserActivity(){

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
                    Intent settingsIntent=new Intent(UserActivity.this, SettingsActivity.class);
                    startActivity(settingsIntent);
               return true;
           case R.id.help:

               return true;
           case R.id.signout:
               FirebaseAuth.getInstance().signOut();
               Intent loginIntent=new Intent(UserActivity.this,LoginActivity.class);
               startActivity(loginIntent);
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }

    }

    public void onClick(){
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playMusicIntent=new Intent(UserActivity.this, PlayMusic.class);
                playMusicIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(playMusicIntent);
            }
        });
    }

}
