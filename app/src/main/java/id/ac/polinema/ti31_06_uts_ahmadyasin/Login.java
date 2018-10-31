package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText editUsername, editPassword;
    Button buttonLogin;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        sessionManagement = new SessionManagement(this);

        if(sessionManagement.isLoggedIn()){
            goToActivity();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                if(username.matches("") || username.trim().isEmpty() || password.matches("") || password.trim().isEmpty()){
                    Toast.makeText(Login.this,"Username dan Passsword Tidak Boleh Kosong / Space"
                            ,Toast.LENGTH_LONG).show();
                    return;
                }else {
                    sessionManagement.createLoginSession(username, password);
                    goToActivity();
                }
            }
        });
    }
    private void goToActivity() {
        Intent mIntent = new Intent(this, Home.class);
        startActivity(mIntent);
    }
}
