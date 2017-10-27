package id.kataponcoe.theponcoeganteng;

/**
 * Created by Poncoe on 01/04/17.
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.TextView;

public class Halaman1 extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman1);

        TextView teks1;

        teks1=(TextView)findViewById(R.id.mulai);

        Typeface tampilan= Typeface.createFromAsset(getAssets(), "font/Roboto-Light.ttf");
        teks1.setTypeface(tampilan);

        findViewById(R.id.mulai).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        if (v.getId()==R.id.mulai){
            startActivity(new Intent(Halaman1.this, Halaman2.class));
        }
        else if (v.getId()==R.id.mulai){
            startActivity(new Intent(Halaman1.this, Halaman2.class));
        }

    }
}