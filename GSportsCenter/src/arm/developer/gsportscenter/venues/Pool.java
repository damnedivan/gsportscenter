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

public class Pool extends SherlockActivity {

	private static final String TAG = "Pool";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.venues_pool_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}
		}

		TextView tvVenuesPool = (TextView) findViewById(R.id.overlayPool);
		tvVenuesPool.setText(builder.toString());

	}

	public static final String[] DIALOGUE = new String[] {

			"G Sports Center memiliki 1 Kolam renang utama Semi Olimpic Size "
					+ "dengan luas 25x 12.5 m2 dan dengan kedalaman 1.6 m –2.5 m.",

			"Tersedia juga 1 Kolam renang untuk anak dengan luas 10 x 10 m2 "
					+ "dan kedalaman 0.9 m.",

			"Untuk kenyamanan dan keamanan anda, tersedia pula penyewaan Handuk "
					+ "dan Pelampung Renang serta penjagaan Lifeguard."

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(230, 2301, 1, "Pricing").setIcon(R.drawable.ic_action_info)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add(230, 2302, 2, "Reservation")
				.setIcon(R.drawable.ic_action_reservation)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Pool.this, VenuesTable.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2301) {

			Intent i = new Intent();
			i.setClass(Pool.this,
					arm.developer.gsportscenter.pricing.Pool.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		if (item.getItemId() == 2302) {

			Intent i = new Intent();
			i.setClass(Pool.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return true;
	}

}