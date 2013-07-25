package arm.developer.gsportscenter.reservation;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import arm.developer.gsportscenter.R;
import arm.developer.gsportscenter.arrayadapter.AdapterDurasi;
import arm.developer.gsportscenter.arrayadapter.AdapterJam;
import arm.developer.gsportscenter.arrayadapter.AdapterVenues;
import arm.developer.gsportscenter.content.SportVenues;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Reservation extends SherlockActivity {

	private static final String TAG = "Reservation";
	private EditText etNama, etAlamat, etTelepon;
	private TextView tvTanggal;
	private Button btnTanggal;
	private Spinner spnVenues, spnJam, spnDurasi;
	private int mYear;
	private int mMonth;
	private int mDay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.reservation_layout);

		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);

		findView();

		setAdapter();

		btnTanggal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new DatePickerDialog(Reservation.this, mDateSetListener, mYear,
						mMonth, mDay).show();

			}

		});

		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		updateDisplay();

	}

	private void findView() {

		etNama = (EditText) findViewById(R.id.etNama);
		etAlamat = (EditText) findViewById(R.id.etAlamat);
		etTelepon = (EditText) findViewById(R.id.etTelpon);
		tvTanggal = (TextView) findViewById(R.id.tvTanggal);
		btnTanggal = (Button) findViewById(R.id.btnTanggal);
		spnVenues = (Spinner) findViewById(R.id.spnVenues);
		spnJam = (Spinner) findViewById(R.id.spnJam);
		spnDurasi = (Spinner) findViewById(R.id.spnDurasi);

	}

	private void setAdapter() {

		ArrayAdapter<AdapterVenues> spnVenuesAdapter = new ArrayAdapter<AdapterVenues>(
				this, android.R.layout.simple_spinner_item,
				AdapterVenues.values());
		spnVenuesAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnVenues.setAdapter(spnVenuesAdapter);

		ArrayAdapter<AdapterJam> spnJamAdapter = new ArrayAdapter<AdapterJam>(
				this, android.R.layout.simple_spinner_item, AdapterJam.values());
		spnJamAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnJam.setAdapter(spnJamAdapter);

		ArrayAdapter<AdapterDurasi> spnDurAdapter = new ArrayAdapter<AdapterDurasi>(
				this, android.R.layout.simple_spinner_item,
				AdapterDurasi.values());
		spnDurAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnDurasi.setAdapter(spnDurAdapter);

	}

	private void updateDisplay() {
		tvTanggal.setText(new StringBuilder().append(mMonth + 1).append("-")
				.append(mDay).append("-").append(mYear).append(" "));
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(600, 6002, 2, "Send").setIcon(R.drawable.ic_action_send)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.d(TAG, Integer.toString(item.getItemId()));

		if (item.getItemId() == android.R.id.home) {

			Intent i = new Intent();
			i.setClass(Reservation.this, SportVenues.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);

		}

		if (item.getItemId() == 6002) {

			AlertDialog.Builder d = new AlertDialog.Builder(Reservation.this);
			d.setCancelable(true);
			d.setTitle("Konfirmasi");
			d.setMessage("Apakah data anda sudah benar dan yakin melakukan reservasi?");
			d.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

					AdapterVenues av = (AdapterVenues) spnVenues
							.getSelectedItem();
					String nr = etNama.getText().toString();
					String ar = etAlamat.getText().toString();
					String tr = etTelepon.getText().toString();
					String tglr = tvTanggal.getText().toString();
					AdapterJam aj = (AdapterJam) spnJam.getSelectedItem();
					AdapterDurasi ad = (AdapterDurasi) spnDurasi
							.getSelectedItem();

					final String smsMessage = String.format(
							"%s\n%s\n%s\n%s\n%s\n%s\n%s", av.getValue(), nr,
							ar, tr, tglr, aj.getValue(), ad.getValue());

					try {

						SmsManager smsM = SmsManager.getDefault();
						smsM.sendTextMessage("+6287792021743", null,
								smsMessage, null, null);

						Toast.makeText(getApplicationContext(),
								"Pesan Terkirim", Toast.LENGTH_SHORT).show();

					} catch (Exception e) {

						Toast.makeText(getApplicationContext(),
								"SMS failed, please try again later!",
								Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}

				}
			});

			d.setNegativeButton("Tidak", null);
			d.show();

		}

		return true;

	}
}
