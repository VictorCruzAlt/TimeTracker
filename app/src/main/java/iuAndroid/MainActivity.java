package iuAndroid;

import timetracker.iuandroid.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		int DELAY = 2000;

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				startActivity(intent);

			}
		}, DELAY);

		FloatingActionButton butoPerComensar = (FloatingActionButton) findViewById(R.id.button1);
		butoPerComensar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				startActivity(intent);
			}
		});
		setStatusBarTranslucent(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection

		switch (item.getItemId()) {
			case R.id.action_all:
				Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				String m = null;
				intent.putExtra("proj",m);
				startActivity(intent);
				return true;
			case R.id.action_delete:
				AlertDialog diaBox = AskOption();
				diaBox.show();
				return true;
			case R.id.action_intervals:
				String ma=null;
				Intent intentt = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				intentt.putExtra("task",ma);
				startActivity(intentt);
				return true;
			case R.id.action_report:
				Intent intent_r = new Intent(MainActivity.this, OnCreateReport.class);
				startActivity(intent_r);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	private AlertDialog AskOption()
	{
		AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
				.setTitle("Delete")
				.setMessage("Do you want to Delete")

				.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int whichButton) {
						//your deleting code
						dialog.dismiss();
					}

				})

				.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();

					}
				})
				.create();
		return myQuittingDialogBox;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	protected void setStatusBarTranslucent(boolean makeTranslucent) {
		if (makeTranslucent) {
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		} else {
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
	}

}
