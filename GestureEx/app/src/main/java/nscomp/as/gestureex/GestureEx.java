package nscomp.as.gestureex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by itani-hiroki on 2015/04/12.
 */
public class GestureEx extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GestureView(this));
    }

}
