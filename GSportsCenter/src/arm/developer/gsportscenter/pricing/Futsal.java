package arm.developer.gsportscenter.pricing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import arm.developer.gsportscenter.R;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class Futsal extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.pricing_futsal_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}

			TextView tvPricingGolf = (TextView) findViewById(R.id.overlayPricingFutsal);
			tvPricingGolf.setText(builder.toString());

		}

	}

	public static final String[] DIALOGUE = new String[] {

	"Jadwal:" + "\nSenin - Sabtu : 7.00 WIB – 01.00 WIB"
			+ "\nMinggu (Public Holiday) : 6.00 WIB – 01.00 WIB"
			+ "\nBiaya penyewaan Rp. 203.000,00 / jam / lapangan. Berlaku "
			+ "untuk paket Bulanan dan Corporate"

	};

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Futsal.this,
					arm.developer.gsportscenter.venues.Futsal.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		return true;
	}

}
