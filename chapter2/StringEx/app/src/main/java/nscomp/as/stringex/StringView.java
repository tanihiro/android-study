package nscomp.as.stringex;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by itani-hiroki on 2015/04/11.
 */
public class StringView extends View {

    public StringView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        paint.setTextSize(48);
        paint.setColor(Color.rgb(0, 0, 0));

        canvas.drawText("画面サイズ: " + getWidth() + "x" + getHeight(), 0, 60, paint);

        canvas.drawText("文字幅: " + (int)paint.measureText("A"), 0, 60*2, paint);

        canvas.drawText("アセント: " + (int)paint.ascent(), 0, 60*3, paint);
        canvas.drawText("ディセント" + (int)paint.descent(), 0, 60*4, paint);

        paint.setTextSize(24);
        paint.setColor(Color.rgb(255, 0, 0));
        canvas.drawText("24dot", 0, 60*5, paint);

        paint.setTextSize(32);
        paint.setColor(Color.rgb(0, 255, 0));
        canvas.drawText("32dot", 0, 60*6, paint);

        paint.setTextSize(48);
        paint.setColor(Color.rgb(0, 0, 255));
        canvas.drawText("48dot", 0, 60*7, paint);
    }
}
