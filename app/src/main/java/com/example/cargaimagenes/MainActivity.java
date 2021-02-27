package com.example.cargaimagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    int imagenACargar = 0;
    DisplayImageOptions options;
    ImageLoader imageLoader;
    String[] heroes = {"https://simplifiedcoding.net/demos/view-flipper/images/spiderman.jpg","https://simplifiedcoding.net/demos/view-flipper/images/ironman.jpg",
    "https://simplifiedcoding.net/demos/view-flipper/images/thor.jpg","https://simplifiedcoding.net/demos/view-flipper/images/wolverine.jpeg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        img = findViewById(R.id.idImageView);
        String imageUri = heroes[0];
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.ic_launcher_foreground)
                .showImageForEmptyUri(R.drawable.ic_launcher_background)
                .cacheInMemory()
                .cacheOnDisc()
                .build();
        imageLoader.displayImage(imageUri,img,options,null);
    }
    public void Boton(View v){
        imagenACargar+=1;
        if(imagenACargar > 3)
            imagenACargar = 0;
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        img = findViewById(R.id.idImageView);
        String imageUri = heroes[imagenACargar];
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.ic_launcher_foreground)
                .showImageForEmptyUri(R.drawable.ic_launcher_background)
                .cacheInMemory()
                .cacheOnDisc()
                .build();
        imageLoader.displayImage(imageUri,img,options,null);
    }
}