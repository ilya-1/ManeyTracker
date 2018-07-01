package com.loftschool.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";

    private ViewPager pager;
    private TabLayout tabLayout;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPage = pager.getCurrentItem();
                String type = null;
                if(currentPage==MainPagesAdapter.PAGE_INCOMES){
                    type=Item.TYPE_INCOMES;
                }else if(currentPage==MainPagesAdapter.PAGE_EXPENSES){
                    type=Item.TYPE_EXPENSES;
                }

                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                intent.putExtra(AddItemActivity.TYPE_KEY, type);
                startActivityForResult(intent, ItemsFragment.ADD_REQUEST_CODE);
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pager = findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        MainPagesAdapter adapter = new MainPagesAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);

        tabLayout.setupWithViewPager(pager);

        Log.i(TAG, "onCreate: ");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mainActivity", "onclick tested...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case MainPagesAdapter.PAGE_INCOMES:
            case MainPagesAdapter.PAGE_EXPENSES:
                fab.show();
                break;
            case MainPagesAdapter.PAGE_BALANCE:
                fab.hide();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case ViewPager.SCROLL_STATE_IDLE:
                fab.setEnabled(true);
                break;
            case ViewPager.SCROLL_STATE_DRAGGING:
                fab.setEnabled(false);
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                fab.setEnabled(false);
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode,resultCode, data);

        }
    }
}
