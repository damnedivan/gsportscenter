package arm.developer.gsportscenter.venues;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.content.VenuesTable;
import arm.developer.gsportscenter.reservation.Reservation;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Badminton extends SherlockActivity {

	private static final String TAG = "Badminton";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.venues_badminton_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}
		}

		TextView tvVenuesBadminton = (TextView) findViewById(R.id.overlayBadminton);
		tvVenuesBadminton.setText(builder.toString());

	}

	public static final String[] DIALOGUE = new String[] {

			"G Sport Center dilengkapi dengan lapangan bulu tangkis "
					+ "(Badminton) dengan luas 25 x 60 x 7 m3 (3 lapangan). "
					+ "Lapangan ini dibuat sesuai dengan standar BWF (Badminton "
					+ "World Federation) berbentuk persegi panjang, terbuat dari "
					+ "material Gerflor Taraflex dengan ketebalan 5mm/7mm.",

			"Perlengkapan yang disediakan oleh G Sport Center untuk "
					+ "fasilitas badminton adalah antara lain: Peminjaman Raket "
					+ "dengan gratis serta free 1 shuttlecock per Game.",

			"Jika pemain memerlukan shuttlecock tambahan, dapat dibeli "
					+ "di G Pro Shop dengan jumlah sesuai kebutuhan pemain."

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(240, 2401, 1, "Pricing").setIcon(R.drawable.ic_action_info)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add(240, 2402, 2, "Reservation")
				.setIcon(R.drawable.ic_action_reservation)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Badminton.this, VenuesTable.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2401) {

			Intent i = new Intent();
			i.setClass(Badminton.this,
					arm.developer.gsportscenter.pricing.Golf.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		if (item.getItemId() == 2402) {

			Intent i = new Intent();
			i.setClass(Badminton.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return true;
	}

}