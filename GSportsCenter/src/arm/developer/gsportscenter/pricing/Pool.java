package arm.developer.gsportscenter.pricing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import arm.developer.gsportscenter.R;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class Pool extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.pricing_pool_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}

			TextView tvPricingGolf = (TextView) findViewById(R.id.overlayPricingPool);
			tvPricingGolf.setText(builder.toString());

		}

	}

	public static final String[] DIALOGUE = new String[] {

			"Jadwal:" + "\nSenin – Sabtu" + "\nSesi 1 : 8.00 WIB – 12.00 WIB"
					+ "\nSesi 2 : 16.00 WIB – 21.00 WIB",

			"Minggu (Public Holiday)" + "\nSesi 1 : 06.00 WIB – 12.00 WIB"
					+ "\nSesi 2 : 16.00 WIB – 21.00 WIB",

			"Tiket masuk swimmingpool:" + "\nDewasa : Rp. 63.000,00"
					+ "\nAnak-anak (<12 tahun) : Rp. 33.000,00",

			"Paket swimmingpool-whirlpool:" + "\nBiaya: Rp. 83.000,00"
					+ "\n- mendapatkan peminjaman handuk dan minuman gratis"

	};

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Pool.this, arm.developer.gsportscenter.venues.Pool.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		return true;
	}

}