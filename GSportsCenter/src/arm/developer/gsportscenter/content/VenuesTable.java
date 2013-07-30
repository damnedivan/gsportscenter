package arm.developer.gsportscenter.content;

import android.content.Intent;
import android.os.Bundle;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.mainscreen.MainScreen;
import arm.developer.gsportscenter.reservation.Reservation;
import arm.developer.gsportscenter.venues.Aerobic;
import arm.developer.gsportscenter.venues.Badminton;
import arm.developer.gsportscenter.venues.Futsal;
import arm.developer.gsportscenter.venues.Golf;
import arm.developer.gsportscenter.venues.Gym;
import arm.developer.gsportscenter.venues.Pool;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class VenuesTable extends SherlockActivity {

	private UITableView tabView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.table_venues_layout);

		tabView = (UITableView) findViewById(R.id.tabViewVenues);

		createList();

		com.actionbarsherlock.app.ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

	}

	private void createList() {
		TableClickListener l = new TableClickListener();
		tabView.setClickListener(l);
		tabView.addBasicItem("Golf Simulator");
		tabView.addBasicItem("Futsal");
		tabView.addBasicItem("Swimming Pool & Whirlpool");
		tabView.addBasicItem("Badminton");
		tabView.addBasicItem("Gym");
		tabView.addBasicItem("Aerobic");
		tabView.commit();

	}

	private class TableClickListener implements ClickListener {

		@Override
		public void onClick(int index) {

			if (index == 0) {

				Intent i = new Intent();
				i.setClass(VenuesTable.this, Golf.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);

			}

			else if (index == 1) {

				Intent i = new Intent();
				i.setClass(VenuesTable.this, Futsal.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);

			}

			else if (index == 2) {

				Intent i = new Intent();
				i.setClass(VenuesTable.this, Pool.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);

			}

			else if (index == 3) {

				Intent i = new Intent();
				i.setClass(VenuesTable.this, Badminton.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);

			}

			else if (index == 4) {

				Intent i = new Intent();
				i.setClass(VenuesTable.this, Gym.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);

			}

			else if (index == 5) {

				Intent i = new Intent();
				i.setClass(VenuesTable.this, Aerobic.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);

			}

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

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(VenuesTable.this, MainScreen.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 2001) {

			Intent i = new Intent();
			i.setClass(VenuesTable.this, Reservation.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);

		}

		return super.onMenuItemSelected(featureId, item);
	}

}
