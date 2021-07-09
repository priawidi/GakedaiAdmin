package com.mobcom.gakedaiadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mobcom.gakedaiadmin.adapter.MenuAdapter;
import com.mobcom.gakedaiadmin.api.ApiClient;
import com.mobcom.gakedaiadmin.model.GetMenuModel;
import com.mobcom.gakedaiadmin.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public String id = "";
    private MenuAdapter menuAdapter;
    public static MainActivity mainActivity;
    private static final String TAG = "MainActivity";
    FloatingActionButton fab;
    RecyclerView.Adapter mAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        recyclerView = findViewById(R.id.rv_menu);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        mainActivity = this;
        getMenuFromApi();
        fab = findViewById(R.id.floating_action_button_insert);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Move to Insert Activity");
//              Intent mIntent = new Intent(v.getContext(), DetailMenuActivity.class);
                Intent startIntent = new Intent(v.getContext(), InsertActivity.class);
                v.getContext().startActivity(startIntent);
            }
        });
    }

    public void getMenuFromApi() {
        Log.d(TAG, "getMenuFromApi: Initiated");
        ApiClient.endpoint().getMenu().enqueue(new Callback<GetMenuModel>() {
            @Override
            public void onResponse(Call<GetMenuModel> call, Response<GetMenuModel> response) {
                List<MenuModel> MenuList = response.body().getListDataMenu();
                Log.d(TAG, "onResponse: Jumlah Data Menu = " + String.valueOf(MenuList.size()));
                mAdapter = new MenuAdapter(MenuList);
                mAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(mAdapter);
                Log.d(TAG, "onResponse: Success ");
                Log.d(TAG, "onResponse: Success " + MenuList);
            }

            @Override
            public void onFailure(Call<GetMenuModel> call, Throwable t) {

                Log.d(TAG, "onResponse: Failed " + t.getCause());
            }
//            @Override
//            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
//
//                if(!response.isSuccessful()){
//                    Log.d(TAG, "onResponse: Failed coy " + response.code());
//                    Log.d(TAG, "onResponse: Failed coy " + response.message());
//                }
//                MenuAdapter menuAdapter = new MenuAdapter(listMenu);
//                recyclerView.setAdapter(menuAdapter);
//                Log.d(TAG, "onResponse: Success ");
//            }
//
//            @Override
//            public void onFailure(Call<MainModel> call, Throwable t) {
//                Log.d(TAG, "onResponse: Failed " + t.getCause());
//            }
        });

    }
}