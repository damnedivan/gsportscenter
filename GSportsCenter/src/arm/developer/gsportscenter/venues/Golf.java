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

public class Golf extends SherlockActivity {

	private static final String TAG = "GolfSimulator";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.venues_golf_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}

			TextView tvVenueGolf = (TextView) findViewById(R.id.overlayGolf);
			tvVenueGolf.setText(builder.toString());

		}

	}

	public static final String[] DIALOGUE = new String[] {
			"Merupakan yang pertama di Kota Padang dan Sumatera, luas area 175 M2, "
					+ "ruangan ber AC, sofa dan meja minuman, kualitas fitting studio dan "
					+ "sistim terbaik, tidak terhalang dengan faktor jarak, waktu dan cuaca "
					+ "jika dibandingkan dengan permainan golf dilapangan. Untuk kenyamanan "
					+ "tamu atau member GSC tersedia beberapa Golf Club untuk dipinjamkan.",

			"The First Commercial Use in Indonesia: Full Swing Golf, PGA Certified "
					+ "Golf Simulators, more than 96% accuracy. Simulator yang satu ini "
					+ "menawarkan permainan golf simulator yang hampir sama dengan permainan "
					+ "asli. Untuk pemasangan game simulator ini dibutuhkan ruangan dengan "
					+ "ukuran 6m(panjang) x 4m(lebar) x 3m(tinggi). Sedangkan untuk software "
					+ "menggunakan basis dari sistim operasi Windows dan penggunaan high "
					+ "definition video projector yang akan membuat permainan menjadi lebih "
					+ "realistis. Full Swing Golf Simulator juga mempunyai fitur Club Fitting "
					+ "untuk turnamen dan engine grafik termuktahir yang pernah ada saat ini."

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(210, 2101, 1, "Pricing").setIcon(R.drawable.ic_action_info)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add(210, 2102, 2, "Reservation")
				.setIcon(R.drawable.ic_action_reservation)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Golf.this, SportVenues.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2101) {

			Intent i = new Intent();
			i.setClass(Golf.this,
					arm.developer.gsportscenter.pricing.Golf.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		if (item.getItemId() == 2102) {

			Intent i = new Intent();
			i.setClass(Golf.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return true;
	}

}
