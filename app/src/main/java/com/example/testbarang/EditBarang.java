package com.example.testbarang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditBarang extends AppCompatActivity {
    TextView tv_Brng;
    EditText ed_Nama, ed_Telp;
    Button btnEdit;
    DatabaseReference databaseReference;
    String kode, nama, telp;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_edit);

        tv_Brng = findViewById(R.id.tv_brng);
        ed_Nama = findViewById(R.id.edNama);
        ed_Telp = findViewById(R.id.edTelp);
        btnEdit = findViewById(R.id.btEdit);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        Bundle bundle = this.getIntent().getExtras();
        kode = bundle.getString("Kunci1");
        nama = bundle.getString("Kunci2");
        telp = bundle.getString("Kunci3");

        tv_Brng.setText(kode);
        ed_Nama.setText(nama);
        ed_Telp.setText(telp);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editBrng(new Barang(ed_Nama.getText().toString(), ed_Telp.getText().toString()));

            }
        });
    }

    public void editBrng(Barang brg) {
        databaseReference.child("Barang").child(kode).setValue(brg).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(EditBarang.this, "Data Berhasil diEdit", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
