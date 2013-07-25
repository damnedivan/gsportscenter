package arm.developer.gsportscenter.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import arm.developer.gsportscenter.R;

public class ClassesListAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;

	public ClassesListAdapter(Context context, String[] values) {

		super(context, R.layout.list_classes_layout, values);
		this.context = context;
		this.values = values;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_venues_layout, parent,
				false);
		TextView textView = (TextView) rowView.findViewById(R.id.labelClasses);
		ImageView imageView = (ImageView) rowView
				.findViewById(R.id.logoClasses);
		textView.setText(values[position]);

		String s = values[position];

		System.out.println(s);

		if (s.equals("Golf Simulator")) {

			imageView.setImageResource(R.drawable.ic_action_next_item);
		} else if (s.equals("Futsal")) {

			imageView.setImageResource(R.drawable.ic_action_next_item);
		} else if (s.equals("Swimming")) {

			imageView.setImageResource(R.drawable.ic_action_next_item);
		} else if (s.equals("Badminton")) {

			imageView.setImageResource(R.drawable.ic_action_next_item);
		} else if (s.equals("Fitness")) {

			imageView.setImageResource(R.drawable.ic_action_next_item);
		} else {

			imageView.setImageResource(R.drawable.ic_action_next_item);
		}

		return rowView;
	}

}