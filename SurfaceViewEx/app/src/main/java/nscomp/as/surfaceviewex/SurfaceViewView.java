package nscomp.as.surfaceviewex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by itani-hiroki on 2015/04/12.
 */
public class SurfaceViewView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder holder;
    private Thread thread;

    private Bitmap image;
    private int px = 0; // x座標
    private int py = 0; // y座標
    private int vx = 6; // x速度
    private int vy = 6; // y速度

    public SurfaceViewView(Context context) {
        super(context);

        Resources r = getResources();
        image = BitmapFactory.decodeResource(r, R.drawable.profile_thumb);

        // サーフェイスホルダーの生成
        holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread = null;
    }

    @Override
    public void run() {
        while (thread != null) {
            long nextTime = System.currentTimeMillis()+30;
            onTick();
            try {
                Thread.sleep(nextTime-System.currentTimeMillis());
            } catch (Exception e) {
            }
        }
    }

    private void onTick() {
        Canvas canvas = holder.lockCanvas();
        if (canvas == null) return;
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(image, px-120, py-120, null);
        holder.unlockCanvasAndPost(canvas);

        if (px < 0 || getWidth() < px) vx = -vx;
        if (py < 0 || getHeight() < py) vy = -vy;
        px += vx;
        py += vy;
    }
}
