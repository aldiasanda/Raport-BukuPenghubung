package id.sch.smktelkom_mlg.project.xiirpl501112131.raportbukupenghubung_kelompok1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvEmail;
    private Button bLogout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        tvEmail = (TextView) findViewById(R.id.textViewUserEmail);

        if (user != null) {
            tvEmail.setText("Selamat Datang " + user.getEmail());
        }

        bLogout = (Button) findViewById(R.id.buttonLogut);

        bLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == bLogout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}

