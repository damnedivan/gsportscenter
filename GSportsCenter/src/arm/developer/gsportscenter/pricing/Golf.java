package arm.developer.gsportscenter.pricing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import arm.developer.gsportscenter.R;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class Golf extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.pricing_golf_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			for (String dialog : DIALOGUE) {
				builder.append(dialog).append("\n\n");
			}

			TextView tvPricingGolf = (TextView) findViewById(R.id.overlayPricingGolf);
			tvPricingGolf.setText(builder.toString());

		}

	}

	public static final String[] DIALOGUE = new String[] {

			"Harga Reguler:" + "\n07.00 WIB – 15.00 WIB : Rp. 103.000,-/ jam"
					+ "\n16.00 WIB – 24.00 WIB : Rp. 203.000,-/ jam",

			"Harga VIP Room:" + "\n07.00 WIB – 15.00 WIB : Rp. 128.000,-/ jam"
					+ "\n16.00 WIB – 24.00 WIB : Rp. 253.000,-/ jam",

			"Paket 1 Bulan:"
					+ "\nBay Room : Rp. 2.303.000,-"
					+ "\nVIP Room : Rp. 2.853.000,-"
					+ "\nKeuntungan:"
					+ "\n- Durasi minimal 3 (tiga) jam tiap minggunya (jadwal menyesuaikan)"
					+ "\n- Mendapatkan voucher free Swimming + whirlpool untuk satu orang untuk satu kali pemakaian",

			"Paket 3 Bulan"
					+ "\nBay Room : Rp. 5.403.000,-"
					+ "\nVIP Room : Rp. 7.203.000,-"
					+ "\nKeuntungan:"
					+ "\n- Durasi minimal 3 (tiga) jam tiap minggunya (jadwal menyesuaikan)"
					+ "\n- Mendapatkan free swimming + whirlpool untuk dua orang untuk satu kali pemakaian",

			"Paket 6 Bulan"
					+ "\nBiaya : Rp. 7.503.000,-"
					+ "\nKeuntungan:"
					+ "\n- Valid untuk 1 (satu) orang saja (tidak bisa untuk pemakaian group)"
					+ "\n- Unlimited playing time"
					+ "\n- Pilihan memakai Bay Room atau VIP Room (jadwal menyesuaikan)"
					+ "\n- 10% FB product",

			"Paket 12 Bulan"
					+ "\nBiaya : Rp. 12.003.000,-"
					+ "\nKeuntungan:"
					+ "\n- Valid untuk 1 (satu) orang saja (tidak bisa untuk pemakaian group)"
					+ "\n- Unlimited playing time"
					+ "\n- Pilihan memakai Bay Room atau VIP Room (jadwal menyesuaikan)"
					+ "\n- 15% FB product"

	};

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Golf.this, arm.developer.gsportscenter.venues.Golf.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		return true;
	}

}
