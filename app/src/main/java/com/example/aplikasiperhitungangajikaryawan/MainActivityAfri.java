package com.example.aplikasiperhitungangajikaryawan;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityAfri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_afri);

        findViewById(R.id.menuGaji).setOnClickListener(v ->
                startActivity(new Intent(this, GajiActivityAfri.class)));

        findViewById(R.id.menuPetunjuk).setOnClickListener(v ->
                startActivity(new Intent(this, PetunjukActivityAfri.class)));

        findViewById(R.id.menuTentang).setOnClickListener(v ->
                startActivity(new Intent(this, TentangActivityAfri.class)));

        findViewById(R.id.menuExit).setOnClickListener(v -> finishAffinity());
    }
}
