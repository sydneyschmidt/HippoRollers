package com.cmdf.hipporollers.Character;

// image from https://www.colourbox.com/vector/woman-carrying-water-silhouette-icon-vector-20444491

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterWalker {
    private Bitmap image;
    private EnergyBar bar;

    private String state;

    private int x;
    private int y;
    private int xV1 = 10; // may need to adjust
    private int xV2 = 7;
    private int xV3 = 5;
    private int xV4 = 3;

    private int width = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int height = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int quarter = width / 4;
    private int half = width / 2;
    private int three_quarter = width - quarter;


    public CharacterWalker(Bitmap bmp) {
        image = bmp;
        state = "f";
        x = width; //starting coordinates
        y = height / 2;
    }

    public String getState() {
        return state;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
        //bar.updateBar(); //TODO: fix to add EnergyBar


    }

    public void update() {
        if (x < 0) {
            x = 0;
            y = height / 2;
            state = "end";
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
