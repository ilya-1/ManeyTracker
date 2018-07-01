package com.loftschool.moneytracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    private static final String TAG = "AddItemActivity";
    public static final String TYPE_KEY = "type";

    private EditText name;
    private EditText price;
    private Button addBtn;

    private String type;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        setTitle(getString(R.string.add_item_title));

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.add_item_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        addBtn = ((Button) findViewById(R.id.add_btn));
        type = getIntent().getStringExtra(TYPE_KEY);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String itemPrice = price.getText().toString();
//                Log.d(TAG, "afterTextChanged: " + s);
                addBtn.setEnabled(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(itemPrice));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String itemName = name.getText().toString();
                //                Log.d(TAG, "afterTextChanged: " + s);
                addBtn.setEnabled(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(itemName));
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = name.getText().toString();
                String itemPrice = price.getText().toString();

                Item item = new Item(itemName,itemPrice,type);
                Intent intent = new Intent();
                intent.putExtra("item",item);
                Toast.makeText(getApplicationContext(),itemName,Toast.LENGTH_SHORT);

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
