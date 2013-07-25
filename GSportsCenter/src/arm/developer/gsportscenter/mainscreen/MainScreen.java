package arm.developer.gsportscenter.mainscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.content.SportClasses;
import arm.developer.gsportscenter.content.SportVenues;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainScreen extends SherlockActivity implements OnClickListener {

	private static final String TAG = "MainScreen";
	private Button btnSportVenues, btnSportClasses, btnGproShop, btnZoneCafe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen_layout);

		setFindView();

		setButton();

	}

	private void setFindView() {

		btnSportVenues = (Button) findViewById(R.id.btnSportVenues);
		btnSportClasses = (Button) findViewById(R.id.btnSportClasses);
		btnGproShop = (Button) findViewById(R.id.btnGproShop);
		btnZoneCafe = (Button) findViewById(R.id.btnZoneCafe);

	}

	private void setButton() {

		btnSportVenues.setOnClickListener(this);
		btnSportClasses.setOnClickListener(this);
		btnGproShop.setOnClickListener(this);
		btnZoneCafe.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.btnSportVenues:

			Intent iv = new Intent();
			iv.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			iv.setClass(MainScreen.this, SportVenues.class);
			startActivity(iv);

			break;

		case R.id.btnSportClasses:

			Intent ic = new Intent();
			ic.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			ic.setClass(MainScreen.this, SportClasses.class);
			startActivity(ic);

			break;

		case R.id.btnGproShop:

			Toast.makeText(MainScreen.this,
					"Clicked " + getApplicationContext(), Toast.LENGTH_SHORT)
					.show();

			break;

		case R.id.btnZoneCafe:

			Toast.makeText(MainScreen.this,
					"Clicked " + getApplicationContext(), Toast.LENGTH_SHORT)
					.show();

			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(100, 1001, 1, "Help").setIcon(R.drawable.ic_action_help)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add(100, 1002, 2, "About").setIcon(R.drawable.ic_action_info)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;

	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == 1001) {

			AlertDialog.Builder b = new AlertDialog.Builder(MainScreen.this);
			b.setCancelable(true);
			b.setTitle("Help");
			b.setMessage("This app will help you to get information about G Sports Center. "
					+ "Within this app, you can also make a reservation for every "
					+ "sport venues or apply for classes at The G Sports Center."
					+ "\n\nBeside making reservation, you can also browse product "
					+ "sold by G Pro Shop "
					+ "or food which available at Zone Cafe."
					+ "\n\nG SPORTS CENTER"
					+ "\nJl. Gajah Mada No. 105 B, Padang, Sumatera Barat"
					+ "\nTelp : 62751 40888 | Fax : 62751 40887");
			b.setNeutralButton("Close", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {

				}

			});

			b.show();

		}

		if (item.getItemId() == 1002) {

			AlertDialog.Builder d = new AlertDialog.Builder(MainScreen.this);
			d.setCancelable(true);
			d.setTitle("About");
			d.setMessage("This app is created and developed by damnedivan at"
					+ " Android Ranah Minang.\nAndroid Ranah Minang Developers."
					+ "\n\ndamnedivan\ntivanoedwin@gmail.com");
			d.setNeutralButton("Close", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {

				}

			});

			d.show();

		}

		return true;
	}

}
