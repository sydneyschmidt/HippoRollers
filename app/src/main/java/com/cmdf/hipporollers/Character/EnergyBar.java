package com.cmdf.hipporollers.Character;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.cmdf.hipporollers.R;


public class EnergyBar {
    private CharacterWalker walker;

    private Bitmap image;
    //private Bitmap full = BitmapFactory.decodeResource(getResources(), R.drawable.full);
    private Bitmap three;
    private Bitmap half;
    private Bitmap end;


    private int x;
    private int y;

    private int width = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int height = Resources.getSystem().getDisplayMetrics().heightPixels;


    public EnergyBar(Bitmap bmp) {
        image = bmp;

        //full = BitmapFactory.decodeResource(getResources(), R.drawable.full);
//        fullBar = new EnergyBar(BitmapFactory.decodeResource(getResources(),
//                R.drawable.full));
//        threeBar = new EnergyBar(BitmapFactory.decodeResource(getResources(),
//                R.drawable.three));
//        halfBar = new EnergyBar(BitmapFactory.decodeResource(getResources(),
//                R.drawable.half));
//        endBar = new EnergyBar(BitmapFactory.decodeResource(getResources(),
//                R.drawable.end));
        x = width - 100 ; //starting coordinates //TODO: update position
        y = height - 50;
    }

    public void draw(Canvas canvas) {
        if (walker.getState().equals(new String("full"))) {
            //image = new BitmapFactory.decodeResource(getResources(), R.drawable.full);
            canvas.drawBitmap(image, x, y, null);
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
