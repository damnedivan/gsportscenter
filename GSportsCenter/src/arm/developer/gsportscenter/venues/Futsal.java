package arm.developer.gsportscenter.venues;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.content.SportVenues;
import arm.developer.gsportscenter.reservation.Reservation;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Futsal extends SherlockActivity {

	private static final String TAG = "Futsal";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.venues_futsal_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}
		}

		TextView tvVenuesFutsal = (TextView) findViewById(R.id.overlayFutsal);
		tvVenuesFutsal.setText(builder.toString());

	}

	public static final String[] DIALOGUE = new String[] {

			"G Sports Center memiliki 2 (dua) Lapangan futsal dengan "
					+ "ukuran sesuai dengan Standar FIFA yaitu: 27.5 m x 16.5 m.",

			"Lapangan Futsal G Sports Center berkualitas tinggi dengan "
					+ "permukaan lapangan: halus, rata, dan tak abrasive.",

			"Material lapangan futsal G Sports Center juga telah menggunakan "
					+ "bahan Gerflor Taraflex sesuai dengan standar FIFA (Federation "
					+ "Internationale de Football Association)."

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(220, 2201, 1, "Pricing").setIcon(R.drawable.ic_action_info)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add(220, 2202, 2, "Reservation")
				.setIcon(R.drawable.ic_action_reservation)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Futsal.this, SportVenues.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2201) {

			Intent i = new Intent();
			i.setClass(Futsal.this,
					arm.developer.gsportscenter.pricing.Futsal.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		if (item.getItemId() == 2202) {

			Intent i = new Intent();
			i.setClass(Futsal.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return true;
	}

}