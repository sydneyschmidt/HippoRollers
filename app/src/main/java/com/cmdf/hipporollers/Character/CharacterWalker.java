package com.cmdf.hipporollers.Character;

// image from https://www.colourbox.com/vector/woman-carrying-water-silhouette-icon-vector-20444491

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.Button;

import com.cmdf.hipporollers.R;

public class CharacterWalker {
    private static final Color WHITE = new Color(225,225,225);

    private Bitmap image;
    private EnergyBar bar;
    private Button newGame;

    private String state;
    //private Canvas canvas = new Canvas();

    private int x;
    private int y;
    private int xV1 = 4; // may need to adjust
    private int xV2 = 3;
    private int xV3 = 2;
    private int xV4 = 1;

    private int width = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int height = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int quarter = width / 4;
    private int half = width / 2;
    private int three_quarter = width - quarter;


    public CharacterWalker(Bitmap bmp) {
        //newGame = new Button();
        image = bmp;
        state = "full";
        x = width; //starting coordinates
        y = height / 2;
    }

    public String getState() {
        return state;
    }

    public void draw(Canvas canvas) {
        canvas.drawRGB(255,255,255);
        canvas.drawBitmap(image, x, y, null);
        //canvas.drawBitmap();
        //bar.draw(canvas); //TODO: fix to add EnergyBar


    }

    public void update() {
        if (x < 0) {
            x = 0;
            y = height / 2;
            state = "end";
            //Button newGame = findViewById(R.id.newGame);
        }
        if (x <= quarter) {
            x -= xV4;
            state = "end";
        }
        if (x <= half) {
            x -= xV3;
            state = "half";
        }
        if (x <= three_quarter) {
            x -= xV2;
            state = "three";
        } else {
            x -= xV1;
            state = "full";
        }
    }
}
