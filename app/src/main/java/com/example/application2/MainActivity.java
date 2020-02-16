package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btn;
    public static TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.txt1);
       // txt2=findViewById(R.id.txt2);
        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData fetch=new fetchData();
                fetch.execute();
//getdata();

            }
        });

    }
    private void getdata()
    {
        final Call<PostList>postList= BloggerApi.getPostService().getpostlist();
        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList postList1=response.body();
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                Log.d("post", "onResponse: "+new Gson().toJson(response.body()));
        }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
             Toast.makeText(MainActivity.this,"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
