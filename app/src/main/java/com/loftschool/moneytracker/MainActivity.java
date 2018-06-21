package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager =  findViewById(R.id.viewPager);
        MainPagesAdapter adapter = new MainPagesAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);





    }


    @Override
    protected void onStart() {
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        super.onStart();
        Log.d("mainActivity", "onclick tested...");
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }
}
