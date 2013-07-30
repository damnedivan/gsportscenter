package arm.developer.gsportscenter.content;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.mainscreen.MainScreen;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class ClassesTable extends SherlockActivity {

	private UITableView tabView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.table_classes_layout);

		tabView = (UITableView) findViewById(R.id.tabViewClasses);

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

				Toast.makeText(ClassesTable.this,
						"Got Clicked" + getPackageCodePath(),
						Toast.LENGTH_SHORT).show();

			}

			else if (index == 1) {

				Toast.makeText(ClassesTable.this,
						"Got Clicked" + getPackageCodePath(),
						Toast.LENGTH_SHORT).show();

			}

			else if (index == 2) {

				Toast.makeText(ClassesTable.this,
						"Got Clicked" + getPackageCodePath(),
						Toast.LENGTH_SHORT).show();

			}

			else if (index == 3) {

				Toast.makeText(ClassesTable.this,
						"Got Clicked" + getPackageCodePath(),
						Toast.LENGTH_SHORT).show();

			}

			else if (index == 4) {

				Toast.makeText(ClassesTable.this,
						"Got Clicked" + getPackageCodePath(),
						Toast.LENGTH_SHORT).show();

			}

			else if (index == 5) {

				Toast.makeText(ClassesTable.this,
						"Got Clicked" + getPackageCodePath(),
						Toast.LENGTH_SHORT).show();

			}

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(ClassesTable.this, MainScreen.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		return super.onMenuItemSelected(featureId, item);
	}

}