package com.sneakyapps.alan;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    int numtest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loads up the advieww
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ImageView alanbutton = (ImageView) findViewById(R.id.alanbutton);
        assert alanbutton != null;
        alanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alanrandom();
                numtest += 1;
                TextView addnumber = (TextView) findViewById(R.id.counter);
                addnumber.setText(numtest + "");

            }
        });

    }


    public void alanrandom() {
        //list of sounds
        int[] sounds = {R.raw.al1, R.raw.al2, R.raw.al3, R.raw.al4, R.raw.al5, R.raw.al6,
                R.raw.al7, R.raw.al8, R.raw.al9, R.raw.al10, R.raw.st1,};

        //random int generator, change int High to the total amount of sounds you have in your R.raw folder
        Random r = new Random();
        int Low = 0;
        int High = 11;
        final MediaPlayer mp1;
        int rndm = r.nextInt(High - Low) + Low;
        mp1 = MediaPlayer.create(getApplicationContext(), sounds[rndm]);
        mp1.start();


        //sets listener to free the mediaplayer once the sound has completed
        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp1.release();
            }
        });


    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
