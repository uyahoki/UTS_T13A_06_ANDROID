package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Home extends AppCompatActivity {

    SessionManagement sessionManagement;
    TextView tvUsername;
    Button buttonLogout, buttonDatabase;
    HashMap<String,String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonDatabase = (Button) findViewById(R.id.buttonDatabase);

        sessionManagement = new SessionManagement(this);
        loginUser = sessionManagement.getUserInformation();

        Toast.makeText(this,sessionManagement.isLoggedIn()+"",Toast.LENGTH_LONG).show();

        tvUsername.setText("Selamat Datang " + loginUser.get(sessionManagement.KEY_USERNAME));

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });

        buttonDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CreateKota.class);
                startActivity(intent);
            }
        });
    }
}
