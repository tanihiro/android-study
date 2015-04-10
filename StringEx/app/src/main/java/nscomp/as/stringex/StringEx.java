package nscomp.as.stringex;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by itani-hiroki on 2015/04/11.
 */
public class StringEx extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new StringView(this));
    }
}
