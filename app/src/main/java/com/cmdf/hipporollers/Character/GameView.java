package com.cmdf.hipporollers.Character;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.cmdf.hipporollers.R;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    CharacterWalker characterNoHippo;
    Bitmap fullBar;
    Bitmap replay;
    EnergyBar threeBar;
    EnergyBar halfBar;
    EnergyBar endBar;


    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override // might have to be updated if all load at once
    public void surfaceCreated(SurfaceHolder holder) {
        characterNoHippo = new CharacterWalker(BitmapFactory.decodeResource(getResources(),
                R.drawable.woman_walking));
        fullBar = BitmapFactory.decodeResource(getResources(),
                R.drawable.full);
//        threeBar = new EnergyBar(BitmapFactory.decodeResource(getResources(),
//                R.drawable.three));
//        halfBar = new EnergyBar(BitmapFactory.decodeResource(getResources(),
//                R.drawable.half));
//        endBar = new EnergyBar(BitmapFactory.decodeResource(getResources(),
//                R.drawable.end));
        replay = BitmapFactory.decodeResource(getResources(),
                R.drawable.replay_button);
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
            canvas.drawBitmap(fullBar,700,100, null);
            canvas.drawBitmap(replay,700,1800, null);
            //fullBar.draw(canvas);

        }
    }
}
