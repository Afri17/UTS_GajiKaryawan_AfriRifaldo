package com.example.aplikasiperhitungangajikaryawan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PetunjukActivityAfri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_afri);

        findViewById(R.id.btnKembali).setOnClickListener(v -> finish());
    }
}
