package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private TextView textViewTitle;
    private ImageView imageViewDrillPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        textViewInfo = findViewById(R.id.textViewInfoScroll);
        textViewTitle = findViewById(R.id.textViewTitle);
        imageViewDrillPic = findViewById(R.id.imageViewDrill);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            imageViewDrillPic.setImageResource(intent.getIntExtra("resId", -1));
            textViewTitle.setText(intent.getStringExtra("title"));
            textViewInfo.setText(intent.getStringExtra("info"));
        } else {
            Intent backToCategories = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategories);
        }
    }
}