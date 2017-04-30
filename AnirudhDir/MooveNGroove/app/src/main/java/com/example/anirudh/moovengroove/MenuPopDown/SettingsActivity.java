package com.example.anirudh.moovengroove.MenuPopDown;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.anirudh.moovengroove.ActivityDetection.UserActivity;
import com.example.anirudh.moovengroove.R;

public class SettingsActivity extends AppCompatActivity {
    public  String[] SettingsList={"Customize Song Genre","Number of Recommended Songs"};
    ListView settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initSettingList();
    }

    public void initSettingList(){
        ArrayAdapter adapter = new ArrayAdapter<String>(SettingsActivity.this,
                R.layout.settinglist,SettingsList );
        settings=(ListView)findViewById(R.id.settinglist);
        settings.setAdapter(adapter);
    }
}
