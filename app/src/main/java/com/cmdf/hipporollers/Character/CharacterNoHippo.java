package com.cmdf.hipporollers.Character;

// image from https://www.colourbox.com/vector/woman-carrying-water-silhouette-icon-vector-20444491

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterNoHippo {

    private Bitmap image;
    private int x;
    private int y;

    public CharacterNoHippo(Bitmap bmp) {
        image = bmp;
        x = 100; //starting coordinates
        y = 100;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update() {
        x++; //moving right
        y++; // moving down
    }
}
