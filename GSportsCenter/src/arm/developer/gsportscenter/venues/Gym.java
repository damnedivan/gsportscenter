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

public class Gym extends SherlockActivity {

	private static final String TAG = "Gym";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.venues_gym_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}
		}

		TextView tvVenuesGym = (TextView) findViewById(R.id.overlayGym);
		tvVenuesGym.setText(builder.toString());

	}

	public static final String[] DIALOGUE = new String[] {

			"G Sport Center Gym memiliki ruangan fitness berukuran "
					+ "255 M2 dengan lantai mempergunakan bahan Vinylcorak kayu, "
					+ "serta dilengkapi juga dengan fasilitas LCD TV dan full sound system.",

			"Fasilitas ini dilengkapi dengan Full Range Equipments dari "
					+ "merek Cybexdan Body Solid.",

			"G Sport Center Gym juga didukung oleh para Certified Trainers "
					+ "yang profesional dan selalu siap untuk membantu dan "
					+ "menjelaskan secara rinci tatacara penggunaan alat yang "
					+ "terdapat dalam ruangan fitnes ini."

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(250, 2501, 1, "Pricing").setIcon(R.drawable.ic_action_info)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add(250, 2502, 2, "Reservation")
				.setIcon(R.drawable.ic_action_reservation)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Gym.this, SportVenues.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2501) {

			Intent i = new Intent();
			i.setClass(Gym.this,
					arm.developer.gsportscenter.pricing.Golf.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		if (item.getItemId() == 2502) {

			Intent i = new Intent();
			i.setClass(Gym.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return true;
	}

}