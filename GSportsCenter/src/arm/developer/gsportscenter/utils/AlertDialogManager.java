package arm.developer.gsportscenter.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogManager {
	/**
	 * Function to display simple Alert Dialog
	 * 
	 * @param context
	 *            - application context
	 * @param title
	 *            - alert dialog title
	 * @param message
	 *            - alert message
	 * @param status
	 *            - success/failure (used to set icon) - pass null if you don't
	 *            want icon
	 * */
	public void showAlertDialog(Context context, String title, String message,
			Boolean status) {

		AlertDialog.Builder a = new AlertDialog.Builder(context);

		// Setting Dialog Title
		a.setTitle(title);

		// Setting Dialog Message
		a.setMessage(message);

		if (status != null)
			// Setting alert dialog icon
			a.setIcon((status) ? null : null);

		// Setting OK Button
		a.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		// Showing Alert Message
		a.show();
	}
}