package com.example.malut.usersbase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.malut.usersbase.Model.User;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    User user;
    TextView nameProfile, email, dob, location, registered;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Intent intent = getIntent();

        user = (User) intent.getExtras().getSerializable("user");
        assert user != null;

        nameProfile = findViewById(R.id.name_profile);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.dob);
        location = findViewById(R.id.location);
        registered = findViewById(R.id.registered);
        imageView = findViewById(R.id.image_profile);

        nameProfile.setText(user.getName().toString());
        email.setText(user.getEmail());
        dob.setText(user.getDob().getDate());
        location.setText(user.getLocation().toString());
        registered.setText(user.getRegistered().getDate());
        Glide.with(this)
                .load(user.getPicture().getLarge())
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);

    }
}
