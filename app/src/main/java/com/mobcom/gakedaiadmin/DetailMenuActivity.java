package com.mobcom.gakedaiadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class DetailMenuActivity extends AppCompatActivity {

    TextView tv_id, tv_name, tv_code, tv_price, tv_photo, tv_type, tv_detail, tv_status;
    ExtendedFloatingActionButton efab;
    public static DetailMenuActivity detailMenuActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        initialize();
    }

    private void initialize() {
        tv_id = findViewById(R.id.tv_id);
        tv_name = findViewById(R.id.tv_name);
        tv_code = findViewById(R.id.tv_code);
        tv_price = findViewById(R.id.tv_price);
        tv_photo = findViewById(R.id.tv_photo);
        tv_type = findViewById(R.id.tv_type);
        tv_detail = findViewById(R.id.tv_detail);
        tv_status = findViewById(R.id.tv_status);
        efab = findViewById(R.id.efab_edit_menu);

        getDetailMenuFromIntent();

        efab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDetailMenuForIntent();
            }
        });
    }

    public void getDetailMenuFromIntent() {
        Intent mIntent = getIntent();
        tv_id.setText(mIntent.getStringExtra("id"));
        tv_name.setText(mIntent.getStringExtra("nama"));
        tv_code.setText(mIntent.getStringExtra("code"));
        tv_price.setText(mIntent.getStringExtra("harga"));
        tv_photo.setText(mIntent.getStringExtra("photo"));
        tv_type.setText(mIntent.getStringExtra("tipe"));
        tv_detail.setText(mIntent.getStringExtra("detail"));
        tv_status.setText(mIntent.getStringExtra("status"));
    }

    private void addDetailMenuForIntent() {
        Intent mIntent = new Intent(DetailMenuActivity.this, EditActivity.class);
        mIntent.putExtra("id", tv_id.getText().toString());
        mIntent.putExtra("nama", tv_name.getText().toString());
        mIntent.putExtra("code", tv_code.getText().toString());
        mIntent.putExtra("harga", tv_price.getText().toString());
        mIntent.putExtra("photo", tv_photo.getText().toString());
        mIntent.putExtra("tipe", tv_type.getText().toString());
        mIntent.putExtra("detail", tv_detail.getText().toString());
        mIntent.putExtra("status", tv_status.getText().toString());
        startActivity(mIntent);
    }
}