package gmaps.com.gmaps.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Durga Prasad on 18-01-2017.
 */

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;

    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage("Loading...");
        progressDialog.show();

    }


    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
