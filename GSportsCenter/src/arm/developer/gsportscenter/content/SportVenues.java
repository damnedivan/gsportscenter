package arm.developer.gsportscenter.content;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.listadapter.VenuesListAdapter;
import arm.developer.gsportscenter.mainscreen.MainScreen;
import arm.developer.gsportscenter.reservation.Reservation;
import arm.developer.gsportscenter.venues.Aerobic;
import arm.developer.gsportscenter.venues.Badminton;
import arm.developer.gsportscenter.venues.Futsal;
import arm.developer.gsportscenter.venues.Golf;
import arm.developer.gsportscenter.venues.Gym;
import arm.developer.gsportscenter.venues.Pool;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class SportVenues extends SherlockListActivity {

	private static final String TAG = "SportVenues";

	static final String[] SPORT_VENUES = new String[] { "Golf Simulator",
			"Futsal", "Swimming Pool & Whirlpool", "Badminton", "Gym",
			"Aerobic" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		setListAdapter(new VenuesListAdapter(this, SPORT_VENUES));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		switch (position) {

		case 0:

			Intent intentGolf = new Intent(this, Golf.class);
			startActivity(intentGolf);

			break;

		case 1:

			Intent intentFutsal = new Intent(this, Futsal.class);
			startActivity(intentFutsal);

			break;

		case 2:

			Intent intentPool = new Intent(this, Pool.class);
			startActivity(intentPool);

			break;

		case 3:

			Intent intentBadminton = new Intent(this, Badminton.class);
			startActivity(intentBadminton);

			break;

		case 4:

			Intent intentGym = new Intent(this, Gym.class);
			startActivity(intentGym);

			break;

		case 5:

			Intent intentAerobic = new Intent(this, Aerobic.class);
			startActivity(intentAerobic);

			break;

		default:

			break;

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(200, 2001, 1, "Reservasi")
				.setIcon(R.drawable.ic_action_reservation)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(SportVenues.this, MainScreen.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2001) {

			Intent i = new Intent();
			i.setClass(SportVenues.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return super.onMenuItemSelected(featureId, item);
	}

}