package nscomp.as.imageex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by itani-hiroki on 2015/04/11.
 */
public class ImageView extends View {
    private Bitmap image;

    public ImageView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);

        Resources r = context.getResources();
        image = BitmapFactory.decodeResource(r, R.drawable.profile);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);

        int w = image.getWidth();
        int h = image.getHeight();
        Rect src = new Rect(0, 0, w, h);
        Rect dist = new Rect(0, 300, w*2, 300+h*2);
        canvas.drawBitmap(image, src, dist, null);
    }
}
