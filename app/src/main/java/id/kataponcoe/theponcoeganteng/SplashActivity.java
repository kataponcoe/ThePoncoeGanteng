package id.kataponcoe.theponcoeganteng;

/**
 * Created by Poncoe on 01/04/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

    //Set waktu lama splashscreen
    private static int splashInterval = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Yang dibawah ini digunain buat ngilangin yang nama aplikasinya di layar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // yang ini dipake buat jadiin tampilan jadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginAcitivty.class);
                startActivity(i);


                //kalo udah sampe 4 detik (splashInterval) splashscreen akan selesai dan dilanjut ke form login
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    };

}