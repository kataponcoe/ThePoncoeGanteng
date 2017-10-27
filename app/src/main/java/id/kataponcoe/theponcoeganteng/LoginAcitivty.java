package id.kataponcoe.theponcoeganteng;

/**
 * Created by Poncoe on 01/04/17.
 */


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAcitivty extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Yang dibawah ini digunain buat ngilangin yang nama aplikasinya di layar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // yang ini dipake buat jadiin tampilan jadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.login_activity);

        setupVariables();
    }

    private EditText username;
    private EditText password;
    private Button login;
    private TextView loginLockedTV;
    private TextView attemptsLeftTV;
    private TextView numberOfRemainingLoginAttemptsTV;

    // Dipake Buat ngasi kesempatan login, ya dikasi kesempatan cuma 3x bisa sih diganti, bebas mau berapa aja
    int numberOfRemainingLoginAttempts = 3;

    // Disini tempat lu ngatur Nama Pengguna dan Kata Sandi
    public void authenticateLogin(View view) {
        //Username.getText dipake buat nginput Username nya apa
        if (username.getText().toString().equals("kataponcoe") &&
                //dan ini buat ngimput passwordnya apa
                password.getText().toString().equals("poncoeganteng")) {
            //kalo berhasil login ya masuk ke form halaman 1
            startActivity(new Intent(this, Halaman1.class));
            //kalo salah ya bakalan muncul "salah terus, apa hayoo!"
        } else {
            Toast.makeText(getApplicationContext(), "Salah Terus, Apa Hayo!!",
                    Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;
            attemptsLeftTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));

            // jika lebih dari 3x ya login bakalan kekunci dan gabisa login lagi
            if (numberOfRemainingLoginAttempts == 0) {
                login.setEnabled(false);
                loginLockedTV.setVisibility(View.VISIBLE);
                loginLockedTV.setBackgroundColor(Color.RED);
                loginLockedTV.setText("MAMPUS. LOGIN GW KUNCI!!!");
            }
        }
    }

    private void setupVariables() {
        username = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordET);
        login = (Button) findViewById(R.id.loginBtn);
        loginLockedTV = (TextView) findViewById(R.id.loginLockedTV);
        attemptsLeftTV = (TextView) findViewById(R.id.attemptsLeftTV);
        numberOfRemainingLoginAttemptsTV = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
        numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
    }

    // on backpress di pake ya buat tombol fitur kembali di android
    public void onBackPressed() {
        // finish ya kodingan keluar dari app android, ibaratkan vb End
        finish();
    }
}