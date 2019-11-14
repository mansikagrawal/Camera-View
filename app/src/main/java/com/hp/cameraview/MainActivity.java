package com.hp.cameraview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2;
    ImageView i;Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button3);
        i=(ImageView)findViewById(R.id.imageView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,101);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    getApplicationContext().setWallpaper(bmp);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if((requestCode==101)&&(resultCode==RESULT_OK)&&(data!=null))
        {
            Bundle b=data.getExtras();
            bmp=(Bitmap)b.get("data");
            i.setImageBitmap(bmp);

        }
else
        {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }



        super.onActivityResult(requestCode, resultCode, data);
    }
}
