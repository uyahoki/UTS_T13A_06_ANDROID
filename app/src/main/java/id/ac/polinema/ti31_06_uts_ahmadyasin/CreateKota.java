package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateKota extends AppCompatActivity {

    EditText namaKota;
    Button ButtonSave, ButtonCekData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_kota);

        namaKota = findViewById(R.id.editNamaKota);
        ButtonSave = findViewById(R.id.buttonSave);
        ButtonCekData = findViewById(R.id.buttonCekData);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        ButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kota kota = new Kota(namaKota.getText().toString());
                db.kotaDao().insertAll(kota);
                //Toast.makeText(CreateUser.this,"Data Berhasil Ditambahkan");
                namaKota.setText("");
                Toast.makeText(CreateKota.this,"Data Berhasil Ditambahkan",Toast.LENGTH_LONG).show();
            }
        });

        ButtonCekData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateKota.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
