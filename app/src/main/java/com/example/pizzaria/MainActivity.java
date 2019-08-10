package com.example.pizzaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img_pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_pizza = (ImageView) findViewById(R.id.img_pizza);

        img_pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telefone = "5551982568798";
                Uri uri = Uri.parse("tel:" + telefone);

                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
