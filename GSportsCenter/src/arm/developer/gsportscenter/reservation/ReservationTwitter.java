package arm.developer.gsportscenter.reservation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.content.SportVenues;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class ReservationTwitter extends SherlockActivity {

	private static final String TAG = "ReservationTwitter";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.reservation_twitter_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(610, 6101, 1, "Tweet").setIcon(R.drawable.ic_action_send)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(ReservationTwitter.this, SportVenues.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 6101) {

			Toast.makeText(ReservationTwitter.this,
					"Got Clicked" + getTaskId(), Toast.LENGTH_SHORT).show();
		}

		return super.onMenuItemSelected(featureId, item);
	}

}
