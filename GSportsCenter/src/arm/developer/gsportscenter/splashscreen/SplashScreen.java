package arm.developer.gsportscenter.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.mainscreen.MainScreen;

public class SplashScreen extends Activity {

	private static final int SPLASH_DISPLAY_TIME = 3000;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		new Handler().postDelayed(new Runnable() {

			public void run() {

				Intent i = new Intent();
				i.setClass(SplashScreen.this, MainScreen.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);

				SplashScreen.this.finish();
				overridePendingTransition(R.anim.fade_in_anim,
						R.anim.fade_out_anim);
			}
		}, SPLASH_DISPLAY_TIME);
	}
}