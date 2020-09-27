package com.cmdf.hipporollers.Character;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.cmdf.hipporollers.R;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    CharacterNoHippo characterNoHippo;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        characterNoHippo = new CharacterNoHippo(BitmapFactory.decodeResource(getResources(),
                R.drawable.tempimg));

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() { // calculations for movement
        characterNoHippo.update();
    }

    @Override
    public void draw (Canvas canvas) {
        super.draw(canvas);
        if(canvas!=null) {
            characterNoHippo.draw(canvas);
        }
    }
}