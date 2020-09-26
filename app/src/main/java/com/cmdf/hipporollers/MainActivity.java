package com.cmdf.hipporollers;

import android.app.Activity;
//import android.content.Intent;
import android.os.Bundle;
//import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

//import com.cmdf.hipporollers.Character.GameView;
//import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;


//public class MainActivity extends AppCompatActivity {

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        // respond to menu item selection
//        switch (item.getItemId()) {
//            case R.id.about:
//                startActivity(new Intent(this, About.class));
//                return true;
//            case R.id.newGame:
//                startActivity(new Intent(this, GameView.class));
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    // SYD prior to Naadiya merge
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(new GameView(this));
//    }

}
