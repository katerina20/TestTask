package com.example.malut.usersbase.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.malut.usersbase.R;

import java.net.URL;
import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    private Activity context;
    private ArrayList<User> users;
    private static LayoutInflater inflater = null;

    public UserAdapter(Activity context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View userView = convertView;
        userView = (userView == null) ? inflater.inflate(R.layout.list_item, null): userView;
        TextView textViewName = (TextView) userView.findViewById(R.id.textName);
        TextView textViewSurname = (TextView) userView.findViewById(R.id.textSurname);
        ImageView imageView = (ImageView) userView.findViewById(R.id.imageUser);
        User selectedUser = users.get(position);
        textViewName.setText(selectedUser.getName().getFirst());
        textViewSurname.setText(selectedUser.getName().getLast());
        Glide.with(context)
                .load(selectedUser.getPicture().getLarge())
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
        return userView;
    }

    public void refreshAdapter(){
        this.notifyDataSetChanged();
    }
}
