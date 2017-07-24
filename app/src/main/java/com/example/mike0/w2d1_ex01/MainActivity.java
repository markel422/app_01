package com.example.mike0.w2d1_ex01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY_EXTRA = "com.example.mike0.w2d1_ex01.MAIN_ACTIVITY_EXTRA";

    static final int REQUEST_IMAGE_CAPTURE = 1;

    EditText name;
    EditText lastName;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.user_name);
        lastName = (EditText) findViewById(R.id.user_lastName);

        //Intent intent = new Intent();
    }

    public void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    public void showDetails(View view) {
        String nameValue = name.getText().toString();
        String lastNameValue = lastName.getText().toString();

        User user = new User(nameValue, lastNameValue);

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(MAIN_ACTIVITY_EXTRA, user);

        startActivity(intent);
    }
}
