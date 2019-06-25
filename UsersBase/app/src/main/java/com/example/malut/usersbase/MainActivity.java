package com.example.malut.usersbase;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.malut.usersbase.Model.User;
import com.example.malut.usersbase.Model.UserAdapter;
import com.example.malut.usersbase.Model.UserList;
import com.example.malut.usersbase.Services.NetworkService;
import com.example.malut.usersbase.Services.RequestData;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    public View ftView;
    public boolean isLoading = false;

    private ShimmerFrameLayout mShimmerViewContainer;
    private UserList userList;
    private ListView listView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        userList = new UserList();
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ftView = li.inflate(R.layout.loading_view, null);

        new GetData().execute(RequestData.apiRequest());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = userList.getResults().get(position);
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if ((firstVisibleItem + visibleItemCount == totalItemCount) &&
                        (totalItemCount != 0)) {
                    if (!isLoading){
                        listView.addFooterView(ftView);
                        isLoading = true;
                        new GetData().execute(RequestData.apiRequest());
                    }
                }
        }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

    private class GetData extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            String jsonLine = null;
            String urlString = strings[0];
            NetworkService http = new NetworkService();
            jsonLine = http.getHTTPData(urlString);
            return jsonLine;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s == null){
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
                startActivity(intent);
                finish();
            }

            Gson gson = new Gson();
            Type mType = new TypeToken<UserList>(){}.getType();
            if (userList.getResults() != null){
                userList.appendList((UserList) gson.fromJson(s, mType));
                listView.removeFooterView(ftView);
                adapter.refreshAdapter();
            } else{
                userList = gson.fromJson(s, mType);
                if (userList != null) {
                    adapter = new UserAdapter(MainActivity.this, userList.getResults());
                    listView.setAdapter(adapter);
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);
                }
            }
            isLoading = false;


        }
    }

}
