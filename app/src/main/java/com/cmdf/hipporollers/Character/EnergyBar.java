package com.cmdf.hipporollers.Character;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;


public class EnergyBar {
    private CharacterWalker walker;

    private Bitmap full;
    private Bitmap three;
    private Bitmap half;
    private Bitmap end;


    private int x;
    private int y;

    private int width = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int height = Resources.getSystem().getDisplayMetrics().heightPixels;


    public EnergyBar(Bitmap bmp) {
        full = bmp;
        x = width - 100 ; //starting coordinates //TODO: update position
        y = height - 50;
    }

    public void draw(Canvas canvas) {
        if (walker.getState().equals(new String("full"))) {
            canvas.drawBitmap(full, x, y, null);
        }
        if (walker.getState().equals(new String("three"))) {
            canvas.drawBitmap(three, x, y, null);
        }
        if (walker.getState().equals(new String("half"))) {
            canvas.drawBitmap(half, x, y, null);
        } else {
            canvas.drawBitmap(end, x, y, null);
        }
    }

//    public void updateBar() {
//        draw(canvas);
//    }
}
