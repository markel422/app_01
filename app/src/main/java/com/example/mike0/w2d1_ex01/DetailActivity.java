package com.example.mike0.w2d1_ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView name;
    TextView lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.tv_user_name);
        lastName = (TextView) findViewById(R.id.tv_user_lastName);

        Intent intent = getIntent();

        if (intent != null) {
            String nameValue;
            String lastNameValue;

            User user = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);

            nameValue = user.getName();
            lastNameValue = user.getLastName();

            name.setText(nameValue);
            lastName.setText(lastNameValue);
        }
    }
}
