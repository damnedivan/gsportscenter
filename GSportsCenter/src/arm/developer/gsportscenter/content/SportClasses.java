package arm.developer.gsportscenter.content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import arm.developer.gsportscenter.listadapter.VenuesListAdapter;
import arm.developer.gsportscenter.mainscreen.MainScreen;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;

public class SportClasses extends SherlockListActivity {

	static final String[] SPORT_CLASSES = new String[] { "Golf Simulator",
			"Futsal", "Swimming", "Badminton", "Fitness" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		setListAdapter(new VenuesListAdapter(this, SPORT_CLASSES));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, "Got click: " + selectedValue, Toast.LENGTH_SHORT)
				.show();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case android.R.id.home:
			Intent intent = new Intent(this, MainScreen.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);

			break;
		}

		return true;
	}

}