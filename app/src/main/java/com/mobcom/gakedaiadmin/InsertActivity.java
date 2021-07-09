package com.mobcom.gakedaiadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.gson.JsonObject;
import com.mobcom.gakedaiadmin.api.ApiClient;
import com.mobcom.gakedaiadmin.model.MenuModel;
import com.mobcom.gakedaiadmin.model.PostPutDelMenu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    private static final String TAG = "InsertActivity";
    EditText et_id, et_name, et_code, et_price, et_photo, et_type, et_detail, et_status;
    ExtendedFloatingActionButton efab;
    String  et_id_string, et_name_string, et_code_string, et_price_string, et_photo_string, et_type_string, et_detail_string, et_status_string ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        et_id = findViewById(R.id.et_id);
        et_name = findViewById(R.id.et_name);
        et_code = findViewById(R.id.et_code);
        et_price = findViewById(R.id.et_price);
        et_photo = findViewById(R.id.et_photo);
        et_type = findViewById(R.id.et_type);
        et_detail = findViewById(R.id.et_detail);
        et_status = findViewById(R.id.et_status);
        efab = findViewById(R.id.efab_save);
        efab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id_string = et_id.getText().toString();
                et_name_string = et_name.getText().toString();
                et_code_string = et_code.getText().toString();
                et_price_string = et_price.getText().toString();
                et_photo_string = et_photo.getText().toString();
                et_type_string = et_type.getText().toString();
                et_detail_string = et_detail.getText().toString();
                et_status_string = et_status.getText().toString();

                sendMenu(et_id_string, et_name_string, et_code_string, et_type_string, et_price_string, et_photo_string, et_detail_string, et_status_string);
            }
        });
    }
    private void sendMenu(String id, String name, String code, String type, String price, String photo, String detail, String status) {
        ApiClient.endpoint().putMenu(id, name, code, type, price, photo, detail, status).enqueue(new Callback<PostPutDelMenu>() {
            @Override
            public void onResponse(Call<PostPutDelMenu> call, Response<PostPutDelMenu> response) {
//                Log.d(TAG, "onResponse: " +et_id_string );
//                Log.d(TAG, "onResponse: " +et_name_string );
//                Log.d(TAG, "onResponse: " +et_code_string );
//                Log.d(TAG, "onResponse: " +et_type_string );
//                Log.d(TAG, "onResponse: " +et_price_string );
//                Log.d(TAG, "onResponse: " +et_photo_string );
//                Log.d(TAG, "onResponse: " +et_detail_string );
//                Log.d(TAG, "onResponse: " +et_status_string );
                Log.d(TAG, "onResponse: Data Successfully Added" + response.code());
                //Log.d(TAG, "onResponse: Data Successfully Added" + response.body().toString());
                MainActivity.mainActivity.getMenuFromApi();
                finish();
            }

            @Override
            public void onFailure(Call<PostPutDelMenu> call, Throwable t) {
                Log.d(TAG, "onFailure: Failed");

            }
        });
    }

}