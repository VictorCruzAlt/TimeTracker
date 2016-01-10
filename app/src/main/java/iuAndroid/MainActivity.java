package iuAndroid;

import timetracker.iuandroid.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private ArrayList<DadesActivitat> llistaDadesActivitats;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.action_bar_activity_main);
		setSupportActionBar(toolbar);

		Button butoPerComensar = (Button) findViewById(R.id.button1);
		butoPerComensar.setOnClickListener(butoPerComensarListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private OnClickListener butoPerComensarListener = new OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
			startActivity(intent);
		}
	};

}
