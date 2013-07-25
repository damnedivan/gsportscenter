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

public class Aerobic extends SherlockActivity {

	private static final String TAG = "Aerobic";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.venues_aerobic_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}

			TextView tvVenuesAerobic = (TextView) findViewById(R.id.overlayAerobic);
			tvVenuesAerobic.setText(builder.toString());

		}

	}

	public static final String[] DIALOGUE = new String[] {

			"G Sport Center dilengkapi dengan fasilitas ruangan aerobic "
					+ "(aerobic studio) yang luas, nyaman dengan fasilitas lengkap.",

			"Fasilitas ruangan aerobik ini seluas 95 M2 dengan lantai "
					+ "mempergunakan bahan Vinyl corak kayu serta fasilitas RPM sebanyak "
					+ "18 buah yang terletak pada ruangan berukuran 70 M2dengan lantai "
					+ "mempergunakan bahan Mezanine. Fasilitas ini dibuka sepanjang tahun "
					+ "dengan kelas - kelas aerobic yang bervariasi.",

			"Pakar - pakar kami akan merancang program - program aerobic yang "
					+ "sesuai dengan kebutuhan anda mulai dari pemula, sampai tingkat advance.",

			"Bergabungkah bersama kami dan nikmati fasilitas ini sekarang juga."

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(260, 2601, 1, "Pricing").setIcon(R.drawable.ic_action_info)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add(260, 2602, 2, "Reservation")
				.setIcon(R.drawable.ic_action_reservation)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Aerobic.this, SportVenues.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2601) {

			Intent i = new Intent();
			i.setClass(Aerobic.this,
					arm.developer.gsportscenter.pricing.Golf.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		if (item.getItemId() == 2602) {

			Intent i = new Intent();
			i.setClass(Aerobic.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return true;
	}

}