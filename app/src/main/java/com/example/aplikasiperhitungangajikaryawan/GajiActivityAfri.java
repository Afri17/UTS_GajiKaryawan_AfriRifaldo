package com.example.aplikasiperhitungangajikaryawan;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;
import java.util.Locale;

public class GajiActivityAfri extends AppCompatActivity {

    EditText etNik, etNama, etGajiPokok, etTunjJabatan, etHariKerja;
    TextView tvTunjMakan, tvTunjTransport, tvGajiKotor, tvGajiBersih;
    Button btnHitung, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_afri);

        etNik = findViewById(R.id.etNik);
        etNama = findViewById(R.id.etNama);
        etGajiPokok = findViewById(R.id.etGajiPokok);
        etTunjJabatan = findViewById(R.id.etTunjJabatan);
        etHariKerja = findViewById(R.id.etHariKerja);
        tvTunjMakan = findViewById(R.id.tvTunjMakan);
        tvTunjTransport = findViewById(R.id.tvTunjTransport);
        tvGajiKotor = findViewById(R.id.tvGajiKotor);
        tvGajiBersih = findViewById(R.id.tvGajiBersih);
        btnHitung = findViewById(R.id.btnHitung);
        btnKembali = findViewById(R.id.btnKembali);

        btnHitung.setOnClickListener(v -> hitungGaji());
        btnKembali.setOnClickListener(v -> finish());
    }

    private void hitungGaji() {
        String nik = etNik.getText().toString().trim();
        String nama = etNama.getText().toString().trim();
        String sGajiPokok = etGajiPokok.getText().toString().trim();
        String sTunjJabatan = etTunjJabatan.getText().toString().trim();
        String sHariKerja = etHariKerja.getText().toString().trim();

        if (TextUtils.isEmpty(nik) || TextUtils.isEmpty(nama)
                || TextUtils.isEmpty(sGajiPokok) || TextUtils.isEmpty(sTunjJabatan)
                || TextUtils.isEmpty(sHariKerja)) {
            Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        long gajiPokok = Long.parseLong(sGajiPokok);
        long tunjJabatan = Long.parseLong(sTunjJabatan);
        int hariKerja = Integer.parseInt(sHariKerja);

        long tunjMakan = hariKerja * 10000L;
        long tunjTransport = hariKerja * 5000L;
        long gajiKotor = gajiPokok + tunjJabatan + tunjMakan + tunjTransport;
        double pajak = 0.10 * gajiKotor;
        double gajiBersih = gajiKotor - pajak;

        tvTunjMakan.setText("Tunjangan Makan : " + rupiah(tunjMakan));
        tvTunjTransport.setText("Tunjangan Transportasi : " + rupiah(tunjTransport));
        tvGajiKotor.setText("Gaji Kotor : " + rupiah(gajiKotor));
        tvGajiBersih.setText("Gaji Bersih : " + rupiah(gajiBersih));
    }

    private String rupiah(double angka) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        nf.setMaximumFractionDigits(0);
        return nf.format(angka);
    }
}
