package com.an.intentusingcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    Button btnCamera2;
    ImageView imgOurCamera2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCamera2 = (Button) findViewById(R.id.btnCamera);
        imgOurCamera2 = (ImageView) findViewById(R.id.imgOurCamera);

        btnCamera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //request for using the Camera
                startActivityForResult(i,10); // number 10 is like a unique number for the Camera Request. It ca be any number that we want.

            }
        });
    }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK) {  //did the user choose OK?

                if (requestCode == 10) { //we are hearing back from the camera.

                    Bitmap cameraImage = (Bitmap) data.getExtras().get("data");  //at this point we have the image from the camera.


                    imgOurCamera2.setImageBitmap(cameraImage);
                }

            }
        }

}
