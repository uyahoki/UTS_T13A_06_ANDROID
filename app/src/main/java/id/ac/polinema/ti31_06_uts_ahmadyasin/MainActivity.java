package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonKembali = findViewById(R.id.buttonKembali);
        recyclerView = findViewById(R.id.recycler_view);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        List<Kota> kotas = db.kotaDao().getAllUsers();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new KotaAdapter(kotas);
        recyclerView.setAdapter(adapter);

        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateKota.class);
                startActivity(intent);
            }
        });
    }
}
